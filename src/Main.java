import game.HomeWindow;
import game.Style;

public class Main {
    public static void main(String[] args) {

      Style.setDefaultTheme();

      HomeWindow homeWindow = new HomeWindow();
      homeWindow.showHomeWindow();
    }
}