package katachi.spring.exercise.domain;

import lombok.Data;

@Data
public class Vocabulary {
	
	private Integer id;
	private Integer bookId;
	private String word;
	private Integer userId;
	private String definition;
	
	private Card card;
	private VocabularyBook vocabularyBook;
	private SubscribeBook subscribeBook;

}
