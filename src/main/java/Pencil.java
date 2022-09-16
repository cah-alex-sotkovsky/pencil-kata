import static java.lang.Character.*;

public class Pencil {

    private int durability;
    private int maxDurability;
    private int length;

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    public void setLength(int length) {
        this.length = length;
    }


    // Constructor where pencil durability, maxDurability and length is specified
    public Pencil(int durability, int maxDurability, int length) {
        this.durability = durability;
        this.maxDurability = maxDurability;
        this.length = length;
    }

    public void write(Paper paper, String textToWrite) {

        char[] arrayOfCharacters = textToWrite.toCharArray();

        for (char character : arrayOfCharacters) {

            String currentText = paper.getText();

            if (isUpperCase(character)) {
                if (durability >= 2) {
                    paper.setText(currentText + Character.toString(character));
                    durability -= 2;
                } else {
                    paper.setText(currentText + " ");
                }
            } else if (isLowerCase(character)) {
                if (durability >= 1) {
                    paper.setText(currentText + Character.toString(character));
                    durability -= 1;
                } else {
                    paper.setText(currentText + " ");
                }
            } else if (Character.isWhitespace(character)) {
                paper.setText(currentText + " ");
            } else {
                paper.setText(currentText + Character.toString(character));
                durability -= 1;
            }

        }
    }

    public void sharpen() {
        if (length > 0) {
            durability = maxDurability;
            length -= 1;
        }
    }

    public void edit(Paper paper, int startingIndex, String replacementText) {

        //Turning text on paper and text to write with the edit function into char arrays
        char[] paperTextChars = paper.getText().toCharArray();
        char[] replacementTextChars = replacementText.toCharArray();

        //Initializing a counter so I know which char in the replacement text array to write
        int counter = 0;

        // Looping through text on paper char array starting at a specified index and going until we reach end of replacementText string
        for (int i = startingIndex; i < startingIndex + replacementText.length(); i++) {

            try {
                //Checking if char is whitespace we can write over
                if (Character.isWhitespace(paperTextChars[i])) {
                    //Checking if we have enough pencil durability to write the chars
                    if (isUpperCase(replacementTextChars[counter]) && (durability >= 2)) {
                        paperTextChars[i] = replacementTextChars[counter];
                        durability -= 2;
                        counter++;
                    } else if (isLowerCase(replacementTextChars[counter]) && (durability >= 1)) {
                        paperTextChars[i] = replacementTextChars[counter];
                        durability -= 1;
                        counter++;
                    } else if (Character.isWhitespace(replacementTextChars[counter])) {
                        paperTextChars[i] = replacementTextChars[counter];
                        counter++;
                    } else {
                        paperTextChars[i] = replacementTextChars[counter];
                        durability -= 1;
                        counter++;
                    }
                    // If not whitespace, pencil will write @ symbol and reduce durability by one
                } else {
                    paperTextChars[i] = '@';
                    durability -= 1;
                    counter++;
                }
                paper.setText(String.valueOf(paperTextChars));
                //If replacementText exceeds length of existing text on paper, we will catch the index out of bounds exception and write the rest of the replacement text normally
            } catch (ArrayIndexOutOfBoundsException e) {
                write(paper, Character.toString(replacementTextChars[counter]));
                counter++;
            }
        }
    }


}


