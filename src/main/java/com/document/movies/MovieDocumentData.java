package com.document.movies;

import java.util.ArrayList;
import java.util.List;

public class MovieDocumentData {

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

    String getDocumentName() {
        return MOVIES_DOCUMENT_NAME;
    }

    List<String> getRecordsTitles() {
        return MOVIES_RECORD_TITLES;
    }

    List<Movie> getRecords() {
        return movies;
    }
}
