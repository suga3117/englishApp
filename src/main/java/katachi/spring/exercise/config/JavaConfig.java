package katachi.spring.exercise.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("katachi.spring.exercise.repository")
public class JavaConfig {
	
	@Bean
	ModelMapper modelMapper() {
		
		ModelMapper modelMapper = new ModelMapper();
		//マッチング戦略を厳しいものに設定
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		//型の完全マッチなど
		modelMapper.getConfiguration().setFullTypeMatchingRequired(true);
		return modelMapper;
	}
}