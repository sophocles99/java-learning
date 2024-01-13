package inheritance;

public class UIControl {
    private boolean isEnabled = true;

//    public UIControl(boolean isEnabled) {
//        this.isEnabled = isEnabled;
//    }

    public void render() {
        
    }

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
