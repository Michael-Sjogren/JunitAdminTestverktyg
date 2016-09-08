package application;

import org.junit.Rule;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

/**
 * Created by Michael Sjögren on 2016-09-07.
 */
public class WriteToTextFileTest {
    @Rule public JavaFXThreadingRule javafxRule = new JavaFXThreadingRule();
    WriteToTextFile writer = new WriteToTextFile();

    @Test
    public void testSaveFile() throws Exception {
        boolean isSucessful = writer.SaveFile(new File("test.ini"));
        assertEquals(true,isSucessful);

    }

    @Test
    public void showFileChooser() throws Exception {

    }

    @Test
    public void setTextInFile() throws Exception {
        writer.setTextInFile("");
        //writer.showFileChooser();
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