package katachi.spring.exercise.repository;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdditionMapper {
	
	public void add(int userId);

}
