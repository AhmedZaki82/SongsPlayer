package com.company;

public class Song {

    private String name;
    private String duration;

    public Song(String name, String duration) {
        this.name = name;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public String getDuration() {
        return duration;
    }
}
