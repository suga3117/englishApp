package katachi.spring.exercise.domain;

import java.util.Date;

import lombok.Data;

@Data
public class SubscribeBook {
	
	private Integer id;
	private Integer userId;
	private Integer bookId;
	private Date subscribeDate;	
	
	private VocabularyBook vocabularyBook;

}
