package katachi.spring.exercise.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.deepl.api.DeepLClient;
import com.deepl.api.DeepLException;
import com.deepl.api.TextResult;


@Service
public class TranslationsService {
	
	@Value("${Translation.api.url}")
	private static String apiUrl;
	
	public static void main(String[] args) throws DeepLException, InterruptedException {
		String authKey = apiUrl; // replace with your key
		DeepLClient client = new DeepLClient(authKey);

		TextResult result = client.translateText("Hello, world!", null, "de");
		System.out.println(result.getText());
		}

}
