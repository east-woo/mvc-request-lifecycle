package com.wavus.edu.mvcrequestlifecycle.dto;

public class MyCustomDto {
    private String myParam;

    public MyCustomDto(String myParam) {
        this.myParam = myParam;
    }

    public String getMyParam() {
        return myParam;
    }

    @Override
    public String toString() {
        return "MyCustomDto{myParam='" + myParam + "'}";
    }
}