package cs.hanyang.stu.kma.core.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@Slf4j
public class ApiExecutor {
	public static <T> T executeApi(String url, Class<T> type) {
		URI uri;
		try {
			uri = new URI(url);
		} catch (URISyntaxException e) {
			log.error(e.getMessage());
			uri = URI.create(url);
		}
		HttpHeaders headers = new HttpHeaders();
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<T> responseHttpEntity = new HttpEntity<>(headers);

		return restTemplate.exchange(uri, HttpMethod.GET, responseHttpEntity, type).getBody();
	}
}
