package utils;

import java.util.Random;

/**
 * Created by HongUyen on 04-Mar-17.
 */
public class RandomAll {
    public static int nextX(int max, int min){
        Random random = new Random();
        return (random.nextInt(max-min)+min);
    }
}
