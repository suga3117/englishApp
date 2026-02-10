package katachi.spring.exercise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import katachi.spring.exercise.domain.LoginUser;
import katachi.spring.exercise.form.VocabularyBookForm;
import katachi.spring.exercise.form.VocabularyForm;
import katachi.spring.exercise.service.SubscribeBookService;
import katachi.spring.exercise.service.VocabularyBookService;
import katachi.spring.exercise.service.VocabularyService;

@Controller
public class SubscribeBookController {
	
	@Autowired
	private SubscribeBookService subscribeBookService;
	
	@Autowired
	private VocabularyBookService vocabularyBookService;
	
	@Autowired
	private VocabularyService vocabularyService;
	
	@GetMapping("/book")
	public String getNotes(Model model, VocabularyBookForm form) {	
		
		model.addAttribute("vocabularyBook", vocabularyBookService.getAllBook());
	
		return "book";
	}
	
	@GetMapping("/subscribeBook/{id}")
	public String getEachVocabularyBook(Model model, @PathVariable("id") Integer id, @AuthenticationPrincipal LoginUser loginUser) {
		
		if(subscribeBookService.count(loginUser.getId(), id) >= 1) {
			model.addAttribute("areldyAdded", "既にお気に入り登録されています。");
			return getBook(model, id, loginUser);
		}
		subscribeBookService.add(loginUser.getId(), id);
		model.addAttribute("areldyAdded", "お気に入り登録されました。");

		return getBook(model, id, loginUser);
	}
	
	@GetMapping("/eachBook/{id}")
	public String getBook(Model model, @PathVariable("id") Integer id, @AuthenticationPrincipal LoginUser loginUser) {
		
		model.addAttribute("vocabularyList", vocabularyService.getOneBookForCheck( id));
		model.addAttribute("bookId", id);
		
		return "eachBook";
	}
	
	@GetMapping("/bookMiniExam/{bookId}")
	public String getBookMiniExam(Model model, @PathVariable("bookId") Integer bookId, @AuthenticationPrincipal LoginUser loginUser, VocabularyForm form) {	
		
		model.addAttribute("vocabList", vocabularyService.subscribeBookForMiniExam(loginUser.getId(), bookId));
	
		return "exam";
	}

}
