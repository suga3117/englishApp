package katachi.spring.exercise.service;

import java.util.List;

import katachi.spring.exercise.domain.SubscribeBook;

public interface SubscribeBookService {

	public void add(int userId, int bookId);
	
	public int count(int userId, int bookId);
	
	public List<SubscribeBook> getMine(int userId);
}
