package test;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.WorkWithZipArhive;

import java.io.File;
import java.io.IOException;

public class WorkWithFilesFromArhiveTest {

    WorkWithZipArhive workWithZipArhive = new WorkWithZipArhive();
    @Test
    void parsingPdfFileTest() throws IOException {
        workWithZipArhive.zipExtractFiles(".pdf");
        File fileName = new File(WorkWithZipArhive.extractedFileName);
        PDF pdf = new PDF(fileName);
        Assertions.assertEquals("Требования к полям.pdf", pdf.title);
        workWithZipArhive.deleteFileByName(fileName);

    }

    @Test
    void parsingXlsFileTest() throws IOException {
        workWithZipArhive.zipExtractFiles(".xls");
        File fileName = new File(WorkWithZipArhive.extractedFileName);
        XLS xls = new XLS(fileName);
        Assertions.assertEquals("Название класса",
                xls.excel.getSheet("Авторизация")
                        .getRow(0)
                        .getCell(1));
        workWithZipArhive.deleteFileByName(fileName);

    }
}
