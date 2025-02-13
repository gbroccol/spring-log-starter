package org.example.application.model;

import com.fasterxml.jackson.annotation.JsonCreator;

public class TestDto {
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @JsonCreator
    public TestDto(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "TestDto{" +
                "text='" + text + '\'' +
                '}';
    }

    private String text;
}
