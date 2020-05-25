package com.document.movies;

import com.document.DocumentData;
import com.document.DocumentRecordMap;

import java.util.ArrayList;
import java.util.List;

import static com.document.movies.MoviesDocumentConstants.*;

public class MovieDocumentData implements DocumentData<Movie> {

    private static final List<String> MOVIES_RECORD_TITLES = new ArrayList<String>() {{
        add(TITLE_NAME);
        add(TITLE_DIRECTOR);
        add(TITLE_YEAR);
        add(TITLE_MOVIE_RATING);
    }};

    private final List<Movie> movies;

    public MovieDocumentData(List<Movie> movies) {
        this.movies = movies;
    }


    @Override
    public String getDocumentName() {
        return MOVIES_DOCUMENT_NAME;
    }

    @Override
    public List<String> getRecordsTitles() {
        return MOVIES_RECORD_TITLES;
    }

    @Override
    public List<Movie> getRecords() {
        return movies;
    }

    @Override
    public List<DocumentRecordMap> getRecordsMap() {
        return null;
    }
}
