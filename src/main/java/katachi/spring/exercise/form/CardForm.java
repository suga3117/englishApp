package katachi.spring.exercise.form;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CardForm {
	
	private Integer id;
	
	@NotNull
	@Min(value = 1)
	@Max(value = 1)
	private Integer good;
	
	@NotNull
	@Min(value = 1)
	@Max(value = 1)
	private Integer bad;

}
