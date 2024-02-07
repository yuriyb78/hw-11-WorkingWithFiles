package test;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Human;

import org.junit.jupiter.api.Test;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import static org.junit.jupiter.api.Assertions.*;

public class ParsingJsonFileTest {

    private final ClassLoader cl = ParsingJsonFileTest.class.getClassLoader();

    @Test
    void parsingJsonTest () throws Exception {
        try (InputStream is = cl.getResourceAsStream("files/human.json");
             Reader reader = new InputStreamReader(is,"UTF-8")) {
            ObjectMapper objectMapper = new ObjectMapper();
            Human human = objectMapper.readValue(reader,Human.class);
            assertEquals("Ivan",human.getFirst_name());
            assertEquals("Ivanov",human.getLast_name());
            assertEquals("Ivanovich",human.getMiddle_name());
            assertEquals(35,human.getAge());
            assertTrue(human.isIs_married());
            assertFalse(human.isHas_kids());
            assertArrayEquals(new String[]{"ivanov.i.i.@yandex-work.ru", "ivan@yandex-home.ru"},human.getEmails().toArray());
            assertArrayEquals(new Integer[]{0, 7, 42},human.getFavorite_numbers().toArray());
            assertEquals("Шарик", human.pets.getName());

        }


    }
}
