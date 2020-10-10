package com.company;

import java.util.*;

public class Playlist {

    private LinkedList<Song> songLinkedList;
    private ArrayList<Album> albumsArrayList;
    private Scanner scanner = new Scanner(System.in);

    public Playlist() {
        this.songLinkedList = new LinkedList<>();
        this.albumsArrayList = new ArrayList<>();
    }

    private void printAlbumMenu() {

        System.out.println("\n0.Print Album Menu.\t" + "1.Add New Album.\t" + "2.Add New Song to the Album!\t" +
                "3.Display Albums!\t" + "4.Display Album Songs\t\n" + "5.Add a Song to the Playlist!\t" +
                "6.Remove Song List!\t" + "7.Display List Songs!\t" + "8.Enter the Playlist!\t" + "9.Exit!");
    }

    private void printPlaylistMenu() {
        System.out.println("\n0.Print the Playlist!\t" + "1.Next Song!\t" + "2.Previous Song!\t" +
                "3.Repeat the current Song\t" + "4.Display Playlist Songs!\t" + "5.Exit!");
    }

    public void album() {
        printAlbumMenu();
        boolean cont = true;
        ListIterator<Song> songListIterator = songLinkedList.listIterator();

        while (cont) {
            System.out.println("Choose an action: ");
            int action = scanner.nextInt();

            switch (action) {

                case 0:
                    printAlbumMenu();
                    break;

                case 1:
                    createAlbum();
                    break;

                case 2:
                    albumAddSong();
                    break;

                case 3:
                    displayAlbums();
                    break;

                case 4:
                    displayAlbumSongs();
                    break;

                case 5:
                    playlistAddSong();
                    break;

                case 6:
                    removeSong();
                    break;

                case 7:
                    displayPlaylist();
                    break;

                case 8:
                    playlist();
                    break;
            }
        }
    }

    public void playlist() {

        boolean cont = true;
        ListIterator<Song> listIterator = songLinkedList.listIterator();
        printPlaylistMenu();
        boolean forward = true;

        while (cont) {
            System.out.println("Choose:");
            int choose = scanner.nextInt();


            switch (choose) {

                case 0:
                    printPlaylistMenu();
                    break;

                case 1:

                    if (!forward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }

                        forward = true;
                    }

                    if (listIterator.hasNext()) {
                        System.out.println(listIterator.next().getName());
                        forward = true;
                    } else {
                        System.out.println("We are at the end of the Playlist!");
                        forward = false;

                    }


                    break;

                case 2:

                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }

                        forward = false;
                    }

                    if (listIterator.hasPrevious()) {
                        System.out.println(listIterator.previous().getName());
                        forward = false;
                    } else {

                        System.out.println("We are at the first of the Playlist!");
                        forward = true;
                    }
                    break;

