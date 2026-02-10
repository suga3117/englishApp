package katachi.spring.exercise.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import katachi.spring.exercise.repository.CardMapper;
import katachi.spring.exercise.service.CardService;

@Service
public class CardServiceImpl implements CardService{
	
	@Autowired
	private CardMapper cardMapper;
	
	@Override
	public void add(int userId) {
		cardMapper.add(userId);
	}
	
	@Override
	public void updateGood(int id) {
		cardMapper.updateGood(id);
	}
	
	@Override
	public void updateBad(int id) {
		cardMapper.updateBad(id);
	}


}
