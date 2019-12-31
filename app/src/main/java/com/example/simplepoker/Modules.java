package com.example.simplepoker;

public class Modules {
    String name;
    Class<?> moduleClass;

    Modules(String name, Class<?> className) {
        this.name = name;
        this.moduleClass = className;
    }

    @Override
    public String toString() {
        return name;
    }
}
