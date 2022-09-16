public class Eraser {

    private int durability;

    public void setDurability(int durability) {
        this.durability = durability;
    }

    public int getDurability() {
        return durability;
    }

    public Eraser(int durability) {
        this.durability = durability;
    }

    public void erase(Paper paper, String textToErase) {
        String text = paper.getText();
        String replacementText = textToErase;

        // Finds last index of occurrence of textToErase String
        int lastIndex = text.lastIndexOf(textToErase);

        // If string found on paper, grab everything before and after that occurrence and store substrings in a new variable
        if (lastIndex > -1) {
            String beginString = text.substring(0, lastIndex);
            String endString = text.substring(lastIndex + textToErase.length());

            // Turn textToErase into an array of characters
            char[] arrayOfCharacters = textToErase.toCharArray();

            // Starting at the last index of the array, check that the char is not whitespace and if eraser has durability enough to erase
            for (int i = arrayOfCharacters.length - 1; i >= 0; i--) {
                if (!Character.isWhitespace(arrayOfCharacters[i])) {
                    if (durability >= 1) {
                        replacementText = replacementText.substring(0, i) + " " + replacementText.substring(i + 1);
                        durability -= 1;
                    }
                }
            }
            paper.setText(beginString + replacementText + endString);
        }
    }
}
