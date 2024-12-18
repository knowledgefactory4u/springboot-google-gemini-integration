package com.knf.dev.dto;

// UsageMetadata class representing the "usageMetadata" object
public class UsageMetadata {
	private int promptTokenCount;
	private int candidatesTokenCount;
	private int totalTokenCount;

	// Getters and Setters
	public int getPromptTokenCount() {
		return promptTokenCount;
	}

	public void setPromptTokenCount(int promptTokenCount) {
		this.promptTokenCount = promptTokenCount;
	}

	public int getCandidatesTokenCount() {
		return candidatesTokenCount;
	}

	public void setCandidatesTokenCount(int candidatesTokenCount) {
		this.candidatesTokenCount = candidatesTokenCount;
	}

	public int getTotalTokenCount() {
		return totalTokenCount;
	}

	public void setTotalTokenCount(int totalTokenCount) {
		this.totalTokenCount = totalTokenCount;
	}
}