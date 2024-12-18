package com.knf.dev.dto;

import java.util.List;

// Root class representing the entire JSON response
public class ApiResponse {
	private List<Candidate> candidates;
	private UsageMetadata usageMetadata;
	private String modelVersion;

	// Getters and Setters
	public List<Candidate> getCandidates() {
		return candidates;
	}

	public void setCandidates(List<Candidate> candidates) {
		this.candidates = candidates;
	}

	public UsageMetadata getUsageMetadata() {
		return usageMetadata;
	}

	public void setUsageMetadata(UsageMetadata usageMetadata) {
		this.usageMetadata = usageMetadata;
	}

	public String getModelVersion() {
		return modelVersion;
	}

	public void setModelVersion(String modelVersion) {
		this.modelVersion = modelVersion;
	}

}
