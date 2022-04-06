package asm1;


public class Song {

    private String name;
    private String artist;
    private Integer rated;

    public Song() {
    }

    public Song(String name, String artist, Integer rated) {
        this.name = name;
        this.artist = artist;
        this.rated = rated;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public Integer getRated() {
        return rated;
    }

    public void setRated(Integer rated) {
        this.rated = rated;
    }

    @Override
    public String toString() {
        return String.format("%s|%s|%d", name, artist, rated);
    }
}
