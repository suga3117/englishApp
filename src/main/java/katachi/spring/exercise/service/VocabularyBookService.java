package katachi.spring.exercise.service;

import java.util.List;

import katachi.spring.exercise.domain.VocabularyBook;

public interface VocabularyBookService {
	
	public void add(int userId, String name, String description);
	
	public int count(String name, int userId);
	
	public List<VocabularyBook> getAll(int userId);

	public List<VocabularyBook> getAllBook();
}
