package com.document;

import com.document.books.*;
import com.document.excelFormat.ExcelDocumentBuilder;
import com.document.excelFormat.poi.*;
import com.document.jasper.*;
import com.document.movies.MovieRepository;
import com.document.movies.MoviesDocumentDataMapper;
import com.document.movies.MoviesDocumentInfo;
import com.document.movies.MoviesDocumentService;
import com.document.stringformat.StringDocumentBuilder;
import freemarker.template.Configuration;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class DocumentBuilderApp {

    public static void main(String[] args) throws IOException {
        BookRepository bookRepository = new BookRepository();
        ReportDataFormatProvider reportDataFormatProvider = new ReportDataFormatProvider();
        ReportDataMapper reportDataMapper = new ReportDataMapper(reportDataFormatProvider);
        Map<String, String> columnsNameMap = new LinkedHashMap<>();
        columnsNameMap.put("name", "Name");
        columnsNameMap.put("author", "Author");
        columnsNameMap.put("dateOfPublication", "Date Of Publication");

        Map<String, Integer> columnsWidthMap = new LinkedHashMap<>();
        columnsWidthMap.put("name", 150);
        columnsWidthMap.put("author", 100);
        columnsWidthMap.put("dateOfPublication", 150);

        ReportData<Book> bookReportData = reportDataMapper.getReportData("Books Report", columnsNameMap,
                columnsWidthMap, bookRepository.getRecords(), Book.class);

        Configuration configuration = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
        configuration.setDefaultEncoding("UTF-8");
        configuration.setDirectoryForTemplateLoading(new File("src/main/resources/templates"));

        BookJRXMLBuilder bookJRXMLBuilder = new BookJRXMLBuilder(configuration);

        JasperBookReportBuilder jasperBookReportBuilder = new JasperBookReportBuilder(new JRXlsxExporter(), bookJRXMLBuilder);
        jasperBookReportBuilder.build(bookReportData, "book_document");
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

        POICellStyleFactory cellStyleFactory = new POICellStyleFactory();

        POIExcelWriter excelWriter = new POIExcelWriter(sheetBuilder, cellStyleFactory);

        return new ExcelDocumentBuilder(excelWriter);
    }
}
