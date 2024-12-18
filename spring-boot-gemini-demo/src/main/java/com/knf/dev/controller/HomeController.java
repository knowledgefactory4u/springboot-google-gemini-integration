package com.knf.dev.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.knf.dev.dto.ApiResponse;
import com.knf.dev.dto.Candidate;
import com.knf.dev.service.GeminiApiService;

@Controller
public class HomeController {
	@Autowired
	private GeminiApiService geminiApiService;

	@Autowired
	private ObjectMapper objectMapper;

	// Display the form
	@GetMapping("/")
	public String showForm() {
		return "index";
	}

	// Handle the form submission and generate the response
	@PostMapping("/submit")
	public String handleFormSubmission(@RequestParam("userInput") String userInput, Model model)
			throws JsonMappingException, JsonProcessingException {

		String op = geminiApiService.generateContent(userInput);

		ApiResponse response = objectMapper.readValue(op, ApiResponse.class);

		List<Candidate> c = response.getCandidates();
		String output = c.get(0).getContent().getParts().get(0).getText();

		// Add result to the model
		model.addAttribute("result", output);

		// Return the same form with the result to be displayed as a paragraph
		return "index";
	}

}