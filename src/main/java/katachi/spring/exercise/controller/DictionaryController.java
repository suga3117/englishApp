package katachi.spring.exercise.controller;

import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import katachi.spring.exercise.domain.Words;
import katachi.spring.exercise.form.GroupOrder;
import katachi.spring.exercise.form.VocabularyForm;
import katachi.spring.exercise.service.DictionaryService;

@Controller
public class DictionaryController {
	
	private final DictionaryService dictionaryService;

	public DictionaryController(DictionaryService dictionaryService) {
		this.dictionaryService = dictionaryService;
	}
	
	@GetMapping("/dictionary")
	public String getDictionary(Model model, VocabularyForm form) {		
	
		return "dictionary";
	}
	
	
	@PostMapping("/search")
	public String postSearch(Model model,  @Validated(GroupOrder.class) VocabularyForm form, BindingResult result) {
		
		if (result.hasErrors()) {
			
			return "dictionary";
			
		}
		
		Words @Nullable [] wordsResponse = dictionaryService.getAllWords(form.getWord());
		
		if(wordsResponse == null) {
			return "dictionary";
		}
		
		model.addAttribute("words", wordsResponse[0]);
		//wordsResponse[0].getMeanings().getFirst().getDefinitions().getFirst().getDefinition();
		
		
		
		return "searchWord";
	}
	
	

}
