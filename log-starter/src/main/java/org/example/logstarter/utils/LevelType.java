package org.example.logstarter.utils;

public enum LevelType {

    DEBUG ("DEBUG"),
    INFO ("INFO"),
    WARN ("WARN"),
    ERROR ("ERROR");

    final String name;

    LevelType (String name) {
        this.name = name;
    }

}
