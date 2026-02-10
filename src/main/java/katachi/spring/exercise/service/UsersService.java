package katachi.spring.exercise.service;

import katachi.spring.exercise.domain.Users;

public interface UsersService {
	
	public Users regist(Users users);
	
	public Users getUser(String email);
	
	public int count(String email);
	

}
