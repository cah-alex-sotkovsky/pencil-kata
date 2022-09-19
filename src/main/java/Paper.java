public class Paper {

    private String text = "";

    public String getText() {
        return text;
    }

    //You could have done some kind of 'add text' or 'edit text' methods on this object, to more accurately reflect how 'real world paper' works, but this makes more sense to me in an application, and is the way people end up modelling it.
    //One question that's worth wrestling with: do we even need a paper object? I think it's clearer having one, but it's an interesting thought...
    public void setText(String text) {
        this.text = text;
    }

}
