package katachi.spring.exercise.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import katachi.spring.exercise.repository.AdditionMapper;
import katachi.spring.exercise.service.AdditionService;

@Service
public class AdditionServiceImpl implements AdditionService{
	
	@Autowired
	private AdditionMapper additionMapper;
	
	@Override
	public void add(int userId) {
		additionMapper.add(userId);
	}

}
