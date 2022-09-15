import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EraserTests {

 private Eraser eraser;
 private Pencil pencil;
 private Paper paper;

 @BeforeEach
 public void setUp(){
  eraser = new Eraser(100);
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

 @Test
 public void eraseReplacesOnlyLastInstanceOfString(){
  pencil.write(paper, "Hello Hello");
  eraser.erase(paper, "Hello");
 String expectedResult = "Hello      ";
 assertEquals(expectedResult, paper.getText());
 }

 @Test
 public void eraseMultipleTimesRemovesAdditionalInstancesOfString(){
  pencil.write(paper, "Hello Hello Hello");
  eraser.erase(paper, "Hello");
  eraser.erase(paper, "Hello");
  String expectedResult = "Hello            ";
  assertEquals(expectedResult, paper.getText());
 }

 @Test
 public void eraseDoesNothingWhenNoInstanceOfStringExists(){
  pencil.write(paper, "Hello world");
  eraser.erase(paper, "Goodbye");
  String expectedResult = "Hello world";
  assertEquals(expectedResult, paper.getText());
 }

 @Test
 public void eraseWithoutDurabilityDoesNotErase(){
  eraser.setDurability(0);
  pencil.write(paper, "Hello world");
  eraser.erase(paper,"Hello");
  String expectedResult = "Hello world";
  assertEquals(expectedResult, paper.getText());
 }

 @Test void eraseWithDurabilityErases(){
  pencil.write(paper, "Hello world");
  eraser.erase(paper, "Hello");
 String expectedReuslt = "      world";
 assertEquals(expectedReuslt, paper.getText());
 }
 }


