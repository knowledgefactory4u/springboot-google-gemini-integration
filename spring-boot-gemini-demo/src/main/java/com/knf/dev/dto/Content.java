package com.knf.dev.dto;

import java.util.List;

// Content class representing the "content" object
public class Content {
    private List<Part> parts;
    private String role;

    // Getters and Setters
    public List<Part> getParts() {
        return parts;
    }

    public void setParts(List<Part> parts) {
        this.parts = parts;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

	@Override
	public String toString() {
		return "Content [parts=" + parts + ", role=" + role + "]";
	}
}
