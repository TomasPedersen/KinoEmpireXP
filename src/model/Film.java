package model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Film {

    private String originalTitle;
    private String danishTitle;
    private String Genre;
    private double filmLength;
    private String filmDescription;
    private double price1;
    private String director;
    private int ageRestriction;
    private String versions; // language, subtitles, 3d


}
