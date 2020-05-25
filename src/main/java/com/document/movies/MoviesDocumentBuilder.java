package com.document.movies;

import java.util.List;

public class MoviesDocumentBuilder {

    public String build(MovieDocumentData moviesData) {
        return (moviesData.getDocumentName() + "\n") +
                getContent(moviesData);
    }

    private String getContent(MovieDocumentData moviesData) {
        return getRecordsTitlesString(moviesData.getRecordsTitles()) +
                getBookRecordsString(moviesData.getRecords());
    }

    private String getRecordsTitlesString(List<String> moviesRecordTitles) {
        StringBuilder stringBuilder = new StringBuilder();
        moviesRecordTitles.forEach(recordTitle -> {
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
}
