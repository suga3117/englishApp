package katachi.spring.exercise.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import katachi.spring.exercise.domain.LoginUser;
import katachi.spring.exercise.domain.Users;
import katachi.spring.exercise.form.LoginUserForm;
import katachi.spring.exercise.form.RegistUserForm;
import katachi.spring.exercise.form.VocabularyForm;
import katachi.spring.exercise.service.SubscribeBookService;
import katachi.spring.exercise.service.UsersService;
import katachi.spring.exercise.service.VocabularyBookService;
import katachi.spring.exercise.service.VocabularyService;

@Controller
public class UsersController {
	
	@Autowired
	private UsersService usersService;
	
	@Autowired
	private VocabularyService vocabularyService;
	
	@Autowired
	private VocabularyBookService vocabularyBookService;
	
	@Autowired
	private SubscribeBookService subscribeBookService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@ModelAttribute("loginUserName")
	public String addLoginUserName(@AuthenticationPrincipal LoginUser loginUser) {
		if (loginUser != null) {
			return loginUser.getName();
		}
		return null;
	}
	
	
	@GetMapping("/regist")
	public String getRegist(Model model,RegistUserForm form) {
		model.addAttribute("registUserForm", form);
		return "regist";
	}
	
	@PostMapping("/regist")
	public String PostRegist(Model model, @AuthenticationPrincipal LoginUser loginUser, @Validated RegistUserForm form, BindingResult result) {
		
		if (result.hasErrors()) {
			
			return "regist";
			
		} else if(usersService.count(form.getEmail()) >= 1) {
			
			model.addAttribute("email", "既に登録されています。");
			
			return "regist";
		}
		
		Users users = modelMapper.map(form, Users.class);
		usersService.regist(users);
		model.addAttribute("newMember", "ユーザー登録しました。");
	
		return "english";
	}
	
	@GetMapping("/login")
	public String getLogin(Model model,LoginUserForm form) {
		model.addAttribute("loginUserForm", form);
		return "login";
	}
	
	@PostMapping("/login")
	public String PostLogin(Model model, @AuthenticationPrincipal LoginUser loginUser, @Validated LoginUserForm form, BindingResult result) {
		
		if (result.hasErrors()) {
			
			return "login";
		}
		
		usersService.getUser(form.getEmail());
		model.addAttribute("logedIn", "ログインしました。");
	
		return "english";
	}
	
	@GetMapping("/mypage")
	public String getMypage(Model model,@AuthenticationPrincipal LoginUser loginUser) {
		model.addAttribute("user", usersService.getUser(loginUser.getUsername()));
		model.addAttribute("vocabularyBookList", vocabularyBookService.getAll(loginUser.getId()));
		
		
		

		
		if(subscribeBookService.getMine(loginUser.getId()).isEmpty()){
			model.addAttribute("nonSubscribeBookList", "お気に入りはありません。");
		}else {
			model.addAttribute("subscribeBookList", subscribeBookService.getMine(loginUser.getId())); 
		
		}
		return "mypage";
	}
	
	//
	@GetMapping("/eachVocabularyBook/{id}")
	public String getEachVocabularyBook(Model model, @PathVariable("id") Integer id, @AuthenticationPrincipal LoginUser loginUser) {
		
		model.addAttribute("vocabularyList", vocabularyService.getOneForCheck(loginUser.getId(), id));
		model.addAttribute("bookId", id);
		

		return "eachVocabularyBook";
	}
	
	
	@GetMapping("/exam")
	public String getExam(Model model, @AuthenticationPrincipal LoginUser loginUser, VocabularyForm form) {	
		
		model.addAttribute("vocabList", vocabularyService.getVocabsForExam(loginUser.getId()));
	
		return "exam";
	}
	
	@PostMapping("/exam")
	public String postExam(Model model, @AuthenticationPrincipal LoginUser loginUser, VocabularyForm form) {	
		
		int correctCount = 0;

		if (form.getOk() != null) {
			correctCount = form.getOk().size();
		}

		model.addAttribute("correctCount", correctCount);
		return "examResult";
	}
	
	@GetMapping("/miniExam/{bookId}")
	public String getMiniExam(Model model, @PathVariable("bookId") Integer bookId, @AuthenticationPrincipal LoginUser loginUser, VocabularyForm form) {	
		
		if(!vocabularyService.getVocabsForMiniExam(loginUser.getId(), bookId).isEmpty()) {
			model.addAttribute("vocabList", vocabularyService.getVocabsForMiniExam(loginUser.getId(), bookId));
		} else {
			model.addAttribute("vocabList", vocabularyService.subscribeBookForMiniExam(loginUser.getId(), bookId));
		}
		return "exam";
	}
	
	@PostMapping("/miniExam")
	public String postMiniExam(Model model, @AuthenticationPrincipal LoginUser loginUser, VocabularyForm form) {	
		
		int correctCount = 0;

		if (form.getOk() != null) {
			correctCount = form.getOk().size();
		}

		model.addAttribute("correctCount", correctCount);
		return "examResult";
	}

}
