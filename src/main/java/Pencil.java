import static java.lang.Character.*;

public class Pencil {

    private int durability;
    private final int maxDurability; //Highlights are always good to watch for. Here it told me this could be a const (final).
    private int length;

    public int getDurability() {
        return durability;
    }

    //Should this be public? Is it only used in tests? If so, is there another way we could create the scenario we want without this being public? (Can we initialize the pencil with the given durability instead?)
    public void setDurability(int durability) {
        this.durability = durability;
    }

    //How could we set the length to a certain amount without exposing this as a public interface?
    public void setLength(int length) {
        this.length = length;
    }

    public Pencil(int durability, int maxDurability, int length) {
        this.durability = durability;
        this.maxDurability = maxDurability;
        this.length = length;
    }

    public void write(Paper paper, String textToWrite) {
        for (char character : textToWrite.toCharArray()) {
            writeCharacter(paper, character);
        }
    }

    private void writeCharacter(Paper paper, char character) {
        String currentText = paper.getText();
        if (isUpperCase(character)) {
            writeCharacter(2, paper, currentText, character);
        } else if (isLowerCase(character)) {
            writeCharacter(1, paper, currentText, character);
        } else if (Character.isWhitespace(character)) {
            paper.setText(currentText + " ");
        } else {
            paper.setText(currentText + character);
            durability -= 1;
        }
    }

    private void writeCharacter(int cost, Paper paper, String currentText, char character) {
        if (durability >= cost) {
            paper.setText(currentText + character);
            durability -= cost;
        } else {
            paper.setText(currentText + " ");
        }
    }

    public void sharpen() {
        if (length > 0) {
            durability = maxDurability;
            length -= 1;
        }
    }

    public void edit(Paper paper, int startingIndex, String replacementText) {
        char[] paperTextChars = paper.getText().toCharArray();
        char[] replacementTextChars = replacementText.toCharArray();

        int counter = 0;

        // Looping through text on paper char array starting at a specified index and going until we reach end of replacementText string
        for (int i = startingIndex; i < startingIndex + replacementText.length(); i++) {
            try {
                writeCharacter(paperTextChars, replacementTextChars, counter, i);
                durability -= 1; //extract from ifs
                paper.setText(String.valueOf(paperTextChars));
                //If replacementText exceeds length of existing text on paper, we will catch the index out of bounds exception and write the rest of the replacement text normally
            } catch (ArrayIndexOutOfBoundsException e) {
                write(paper, "" + replacementTextChars[counter]); //Not sure this is an improvement
            }
            counter++; //extract from ifs
        }
    }

    //Is there a way we could utilize the existing writeCharacter methods?
    private void writeCharacter(char[] paperTextChars, char[] replacementTextChars, int counter, int i) {
        if (Character.isWhitespace(paperTextChars[i])) {
            //Checking if we have enough pencil durability to write the chars
            if (isUpperCase(replacementTextChars[counter]) && (durability >= 2)) {
                paperTextChars[i] = replacementTextChars[counter];
                durability -= 1; //Additional durability subtraction
            } else if (isLowerCase(replacementTextChars[counter]) && (durability >= 1)) {
                paperTextChars[i] = replacementTextChars[counter];
            } else if (Character.isWhitespace(replacementTextChars[counter])) {
                paperTextChars[i] = replacementTextChars[counter];
            } else {
                paperTextChars[i] = replacementTextChars[counter];
            }
            // If not whitespace, pencil will write @ symbol and reduce durability by one
        } else {
            paperTextChars[i] = '@';
        }
    }


}


