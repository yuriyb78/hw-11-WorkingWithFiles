package test;

import model.Human;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class ParsingJsonFileTest {

    private final ClassLoader cl = ParsingJsonFileTest.class.getClassLoader();

    @Test
    void parsingJsonTest () throws Exception {
        try (InputStream is = cl.getResourceAsStream("files/human.json");
             Reader reader = new InputStreamReader(is)) {
            ObjectMapper

        }


    }
}
