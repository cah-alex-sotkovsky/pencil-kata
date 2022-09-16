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

            if (isUpperCase(character) && (durability >= 2)) {
                paper.setText(currentText + Character.toString(character));
                durability -= 2;
            } else if (isLowerCase(character) && (durability >= 1)) {
                paper.setText(currentText + Character.toString(character));
                durability -= 1;
            } else {
                paper.setText(currentText + " ");
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
        char[] paperTextChars = paper.getText().toCharArray();
        char[] replacementTextChars = replacementText.toCharArray();
        int counter = 0;

        for (int i = startingIndex; i < startingIndex + replacementText.length(); i++){
            if (Character.isWhitespace(paperTextChars[i])){
                paperTextChars[i] = replacementTextChars[counter];
                counter ++;
            }
            else {
                paperTextChars[i] = '@';
                counter ++;
            }
        }
    paper.setText(String.valueOf(paperTextChars));
    }
}


