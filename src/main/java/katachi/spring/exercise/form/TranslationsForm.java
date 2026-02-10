package katachi.spring.exercise.form;

import lombok.Data;

@Data
public class TranslationsForm {
	
	private String detectedSourceLanguage;
	private String text;
	
	private String sentence;

}
