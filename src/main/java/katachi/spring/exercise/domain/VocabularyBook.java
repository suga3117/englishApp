package katachi.spring.exercise.domain;

import lombok.Data;

@Data
public class VocabularyBook {
	
	private Integer id;
	private Integer createdUserId;
	private String name;
	private String description;
	
	private Users users;
	private String userName;
	

}
