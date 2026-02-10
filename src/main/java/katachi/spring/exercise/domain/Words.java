package katachi.spring.exercise.domain;

import java.util.List;

import lombok.Data;

@Data
public class Words {
	
	private String word;
	
	private List <Meanings> meanings;
	
	List<Phonetics> phonetics;


}
