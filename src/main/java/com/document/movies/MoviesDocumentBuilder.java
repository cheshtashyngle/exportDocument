package com.document.movies;

import com.document.DocumentData;

import java.util.List;

public class MoviesDocumentBuilder {

    public String build(DocumentData<Movie> data) {
        return (data.getDocumentName() + "\n") +
                getContent(data);
    }

    private String getContent(DocumentData<Movie> data) {
        return getRecordsTitlesString(data.getRecordsTitles()) +
                getRecordsString(data.getRecords());
    }

    private String getRecordsTitlesString(List<String> recordTitles) {
        StringBuilder stringBuilder = new StringBuilder();
        recordTitles.forEach(recordTitle -> {
            stringBuilder.append(recordTitle).append("\t");
        });
        return stringBuilder.toString();
    }

    private String getRecordsString(List<Movie> movies) {
        StringBuilder stringBuilder = new StringBuilder();
        movies.forEach(movie -> stringBuilder.append("\n").append(getMovieRecord(movie)));
        return stringBuilder.toString();
    }

    private String getMovieRecord(Movie movie) {
        return movie.name + "\t" +
                movie.director + "\t" +
                movie.year + "\t" +
                movie.movieRating + "\t";
    }
}
