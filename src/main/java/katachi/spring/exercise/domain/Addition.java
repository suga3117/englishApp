package katachi.spring.exercise.domain;

import java.util.Date;

import lombok.Data;

@Data
public class Addition {
	
	private Integer id;
	private Date addedDate;
	private Integer userId;

}
