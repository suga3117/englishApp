package katachi.spring.exercise.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import katachi.spring.exercise.domain.LoginUser;
import katachi.spring.exercise.form.GroupOrder;
import katachi.spring.exercise.form.VocabularyForm;
import katachi.spring.exercise.service.AdditionService;
import katachi.spring.exercise.service.CardService;
import katachi.spring.exercise.service.VocabularyBookService;
import katachi.spring.exercise.service.VocabularyService;

@Controller
public class AdditionController {
	
	@Autowired
	private VocabularyService vocabularyService;
	
	@Autowired
	private CardService cardService;
	
	@Autowired
	private VocabularyBookService vocabularyBookService;
	
	@Autowired
	private AdditionService additionService;
	
	@ModelAttribute("loginUserName")
	public String addLoginUserName(@AuthenticationPrincipal LoginUser loginUser) {
		if (loginUser != null) {
			return loginUser.getName();
		}
		return null;
	}
	
	@GetMapping("/addition")
	public String getAddition(Model model, VocabularyForm form, @AuthenticationPrincipal LoginUser loginUser) {
		
		model.addAttribute("vocabularyBookList", vocabularyBookService.getAll(loginUser.getId()));
	
		return "addition";
	}
	
	@PostMapping("/add")
	public String PostNewWord(Model model, @AuthenticationPrincipal LoginUser loginUser, @Validated(GroupOrder.class) VocabularyForm form, BindingResult result) {
		
		if (result.hasErrors()) {
			
			return getAddition(model, form, loginUser);
			
		} else if(vocabularyService.count(form.getWord(), loginUser.getId()) >= 1) {
			
			model.addAttribute("addedWord", "既に登録されています。");
			
			return "addition";

		}
	
		vocabularyService.add(form.getWord(), loginUser.getId(), form.getDefinition(), form.getBookId());
		cardService.add(loginUser.getId());
		additionService.add(loginUser.getId());
		model.addAttribute("addedWord", "登録しました。");
	
		return getAddition(model, form, loginUser);
	}
	
	@GetMapping("/index")
	public String getIndex(Model model, VocabularyForm form, @AuthenticationPrincipal LoginUser loginUser) {		
		
		model.addAttribute("vocabularyBookList", vocabularyBookService.getAll(loginUser.getId()));
	
		return "index";
	}
	
	@PostMapping("/upload")
	public String upload(@RequestParam MultipartFile file, VocabularyForm form, @AuthenticationPrincipal LoginUser loginUser) throws IOException {
		String uploadDir = "csv/";
		Path path = Paths.get(uploadDir + file.getOriginalFilename());
		Files.createDirectories(path.getParent());
		Files.write(path, file.getBytes());
		
		File f = new File(path.toUri());
		try (BufferedReader br = new BufferedReader(new FileReader(f))) {
			
			String line;
						
			while ((line = br.readLine()) != null) {
				System.out.println("Line: " + line);
				String[] data = line.split(","); // 行をカンマ区切りで配列に変換

				vocabularyService.add(data[0], loginUser.getId(), data[1], form.getBookId());
				cardService.add(loginUser.getId());
				additionService.add(loginUser.getId());
			}
		}
		return "uploadResult";
	}

}
