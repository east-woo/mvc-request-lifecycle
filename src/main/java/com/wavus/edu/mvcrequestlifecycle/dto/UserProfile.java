package com.wavus.edu.mvcrequestlifecycle.dto;

public class UserProfile {
    private String userId;
    private String description;

    public UserProfile(String userId, String description) {
        this.userId = userId;
        this.description = description;
    }

    public String getUserId() {
        return userId;
    }

    public String getDescription() {
        return description;
    }
}