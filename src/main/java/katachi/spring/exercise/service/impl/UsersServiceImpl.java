package katachi.spring.exercise.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import katachi.spring.exercise.domain.Users;
import katachi.spring.exercise.repository.UsersMapper;
import katachi.spring.exercise.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService{
	
	@Autowired
	private UsersMapper usersMapper;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Override
	public Users regist(Users users) {
		String rawPassword = users.getPassword();
		users.setPassword(encoder.encode(rawPassword));
		return usersMapper.regist(users);
	}
	
	@Override
	public Users getUser(String email) {
		return usersMapper.getUser(email);

	}
	
	@Override
	public int count(String email) {
		return usersMapper.count(email);
	}

}
