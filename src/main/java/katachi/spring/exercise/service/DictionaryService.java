package katachi.spring.exercise.service;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import katachi.spring.exercise.domain.MeaningsResponse;
import katachi.spring.exercise.domain.PhoneticsResponse;
import katachi.spring.exercise.domain.Words;

@Service
public class DictionaryService {
	
	@Value("${English.api.url}")
	private String apiUrl;
	
	private final RestTemplate restTemplate = new RestTemplate();
	
	public Words @Nullable [] getAllWords(String word) {
		String url = apiUrl + "/" + word;

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(java.util.List.of(MediaType.APPLICATION_JSON));

		HttpEntity<String> entity = new HttpEntity<>(headers);
		ResponseEntity<Words[]> response = restTemplate.exchange(url, HttpMethod.GET, entity, Words[].class);

		return response.getBody();
	}
	
	public MeaningsResponse getAllMeanings(String word) {
		String url = apiUrl + "/" + word;

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(java.util.List.of(MediaType.APPLICATION_JSON));

		HttpEntity<String> entity = new HttpEntity<>(headers);
		ResponseEntity<MeaningsResponse> response = restTemplate.exchange(
				url, HttpMethod.GET, entity, MeaningsResponse.class);

		return response.getBody();
	}
	
	public PhoneticsResponse getAudio(String word) {
		String url = apiUrl + "/" + word;

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(java.util.List.of(MediaType.APPLICATION_JSON));

		HttpEntity<String> entity = new HttpEntity<>(headers);
		ResponseEntity<PhoneticsResponse> response = restTemplate.exchange(
				url, HttpMethod.GET, entity, PhoneticsResponse.class);

		return response.getBody();
	}

}
