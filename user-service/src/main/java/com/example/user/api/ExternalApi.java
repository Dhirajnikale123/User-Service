package com.example.user.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.user.customException.BusinessException;
import com.example.user.dto.MockApiDto;

@Component
public class ExternalApi {

	@Value("${json.placeholder.api.baseurl}")
	private String externalApiBase;

	@Value("${json.placeholder.api.endpoint}")
	private String externalApiEndpoint;

	@Autowired
	RestTemplate restTemplate;

	@SuppressWarnings("unchecked")
	public List<MockApiDto> getMockDataList(Integer postId) {
		List<MockApiDto> response = new ArrayList<MockApiDto>();
		HttpHeaders headers = new HttpHeaders();
		try {
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			HttpEntity<String> entity = new HttpEntity<String>(headers);
			response = restTemplate.exchange(externalApiBase + externalApiEndpoint + postId + "/comments",
					HttpMethod.GET, entity, List.class).getBody();
		} catch (Exception e) {
			throw new BusinessException("400", "Bad Request");
		}
		return response;
	}
}
