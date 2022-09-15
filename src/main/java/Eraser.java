public class Eraser {

    private int durability;

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    public Eraser(int durability) {
        this.durability = durability;
    }

    public void erase(Paper paper, String textToErase) {
        String text = paper.getText();
        String replacementText = "";

        int lastIndex = text.lastIndexOf(textToErase);
        if (lastIndex > -1) {
            String beginString = text.substring(0, lastIndex);
            String endString = text.substring(lastIndex + textToErase.length());

            char[] arrayOfCharacters = textToErase.toCharArray();

            for (char character : arrayOfCharacters) {

                if (Character.isWhitespace(character)) {
                    replacementText += " ";
                } else {
                    if (durability >= 1) {
                        replacementText += " ";
                    } else {
                        replacementText += Character.toString(character);
                    }
                }

                paper.setText(beginString + replacementText + endString);
            }
        }
    }
}
