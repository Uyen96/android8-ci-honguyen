import javafx.stage.Screen;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.BufferUnderflowException;
import java.util.ArrayList;

/**
 * Created by HongUyen on 21-Feb-17.
 */
public class GameWindow extends Frame {
    private static final int SPEFD = 50;
    private static final int WIDTH = 400 ;
    private static final int HEIGHT = 600 ;
     private  BufferedImage backBufferedImage;
     private Graphics backGraphics;
    Image backgroundImage;
    Image planeImage;
    Image enemyPlaneYellow;
    Image enemyGreen;
    private int planeX = (400 - 35) / 2;
    private int planeY = 600 - 25;
    private int enemyY = 30;
    Thread thread;

    ArrayList<PlayerBullet> playerBullets = new ArrayList<>();
    public GameWindow() {
        setVisible(true);
        setSize(400, 600);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.out.println("windowClosing");
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent e) {
                super.windowClosed(e);
                System.out.printf("windowClosed");
            }
        });

        // 1: Load image
        backgroundImage = loadImageFromRes("background.png");
        planeImage = loadImageFromRes("plane3.png");
        enemyGreen = loadImageFromRes("enemy-green-1.png") ;

        // 2: Draw image

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                switch (e.getKeyCode()) {
                    case (KeyEvent.VK_RIGHT): {
                        // TODO: move plane to right
                        planeX += SPEFD;
                        repaint();
                        System.out.println("keyRight");
                        break;

                    }
                    case (KeyEvent.VK_LEFT): {
                        // TODO: move plane to left
                        planeX -= SPEFD;
                        repaint();
                        System.out.println("keyLeft");
                        break;
                    }
                    case (KeyEvent.VK_UP): {
                        // TODO: move plane to up
                        planeY -= SPEFD;
                        repaint();
                        System.out.println("keyUp");
                        break;
                    }
                    case (KeyEvent.VK_DOWN): {
                        // TODO: move plane to down

                        planeY += SPEFD;
                        repaint();
                        System.out.println("keyDown");
                        break;

                    }
                    case(KeyEvent.VK_SPACE):{
                       PlayerBullet playerBullet = new PlayerBullet();
                        playerBullet.image = loadImageFromRes("bullet.png") ;
                        playerBullet.x = planeX;
                        playerBullet.y = planeY;
                        playerBullets.add(playerBullet);


                    }

                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
            }
        });
        thread = new Thread(new Runnable(){
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(17);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    repaint();
                    enemyY +=1;
                    for(int i = 0 ; i < playerBullets.size(); i++){
                        playerBullets.get(i).y--;
                    }

                }
            }
        });

        backBufferedImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);

        thread.start();

    }



    private Image loadImageFromRes(String url) {
        try {
            Image image = ImageIO.read(new File("resources/" + url));
            return image;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override

    public void update(Graphics g) {
        if(backBufferedImage!= null) {
            backGraphics = backBufferedImage.getGraphics();
            backGraphics.drawImage(backgroundImage, 0, 0, WIDTH, HEIGHT, null);
            backGraphics.drawImage(planeImage, planeX, planeY, 35, 25, null);
            backGraphics.drawImage(enemyGreen, 30,enemyY,30,50, null);
            for(int i = 0 ; i < playerBullets.size(); i++){
                backGraphics.drawImage(
                        playerBullets.get(i).image,
                        playerBullets.get(i).x,
                        playerBullets.get(i).y, 13, 30, null);

            }

            g.drawImage(backBufferedImage, 0, 0, null);
        }
    }
}
// data encapsulation game iba