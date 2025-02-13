package org.example.application.model;

import com.fasterxml.jackson.annotation.JsonCreator;

public class TestDtoRequest {

    private String name;

    public String getName() {
        return name;
    }

    @JsonCreator
    public TestDtoRequest(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TestDtoRequest{" +
                "name='" + name + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }
}
