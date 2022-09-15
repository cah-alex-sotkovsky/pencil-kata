import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EraserTests {

 private Eraser eraser;
 private Pencil pencil;
 private Paper paper;

 @BeforeEach
 public void setUp(){
  eraser = new Eraser();
  pencil = new Pencil(100,100,10);
  paper = new Paper();
 }

 @Test
 public void eraseReplacesStringAtEndOfTextWithSpaces(){
  pencil.write(paper, "Hello world");
  eraser.erase(paper,"world");
  String expectedResult = "Hello      ";
  assertEquals(expectedResult, paper.getText());
 }

 @Test
 public void eraseReplacesStringInMiddleOfTextWithSpaces(){
  pencil.write(paper, "My name is Alex");
  eraser.erase(paper, "name is");
  String expectedResult = "My         Alex";
  assertEquals(expectedResult, paper.getText());
 }

 @Test
 public void eraseReplacesStringAtBeginningOfTextWithSpaces(){
  pencil.write(paper, "My name is Alex");
  eraser.erase(paper, "My");
  String expectedResult = "   name is Alex";
  assertEquals(expectedResult, paper.getText());

 }

}
