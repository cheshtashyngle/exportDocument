package com.document.movies;

import java.util.ArrayList;
import java.util.List;

public class MoviesDocumentBuilder {
    private static final String HEADING = "Movies Document";

    public String build(List<Movie> movies) {
        return (HEADING + "\n") +
                getContent(movies);
    }

    private String getContent(List<Movie> movies) {
        return getRecordsTitlesString() +
                getBookRecordsString(movies);
    }

    private String getRecordsTitlesString() {
        StringBuilder stringBuilder = new StringBuilder();
        List<String> recordTitles = getRecordsTitles();
        recordTitles.forEach(recordTitle -> {
            stringBuilder.append(recordTitle).append("\t");
        });
        return stringBuilder.toString();
    }

    private String getBookRecordsString(List<Movie> movies) {
        StringBuilder stringBuilder = new StringBuilder();
        movies.forEach(movie -> stringBuilder.append("\n").append(getBookRecord(movie)));
        return stringBuilder.toString();
    }

    private String getBookRecord(Movie movie) {
        return movie.name + "\t" +
                movie.director + "\t" +
                movie.year + "\t" +
                movie.movieRating + "\t";
    }

    private List<String> getRecordsTitles() {
        List<String> recordTitles = new ArrayList<>();
        recordTitles.add("Name");
        recordTitles.add("Director");
        recordTitles.add("Year");
        recordTitles.add("Movie Rating");
        return recordTitles;
    }
}
