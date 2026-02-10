package katachi.spring.exercise.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import katachi.spring.exercise.domain.SubscribeBook;
import katachi.spring.exercise.repository.SubscribeBookMapper;
import katachi.spring.exercise.service.SubscribeBookService;

@Service
public class SubscribeBookServiceImpl implements SubscribeBookService{
	
	@Autowired
	private SubscribeBookMapper subscribeBookMapper;
	
	@Override
	public void add(int userId, int bookId) {
		subscribeBookMapper.add(userId, bookId);
	}
	
	@Override
	public int count(int userId, int bookId) {
		return subscribeBookMapper.count(userId, bookId);
	}
	
	@Override
	public List<SubscribeBook> getMine(int userId){
		return subscribeBookMapper.getMine(userId);	
	}

}
