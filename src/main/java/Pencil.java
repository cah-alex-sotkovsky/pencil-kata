public class Pencil {

    public void write(Paper paper, String textToWrite) {
        String currentText = paper.getText();
        paper.setText(currentText + textToWrite);
    }
}
