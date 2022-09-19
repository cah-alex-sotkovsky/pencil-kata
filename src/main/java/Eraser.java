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
        int lastOccurrenceOfTextToErase = paper.getText().lastIndexOf(textToErase);
        if (lastOccurrenceOfTextToErase > -1) {
            doErase(paper, textToErase, lastOccurrenceOfTextToErase);
        }
    }

    private void doErase(Paper paper, String textToErase, int lastIndex) {
        String replacementText = textToErase;
        String beginString = paper.getText().substring(0, lastIndex);
        String endString = paper.getText().substring(lastIndex + textToErase.length());

        char[] charactersToErase = textToErase.toCharArray();

        // Starting at the last index of the array, check that the char is not whitespace and if eraser has durability enough to erase
        for (int i = charactersToErase.length - 1; i >= 0; i--) {
            replacementText = eraseCharacter(replacementText, charactersToErase, i);
        }
        paper.setText(beginString + replacementText + endString);
    }

    private String eraseCharacter(String replacementText, char[] charactersToErase, int i) {
        if (!Character.isWhitespace(charactersToErase[i])) {
            if (durability >= 1) {
                replacementText = replacementText.substring(0, i) + " " + replacementText.substring(i + 1);
                durability -= 1;
            }
        }
        return replacementText;
    }
}
