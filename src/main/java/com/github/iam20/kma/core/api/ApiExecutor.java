package com.github.iam20.kma.core.api;

import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.net.URISyntaxException;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

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
		T result;
		try {
			result = restTemplate.exchange(uri, HttpMethod.GET, responseHttpEntity, type).getBody();
		} catch (RestClientException e) {
			log.info("The item is not exists check the time and x, y");
			try {
				result = type.getConstructor().newInstance();
			} catch (NoSuchMethodException | IllegalAccessException
					| InvocationTargetException | InstantiationException e1) {
				result = null;
			}
		}
		return result;
	}
}
