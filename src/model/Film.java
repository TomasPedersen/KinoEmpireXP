package model;

import java.time.LocalDate;

public class Film {

    private String danishTitle;
    private String originalTitle;
    private String Genre;
    private double filmLength;
    private String filmDescription;
    private LocalDate releaseDate;
    private double price;
    private String director;
    private int ageRestriction;
    private String versions; // language, subtitles and 3d

    public Film(String danishTitle, String originalTitle, String genre, double filmLength, String filmDescription, LocalDate releaseDate, double price, String director, int ageRestriction, String versions) {
        this.danishTitle = danishTitle;
        this.originalTitle = originalTitle;
        this.Genre = genre;
        this.filmLength = filmLength;
        this.filmDescription = filmDescription;
        this.releaseDate = releaseDate;
        this.price = price;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

}

