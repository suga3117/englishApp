package katachi.spring.exercise.form;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class VocabularyBookForm {
	
	private Integer id;
	private Integer createdUserId;
	
	@NotBlank(message="単語帳名を入力してください。")
	@Length(max = 100)
	private String name;
	
	@NotBlank
	private String description;

}
