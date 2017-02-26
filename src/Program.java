import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by HongUyen on 21-Feb-17.
 */
public class Program {
    public static void main(String[] args) {
        int randomX = ThreadLocalRandom.current().nextInt(50, GameWindow.WIDTH);
        GameWindow gameWindow = new GameWindow();
        gameWindow.start();

    }
}
