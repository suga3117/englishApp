package katachi.spring.exercise.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import katachi.spring.exercise.domain.Vocabulary;
import katachi.spring.exercise.repository.VocabularyMapper;
import katachi.spring.exercise.service.VocabularyService;

@Service
public class VocabularyServiceImpl implements VocabularyService{
	
	@Autowired
	private VocabularyMapper vocabularyMapper;
	
	@Override
	public void add(String word, int userId, String definition, int bookId) {
		vocabularyMapper.add(word, userId, definition, bookId);
	}
	
	@Override
	public Vocabulary getOne(int userId, int bookId){
		return vocabularyMapper.getOne(userId, bookId);
	}
	
	@Override
	public int count(String word, int userId) {
		return vocabularyMapper.count(word, userId);
	}
	
	@Override
	public Vocabulary getOnedefinition(int id) {
		return vocabularyMapper.getOnedefinition(id);
	}
	
	@Override
	public List<Vocabulary> getAll(int userId) {
		return vocabularyMapper.getAll(userId);
	}
	
	@Override
	public List<Vocabulary> getVocabsForExam(int userId) {
		return vocabularyMapper.getVocabsForExam(userId);
	}
	
	@Override
	public List<Vocabulary> getOneForCheck(int userId, int bookId) {
		return vocabularyMapper.getOneForCheck(userId, bookId);
	}
	
	@Override
	public List<Vocabulary> getVocabsForMiniExam(int userId, int bookId) {
		return vocabularyMapper.getVocabsForMiniExam(userId, bookId);
	}
	
	@Override
	public List<Vocabulary> getOneBookForCheck(int bookId) {
		return vocabularyMapper.getOneBookForCheck(bookId);
	}
	
	@Override
	public List<Vocabulary> subscribeBookForMiniExam(int userId, int bookId){
		return vocabularyMapper.subscribeBookForMiniExam(userId, bookId);
	}
}
