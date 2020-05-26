package com.document.movies;

import com.document.DocumentData;
import com.document.RecordMap;

import java.util.ArrayList;
import java.util.List;

import static com.document.movies.MoviesDocumentConstants.*;

public class MovieDocumentData implements DocumentData {

    private static final List<String> MOVIES_RECORD_TITLES = new ArrayList<String>() {{
        add(TITLE_NAME);
        add(TITLE_DIRECTOR);
        add(TITLE_YEAR);
        add(TITLE_MOVIE_RATING);
    }};

    private final List<RecordMap> moviesMap;

    MovieDocumentData(List<RecordMap> moviesMap) {
        this.moviesMap = moviesMap;
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
    public List<RecordMap> getRecordsMap() {
        return moviesMap;
    }
}
