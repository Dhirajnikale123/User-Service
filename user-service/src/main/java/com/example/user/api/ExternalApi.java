package com.example.user.api;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Component
public class ExternalApi {

	@Value("json.placeholder.api")
	private String jsonPlaceHolderApi;

	@Autowired
	RestTemplate restTemplate;

	@RequestMapping(value = "/template")
	 public String getProductList() {
	      HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity <String> entity = new HttpEntity<String>(headers);
	      return restTemplate.exchange(jsonPlaceHolderApi, HttpMethod.GET, entity, String.class).getBody();
	   }

}
