package inheritance;

public class TextBox extends UIControl {
    private String text = "";

    public TextBox() {
        super(false);
        System.out.println("TextBox constructor");
    }

    public void setText(String text) {
        this.text = text;
    }

    public void clear() {
        text = "";
    }
}
