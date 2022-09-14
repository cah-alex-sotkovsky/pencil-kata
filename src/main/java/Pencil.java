import static java.lang.Character.*;

public class Pencil {

    private int durability;

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    // Default constructor
    public Pencil (){

    }

    // Constructor where pencil durability is specified
    public Pencil(int durability) {
        this.durability = durability;
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
            } else {paper.setText(currentText + " ");}

        }
    }

    }


