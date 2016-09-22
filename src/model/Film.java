package model;

public class Film {

    private String danishTitle;
    private String originalTitle;
    private String Genre;
    private double filmLength;
    private String filmDescription;
    private double price1;
    private String director;
    private int ageRestriction;
    private String versions; // language, subtitles, 3d

    public Film(String originalTitle, String danishTitle, String genre, double filmLength, String filmDescription, double price1, String director, int ageRestriction, String versions) {
        this.originalTitle = originalTitle;
        this.danishTitle = danishTitle;
        Genre = genre;
        this.filmLength = filmLength;
        this.filmDescription = filmDescription;
        this.price1 = price1;
        this.director = director;
        this.ageRestriction = ageRestriction;
        this.versions = versions;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getDanishTitle() {
        return danishTitle;
    }

    public void setDanishTitle(String danishTitle) {
        this.danishTitle = danishTitle;
    }

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }

    public double getFilmLength() {
        return filmLength;
    }

    public void setFilmLength(double filmLength) {
        this.filmLength = filmLength;
    }

    public String getFilmDescription() {
        return filmDescription;
    }

    public void setFilmDescription(String filmDescription) {
        this.filmDescription = filmDescription;
    }

    public double getPrice1() {
        return price1;
    }

    public void setPrice1(double price1) {
        this.price1 = price1;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getAgeRestriction() {
        return ageRestriction;
    }

    public void setAgeRestriction(int ageRestriction) {
        this.ageRestriction = ageRestriction;
    }

    public String getVersions() {
        return versions;
    }

    public void setVersions(String versions) {
        this.versions = versions;
    }
}
