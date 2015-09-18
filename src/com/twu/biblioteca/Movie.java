package com.twu.biblioteca;

import java.time.Year;

/**
 * Created by Tito on 18/09/2015.
 *
 * Represents one movie
 */
public class Movie {
    private String name;
    private Year year;
    private String director;
    private int rating;

    /**
     * Constructor
     * @param name The name of the movie
     * @param year The year the movie was released
     * @param director The director of the movie
     * @param rating The rating of the movie, or 0 for unrated
     */
    public Movie(String name, Year year, String director, int rating) throws IllegalArgumentException{

        if (rating <0 || rating > 10) {
            throw new IllegalArgumentException("Rating must be between 0 and 10");
        }

        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
    }

    public String toString() {
        String output;

        String ratingString = "";
        if (rating == 0) {
            ratingString = "Unrated";
        }
        else {
            ratingString = String.format("%d/10", rating);
        }

        output = String.format("%s %s. (%s) %s",
                name,
                year,
                director,
                ratingString);

        return output;

    }
}
