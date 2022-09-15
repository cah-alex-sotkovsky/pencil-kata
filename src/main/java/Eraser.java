public class Eraser {
    public void erase(Paper paper, String textToErase) {
        String text = paper.getText();
        String replacementSpaces = "";
        for (int i = 0; i < textToErase.length(); i++) {
            replacementSpaces += " ";
        }
        int lastIndex = text.lastIndexOf(textToErase);
        if (lastIndex > -1) {
            String beginString = text.substring(0, lastIndex);
            String endString = text.substring(lastIndex + textToErase.length());
            paper.setText(beginString + replacementSpaces + endString);
        }
    }
}
