import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class PencilTests {
    private Pencil pencil;
    private Paper paper;

    @BeforeEach
    public void setUp(){
        pencil = new Pencil(100, 100, 10);
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
        String expectedResult = "Hello world";
        pencil.write(paper,"Hello");
        pencil.write(paper," world");
        assertEquals(expectedResult, paper.getText());
    }

    @Test
    public void writingWithDurabilityWrites(){
        String expectedResult = "Hello";
        pencil.write(paper, "Hello");
        assertEquals(expectedResult, paper.getText());
    }

    @Test
    public void writingWithoutDurabilityWritesWhitespace(){
        // Setting durability to lower number to simulate worn down pencil
        pencil.setDurability(9);
        String expectedResult = "My name is     ";
        pencil.write(paper, "My name is Alex");
        assertEquals(expectedResult, paper.getText());
    }

    @Test
    public void sharpenRestoresMaxDurability(){
        pencil.setDurability(10);
        pencil.sharpen();
        assertEquals(100,pencil.getDurability());
    }

    @Test
    public void sharpenFailsIfLengthInadequate(){
        pencil.setDurability(10);
        pencil.setLength(0);
        pencil.sharpen();
        assertEquals(10, pencil.getDurability());
    }

    @Test
    public void editReplacesWhitespaceWithText(){
    paper.setText("Hello my name is     ");
    pencil.edit(paper,17,"Alex");
    String expectedResult = "Hello my name is Alex";
    assertEquals(expectedResult, paper.getText());
    }

}
