package application;

import org.junit.Rule;
import org.junit.Test;
import org.junit.Ignore;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.*;

/**
 * Created by Michael Sjögren on 2016-09-07.
 */
public class WriteToTextFileTest {
    @Rule public JavaFXThreadingRule javafxRule = new JavaFXThreadingRule();

    WriteToTextFile writer = new WriteToTextFile();

    private List<String> readFileLines(File file) {
        List<String> lines = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;

            while((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {}
        return lines;
    }

   @Test
    public void testSaveFileWithoutContent() throws Exception {
        File file = new File("test.ini");
        boolean result = writer.SaveFile(file);
        assertEquals(true, result);

       List<String> lines = readFileLines(file);
       assertEquals(0, lines.size());
    }

    @Test
    public void testSaveFileWithCheckbox() throws Exception {
        File file = new File("test.ini");

        writer.setTextInFile("checkbox");
        writer.setTextInFile("");
        writer.setTextInFile("");
        writer.setTextInFile("Text");

        writer.setCheckboxX(2.3);
        writer.setCheckboxY(3.3);
        writer.setCheckBoxMap(0, 0);

        boolean result = writer.SaveFile(file);
        assertEquals(true, result);

        List<String> lines = readFileLines(file);
        assertEquals(4, lines.size());
        assertEquals("checkbox", lines.get(0));
        assertEquals("2", lines.get(1));
        assertEquals("3", lines.get(2));
        assertEquals("Text", lines.get(3));
    }



    @Test
    public void setTextInFile() throws Exception {
        writer.setTextInFile("Tab");
        assertEquals("Tab", writer.textList.get(writer.textList.size ()-1));
    }

    @Test
    public void setCheckboxX() throws Exception {
        writer.setCheckboxX(5.3);
        assertEquals(5.3, writer.getCheckboxX(), 0.01);
    }

    @Test
    public void setCheckboxY() throws Exception {

    }

    @Test
    public void setTextfieldX() throws Exception {

    }

    @Test
    public void setTextfieldY() throws Exception {

    }

    @Test
    public void setTextareaX() throws Exception {

    }

    @Test
    public void setTextareaY() throws Exception {

    }

    @Test
    public void setCheckBoxMap() throws Exception {

    }

    @Test
    public void setTextFieldMap() throws Exception {

    }

    @Test
    public void setTextAreaMap() throws Exception {

    }

}