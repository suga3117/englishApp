package katachi.spring.exercise.repository;

import org.apache.ibatis.annotations.Mapper;

import katachi.spring.exercise.domain.Users;

@Mapper
public interface UsersMapper {
	
	public Integer regist(Users users);
	
	public Users getUser(String email);
	
	public Integer count(String email);

}
