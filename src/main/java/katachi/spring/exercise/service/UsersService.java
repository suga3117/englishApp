package katachi.spring.exercise.service;

import katachi.spring.exercise.domain.Users;

public interface UsersService {
	
	public Integer regist(Users users);
	
	public Users getUser(String email);
	
	public Integer count(String email);
	

}
