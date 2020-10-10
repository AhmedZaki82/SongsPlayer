package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Album {

    String albumName;
    ArrayList<Song> songsArrayList;

    public Album(String albumName) {
        this.albumName = albumName;
        this.songsArrayList = new ArrayList<>();
    }

    public String getAlbumName() {
        return albumName;
    }
}
