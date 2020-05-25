package com.document.movies;

import com.document.DocumentData;

import java.util.ArrayList;
import java.util.List;

public class MovieDocumentData implements DocumentData<Movie> {

    private static final String MOVIES_DOCUMENT_NAME = "Movies Document";

    private static final List<String> MOVIES_RECORD_TITLES = new ArrayList<String>() {{
        add("Name");
        add("Director");
        add("Year");
        add("Movie Rating");
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
}