                case 3:

                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            System.out.println(listIterator.previous().getName());
                            forward = false;
                        }

                    } else {
                        if (listIterator.hasNext()) {
                            System.out.println(listIterator.next().getName());
                            forward = true;
                        }

                    }

                    break;

                case 4:
                    displayPlaylist();
                    break;

                case 5:
                    cont = false;
                    break;
            }
        }
    }

    private void albumAddSong(String albumName, String songName, String songDuration) {


        boolean isThere = false;

        for (int i = 0; i < albumsArrayList.size(); i++) {

            if (albumsArrayList.get(i).getAlbumName().equals(albumName)) {

                for (int j = 0; j < albumsArrayList.get(i).songsArrayList.size(); j++) {
                    if (albumsArrayList.get(i).songsArrayList.get(j).getName().equals(songName)) {
                        System.out.println(songName + " Song is already exist in the Album!");
                        isThere = true;
                    }
                }

                if (isThere){

                    break;
                }else{

                    albumsArrayList.get(i).songsArrayList.add(new Song(songName, songDuration));
                }
            }
        }
    }


    private void albumAddSong() {
        System.out.println("Enter the Album Name:");
        String albumName = scanner.next();
        albumName += scanner.nextLine();

        System.out.println("Enter the Song Name:");
        String songName = scanner.next();
        songName += scanner.nextLine();

        System.out.println("Enter the Song Duration:");
        String songDuration = scanner.next();
        songDuration += scanner.nextLine();

        albumAddSong(albumName,songName,songDuration);
    }

    private void createAlbum(String albumName) {

        boolean isThere = false;

        for (int i = 0; i < albumsArrayList.size(); i++) {

            if (albumsArrayList.get(i).getAlbumName().equals(albumName)) {
                System.out.println(albumsArrayList.get(i).getAlbumName() + " Album is already exist!");
                isThere = true;
            }
        }

        if (isThere) {

        } else {

            albumsArrayList.add(new Album(albumName));
        }

    }

    private void createAlbum() {
        System.out.println("Enter the Album Name:");
        String albumName = scanner.next();
        albumName += scanner.nextLine();

        createAlbum(albumName);
    }

    private void displayAlbums() {

        if (albumsArrayList.isEmpty()) {
            System.out.println("There is no albums yet!");
        }

        if (!albumsArrayList.isEmpty()) {
            if (albumsArrayList.size() > 1) {
                System.out.println("The albums are: ");
            } else {
                System.out.println("The album is: ");
            }
        }
        for (int i = 0; i < albumsArrayList.size(); i++) {
            System.out.println((i+1) + "." + albumsArrayList.get(i).getAlbumName());
        }
    }

    private void displayAlbumSongs(String albumName) {

        boolean isThere = false;

        for (int i = 0; i < albumsArrayList.size(); i++) {

            if (albumsArrayList.get(i).getAlbumName().equals(albumName)) {

                if (albumsArrayList.get(i).songsArrayList.isEmpty()) {
                    System.out.println("There is no songs in the " + albumsArrayList.get(i).getAlbumName() +
                            " album!");
                    isThere = true;
                }

                if (!albumsArrayList.get(i).songsArrayList.isEmpty()) {

                    if (albumsArrayList.get(i).songsArrayList.size() > 1) {
                        System.out.println("The songs in album " + albumsArrayList.get(i).getAlbumName() + " are:");
                    } else {
                        System.out.println("The song in album " + albumsArrayList.get(i).getAlbumName() + " is:");
                    }
                }
                for (int j = 0; j < albumsArrayList.get(i).songsArrayList.size(); j++) {
                    System.out.println( (j+1) + "." + albumsArrayList.get(i).songsArrayList.get(j).getName());
                    isThere = true;
                }
            }
        }

        if (!isThere){
            System.out.println(albumName + " Album Doesn't exist!");
        }

    }



    private void displayAlbumSongs() {
        System.out.println("Enter the Album Name:");
        String albumName = scanner.next();
        albumName += scanner.nextLine();

        displayAlbumSongs(albumName);
    }

    private void playlistAddSong(String songName) {
        ListIterator<Song> listIterator = songLinkedList.listIterator();
        boolean isThere = false;

        for (int i = 0; i < albumsArrayList.size(); i++) {
            for (int j = 0; j < albumsArrayList.get(i).songsArrayList.size(); j++) {
                if (albumsArrayList.get(i).songsArrayList.get(j).getName().equals(songName)) {
                    songLinkedList.add(new Song(albumsArrayList.get(i).songsArrayList.get(j).getName(),
                            albumsArrayList.get(i).songsArrayList.get(j).getDuration()));
                    System.out.println("Done!");
                    isThere = true;
                }
            }
        }
        if (!isThere) {
            System.out.println(songName + " Song Doesn't exist!");
        }
    }

    private void playlistAddSong() {

        System.out.println("Enter the Song name to add to the Playlist:");
        String songName = scanner.next();
        songName += scanner.nextLine();

        playlistAddSong(songName);
    }

    private void displayPlaylist() {
        ListIterator<Song> songListIterator = songLinkedList.listIterator();
        int i = 0;

        if (songLinkedList.isEmpty()) {
            System.out.println("There are no songs yet in the Playlist!, You've to add Songs first!");
        } else {

            if (songLinkedList.size() > 1) {
                System.out.println("The songs in the playlist are: ");
            } else {
                System.out.println("The song in the playlist is: ");
            }
            while (songListIterator.hasNext()) {
                i++;
                System.out.println((i) + "." + songListIterator.next().getName());
            }
        }
    }

    private void removeSong(String songName) {
        boolean isThere = false;

        ListIterator<Song> songListIterator = songLinkedList.listIterator();
        if (songLinkedList.isEmpty()) {
            System.out.println("There is no songs yet to be removed!");
            isThere = true;
        }
        while (songListIterator.hasNext()) {

            if (songListIterator.next().getName().equals(songName)) {
                songListIterator.remove();
                isThere = true;
            }
        }

        if (!isThere) {
            System.out.println("There is no song called: " + songName + " in the playlist!");
        }
    }

    private void removeSong() {
        System.out.println("Enter the name of the Song to Remove from the Playlist:");
        String songName = scanner.next();
        songName += scanner.nextLine();

        removeSong(songName);
    }

    private void nextSong() {
        ListIterator<Song> listIterator = songLinkedList.listIterator();

        if (listIterator.hasNext()) {

            System.out.println(listIterator.next().getName());
        } else {
            System.out.println("We are at the end of the Playlist!");
        }
    }

}
