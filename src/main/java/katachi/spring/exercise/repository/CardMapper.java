package katachi.spring.exercise.repository;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CardMapper {
	
	public void add(int userId);
	
	public void updateGood(int id);
	
	public void updateBad(int id);
}
