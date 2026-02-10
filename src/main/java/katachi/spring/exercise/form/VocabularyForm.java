package katachi.spring.exercise.form;

import java.util.List;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class VocabularyForm {
	
	private Integer id;
	
	@NotNull(groups=ValidGroup1.class)
	private Integer bookId;
	
	@NotBlank(message="{word.NotBlank}", groups=ValidGroup1.class)
	@Length(max = 100, groups=ValidGroup1.class)
	@Pattern(regexp = "^[a-zA-Z]+$", message = "{word.Pattern}", groups=ValidGroup2.class)
	private String word;
	private Integer good;
	private Integer bad;
	private String definition;
	
	private String name;
	
	private List<Integer> ok;

}
