package com.document;

import com.document.books.*;
import com.document.excelFormat.ExcelDocumentBuilder;
import com.document.excelFormat.poi.POICellBuilder;
import com.document.excelFormat.poi.POIExcelWriter;
import com.document.excelFormat.poi.POIRowBuilder;
import com.document.excelFormat.poi.POISheetBuilder;
import com.document.movies.*;
import com.document.stringformat.StringDocumentBuilder;

public class DocumentBuilderApp {

    public static void main(String[] args) {
        DocumentBuilder documentBuilder = getExcelDocumentBuilder();
        BooksDocumentService booksDocumentService = getBooksDocumentService(documentBuilder);
        String document = booksDocumentService.build();
        System.out.println(document);
    }

    private static StringDocumentBuilder getStringDocumentBuilder() {
        return new StringDocumentBuilder();
    }

    private static BooksDocumentService getBooksDocumentService(DocumentBuilder documentBuilder) {
        BookRepository bookRepository = new BookRepository();
        BooksDocumentDataMapper booksDocumentDataMapper = new BooksDocumentDataMapper();
        BooksDocumentInfo booksDocumentInfo = new BooksDocumentInfo(bookRepository, booksDocumentDataMapper);

        return new BooksDocumentService(booksDocumentInfo, documentBuilder);
    }

    private static MoviesDocumentService getMoviesDocumentService(DocumentBuilder documentBuilder) {
        MovieRepository movieRepository = new MovieRepository();
        MoviesDocumentDataMapper moviesDocumentDataMapper = new MoviesDocumentDataMapper();

        MoviesDocumentInfo moviesDocumentInfo = new MoviesDocumentInfo(movieRepository, moviesDocumentDataMapper);

        return new MoviesDocumentService(moviesDocumentInfo, documentBuilder);
    }

    private static ExcelDocumentBuilder getExcelDocumentBuilder() {
        POICellBuilder cellBuilder = new POICellBuilder();
        POIRowBuilder rowBuilder = new POIRowBuilder(cellBuilder);
        POISheetBuilder sheetBuilder = new POISheetBuilder(rowBuilder);
        POIExcelWriter excelWriter = new POIExcelWriter(sheetBuilder);

        return new ExcelDocumentBuilder(excelWriter);
    }
}
