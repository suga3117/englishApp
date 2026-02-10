package katachi.spring.exercise.service;

import java.util.List;

import katachi.spring.exercise.domain.Vocabulary;

public interface VocabularyService {
	
	public void add(String word, int userId, String definition, int bookId);
	
	public Vocabulary getOne(int userId, int bookId);
	
	public int count(String word, int userId);
	
	public Vocabulary getOnedefinition(int id);
	
	public List<Vocabulary> getAll(int userId);
	
	public List<Vocabulary> getVocabsForExam(int userId);
	
	public List<Vocabulary> getOneForCheck(int userId, int bookId);
	
	public List<Vocabulary> getVocabsForMiniExam(int userId, int bookId);
	
	public List<Vocabulary> getOneBookForCheck(int bookId);
	
	public List<Vocabulary> subscribeBookForMiniExam(int userId, int bookId);

}
