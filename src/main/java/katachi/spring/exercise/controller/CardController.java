package katachi.spring.exercise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import katachi.spring.exercise.domain.LoginUser;
import katachi.spring.exercise.domain.Vocabulary;
import katachi.spring.exercise.form.VocabularyForm;
import katachi.spring.exercise.service.CardService;
import katachi.spring.exercise.service.VocabularyBookService;
import katachi.spring.exercise.service.VocabularyService;

@Controller
public class CardController {
	
	@Autowired
	private VocabularyService vocabularyService;
	
	@Autowired
	private CardService cardService;
	
	@Autowired
	private VocabularyBookService vocabularyBookService;
	
	@GetMapping("/cardTop")
	public String getCardTop(Model model, VocabularyForm form, @AuthenticationPrincipal LoginUser loginUser) {
		
		model.addAttribute("vocabularyBookList", vocabularyBookService.getAll(loginUser.getId()));
	
		return "cardTop";
	}
	
	
	@PostMapping("/card")
	public String getCard(Model model, VocabularyForm form, @AuthenticationPrincipal LoginUser loginUser) {
		System.out.println(loginUser.getId() + " " +form.getBookId());
		Vocabulary vocab =  vocabularyService.getOne(loginUser.getId(), form.getBookId());
		
		model.addAttribute("vocabularyForm", vocab);
	
		return "card";
	}
	
	@PostMapping("/understand")
	public String getUnderstand(Model model, @AuthenticationPrincipal LoginUser loginUser, VocabularyForm form) {	
		
		model.addAttribute("vocabularyForm", vocabularyService.getOnedefinition(form.getId()));
	
		return "understand";
	}
	
	@PostMapping("/good")
	public String postFlash(Model model, VocabularyForm form, @AuthenticationPrincipal LoginUser loginUser) {
	
		cardService.updateGood(form.getId());
	
		return getCard(model, form, loginUser);
	}
	
	@PostMapping("/bad")
	public String postBad(Model model, VocabularyForm form, @AuthenticationPrincipal LoginUser loginUser) {
		
		cardService.updateBad(form.getId());
		
		return getCard(model, form, loginUser);
	}
	
	

}
