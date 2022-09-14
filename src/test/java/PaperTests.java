import org.junit.jupiter.api.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PaperTests {

   Paper paper;

   @BeforeEach
    public void setUp(){
       paper = new Paper();
   }

   @Test
    public void writeAssignsValueToText(){
       String expectedResult = "Hello";
       paper.write("Hello");
       assertEquals(expectedResult, paper.getText());
       assertNotEquals("Goodbye", paper.getText());
   }

   @Test
   public void writingMultipleTimesAppendsText(){
      String expectedResult = "Hello world!";
      paper.write("Hello");
      paper.write(" world!");
      assertEquals(expectedResult, paper.getText());
   }


}
