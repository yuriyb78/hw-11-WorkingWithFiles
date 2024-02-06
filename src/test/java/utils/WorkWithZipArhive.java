package utils;

import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class WorkWithZipArhive {
    private static final ClassLoader cl = WorkWithZipArhive.class.getClassLoader();

    private static final String outputDirectory = "src/test/resources/files/output";

    public static String extractedFileName;

    public WorkWithZipArhive zipExtractFiles(String fileExtention) {
        try (InputStream is = cl.getResourceAsStream("files/arhiv_for_test.zip");
             ZipInputStream zis = new ZipInputStream(is)) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                if(!entry.isDirectory() && entry.getName().endsWith(fileExtention)) {
                    File outputFile = new File(outputDirectory, entry.getName());
                    try (FileOutputStream outputStream = new FileOutputStream(outputFile)) {
                        IOUtils.copy(zis, outputStream);
                    }
                    extractedFileName = outputDirectory + "/" + entry.getName();
                    break;
                }
            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        return this;
    }

    public static void deleteFileByName(String fileNameForDelete) {
        File file = new File(outputDirectory + fileNameForDelete);
        file.delete();
    }

}

