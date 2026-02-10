package katachi.spring.exercise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import katachi.spring.exercise.domain.LoginUser;
import katachi.spring.exercise.form.VocabularyBookForm;
import katachi.spring.exercise.service.VocabularyBookService;

@Controller
public class VocabularyBookController {
	
	@Autowired
	private VocabularyBookService vocabularyBookService;
	
	
	@GetMapping("/vocabularyBook")
	public String getVocabularyBook(Model model, VocabularyBookForm form) {		
	
		return "vocabularyBook";
	}
	
	@PostMapping("/vocabularyBook")
	public String PostVocabularyBook(Model model, @AuthenticationPrincipal LoginUser loginUser, @Validated VocabularyBookForm form, BindingResult result) {
		
		if (result.hasErrors()) {
			
			return "vocabularyBook";
			
		} else if(vocabularyBookService.count(form.getName(), loginUser.getId()) >= 1) {
			
			model.addAttribute("vocabularyBook", "既に登録されています。");
			
			return "vocabularyBook";
		}
		
		vocabularyBookService.add(loginUser.getId(), form.getName(), form.getDescription());
		
		model.addAttribute("vocabularyBook", "登録しました。");
	
		return "vocabularyBook";
	}

}
