package test;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.WorkWithZipArhive;

import java.io.*;
import java.util.List;


public class WorkWithFilesFromArhiveTest {

    WorkWithZipArhive workWithZipArhive = new WorkWithZipArhive();
    @Test
    void parsingPdfFileTest() throws Exception {
        workWithZipArhive.zipExtractFiles(".pdf");
        File fileName = new File(WorkWithZipArhive.extractedFileName);
        PDF pdf = new PDF(fileName);
        Assertions.assertEquals("Требования к полям.pdf", pdf.title);
        workWithZipArhive.deleteFileByName(fileName);

    }

    @Test
    void parsingXlsFileTest() {
        workWithZipArhive.zipExtractFiles(".xls");
        File fileName = new File(WorkWithZipArhive.extractedFileName);
        XLS xls = new XLS(fileName);
        Assertions.assertEquals("Название класса",
                xls.excel.getSheet("Авторизация")
                        .getRow(0)
                        .getCell(1)
                        .getStringCellValue());
        workWithZipArhive.deleteFileByName(fileName);

    }

    @Test
    void parsingCsvFileTest() throws Exception {
        workWithZipArhive.zipExtractFiles(".csv");
        File fileName = new File(WorkWithZipArhive.extractedFileName);
        try (CSVReader csvReader = new CSVReader(new FileReader(fileName))) {
            List<String[]> content = csvReader.readAll();
            Assertions.assertArrayEquals(
                    new String[]{"name", "phoneNumber", "email", "address", "userAgent", "hexcolor"}, content.get(0));
        }
        workWithZipArhive.deleteFileByName(fileName);
    }
}
