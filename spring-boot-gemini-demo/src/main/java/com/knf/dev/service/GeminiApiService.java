package com.knf.dev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.knf.dev.dto.ContentRequest;

@Service
public class GeminiApiService {

	@Value("${gemini.api.key}")
	private String apiKey;

	public String generateContent(String str) {

		String apiUrl = "https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash:generateContent?key="
				+ apiKey;
		RestTemplate restTemplate = new RestTemplate();

		// Build the request body
		ContentRequest contentRequest = new ContentRequest();
		ContentRequest.Content content = new ContentRequest.Content();
		content.setParts(List.of(new ContentRequest.Content.Part(str)));
		contentRequest.setContents(List.of(content));

		// Set the request headers
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		// Prepare the request entity with body and headers
		HttpEntity<ContentRequest> entity = new HttpEntity<>(contentRequest, headers);

		// Send POST request to the API
		try {
			ResponseEntity<String> response = restTemplate.exchange(apiUrl, HttpMethod.POST, entity, String.class);
			return response.getBody();
		} catch (Exception e) {
			e.printStackTrace();
			return "Error occurred: " + e.getMessage();
		}
	}
}
