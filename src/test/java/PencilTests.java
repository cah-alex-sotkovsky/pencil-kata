import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    public void writeWillSkipUppercaseLetterAndContinueWriting(){
        pencil.setDurability(1);
        pencil.write(paper,"Hi");
        String expectedResult = " i";
        assertEquals(expectedResult, paper.getText());
    }

    @Test
    public void writingSpecialCharsReducesDurabilityByOne(){
        pencil.write(paper,",");
        String expectedResult = ",";
        assertEquals(expectedResult, paper.getText());
        assertEquals(99, pencil.getDurability());
    }

    @Test
    public void writingUppercaseCharsReducesDurabilityByTwo(){
            pencil.write(paper, "A");
            assertEquals(98, pencil.getDurability());
    }

    @Test
    public void writingLowercaseCharsReducesDurabilityByOne(){
        pencil.write(paper, "a");
        assertEquals(99, pencil.getDurability());
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
    paper.setText("An       a day keeps the doctor away");
    pencil.edit(paper,3,"onion");
    String expectedResult = "An onion a day keeps the doctor away";
    assertEquals(expectedResult, paper.getText());
    }

    @Test
    public void editReplacesTextWithAtSymbol(){
    paper.setText("An       a day keeps the doctor away");
    pencil.edit(paper,3,"artichoke");
    String expectedResult = "An artich@k@ay keeps the doctor away";
    assertEquals(expectedResult, paper.getText());
    }

    @Test
    public void editAtEndOfStringContinuesWriting(){
        paper.setText("Hello my name is     ");
        pencil.edit(paper,17, "Alexandra");
        String expectedResult = "Hello my name is Alexandra";
        assertEquals(expectedResult, paper.getText());
    }

    @Test
    public void editingUppercaseCharReducesDurabilityByTwo(){
        paper.setText("Uppercase letter is:  ");
        pencil.edit(paper, 20, "A");
        assertEquals(98, pencil.getDurability());
    }

    @Test
    public void editingLowercaseCharReducesDurabilityByOne(){
        paper.setText("Lowercase letter is:  ");
        pencil.edit(paper, 20, "a");
        assertEquals(99, pencil.getDurability());
    }

    @Test
    public void editingSpecialCharReducesDurabilityByOne(){
        paper.setText("Special character is:  ");
        pencil.edit(paper, 21, "?");
        assertEquals(99, pencil.getDurability());
    }





}
