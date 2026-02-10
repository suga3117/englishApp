package katachi.spring.exercise.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import katachi.spring.exercise.domain.SubscribeBook;

@Mapper
public interface SubscribeBookMapper {
	
	public void add(int userId, int bookId);
	
	public int count(int userId, int bookId);
	
	public List<SubscribeBook> getMine(int userId);

}
