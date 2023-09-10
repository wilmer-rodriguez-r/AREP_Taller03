package backend;


import org.example.files.File;
import org.example.files.FileImage;
import org.example.files.FileText;
import org.example.files.exception.ExceptionFile;
import org.example.files.filesFactory.FileFactoryImpl;
import org.example.files.filesFactory.FileFactoryInterface;
import org.junit.Before;
import org.junit.Test;
import static junit.framework.Assert.assertEquals;
public class ReadFileTest {

    FileFactoryInterface filesFactory;

    @Before
    public void init() {
        filesFactory = new FileFactoryImpl();
    }
    @Test
    public void readFileImageExistExtension() throws Exception {
        //Arrange
        //Act
        File fileReaderFileImage = filesFactory.getInstance("fondo.jpg");
        //Assert
        assertEquals(FileImage.class, fileReaderFileImage.getClass());
    }

    @Test(expected = ExceptionFile.class)
    public void readFileImageNotExistExtension() throws ExceptionFile {
        //Arrange
        //Act
        File fileReaderFileImage = filesFactory.getInstance("no");
        //Assert
    }

    @Test
    public void readFileTextExistExtension() throws Exception {
        //Arrange
        //Act
        File fileText = filesFactory.getInstance("fondo.html");
        //Assert
        assertEquals(FileText.class, fileText.getClass());
    }

    @Test(expected = ExceptionFile.class)
    public void readFileTextNotExistExtension() throws ExceptionFile {
        //Arrange
        //Act
        File fileReaderFileImage = filesFactory.getInstance("no");
        //Assert
    }
}
