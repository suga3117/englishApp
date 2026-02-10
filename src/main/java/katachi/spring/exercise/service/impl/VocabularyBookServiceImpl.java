package katachi.spring.exercise.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import katachi.spring.exercise.domain.VocabularyBook;
import katachi.spring.exercise.repository.VocabularyBookMapper;
import katachi.spring.exercise.service.VocabularyBookService;

@Service
public class VocabularyBookServiceImpl implements VocabularyBookService{
	
	@Autowired
	private VocabularyBookMapper vocabularyBookMapper;
	
	@Override
	public void add(int userId, String name, String description) {
		vocabularyBookMapper.add(userId, name, description);
	}
	
	@Override
	public int count(String name, int userId) {
		return vocabularyBookMapper.count(name, userId);
	}
	
	@Override
	public List<VocabularyBook> getAll(int userId){
		return vocabularyBookMapper.getAll(userId);
	}
	
	@Override
	public List<VocabularyBook> getAllBook(){
		return vocabularyBookMapper.getAllBook();
	}
}
