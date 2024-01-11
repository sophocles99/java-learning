package inheritance;

public class UIControl {
    private boolean isEnabled = true;

    public void enable() {
        this.isEnabled = true;
    }

    public void disable() {
        this.isEnabled = false;
    }

    public boolean isEnabled() {
        return isEnabled;
    }
}
