package katachi.spring.exercise.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import katachi.spring.exercise.domain.VocabularyBook;

@Mapper
public interface VocabularyBookMapper {
	
	public void add(int userId, String name, String description);
	
	public int count(String name, int userId);

	public List<VocabularyBook> getAll(int userId);
	
	public List<VocabularyBook> getAllBook();
}
