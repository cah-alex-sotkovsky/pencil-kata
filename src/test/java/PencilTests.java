import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class PencilTests {
    Pencil pencil;
    Paper paper;

    @BeforeEach
    public void setUp(){
        pencil = new Pencil();
        paper = new Paper();
    }

    @Test
    public void writeAssignsTextToPaper(){
        String expectedResult = "Hello";
        pencil.write(paper, "Hello");
        assertEquals(expectedResult, paper.getText());
        assertNotEquals("Goodbye", paper.getText());
    }

    @Test
    public void writingMultipleTimesAppendsText(){
        String expectedResult = "Hello world!";
        pencil.write(paper,"Hello");
        pencil.write(paper," world!");
        assertEquals(expectedResult, paper.getText());
    }

}
