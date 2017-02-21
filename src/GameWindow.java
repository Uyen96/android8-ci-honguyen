import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by HongUyen on 21-Feb-17.
 */
public class GameWindow extends Frame {
    Image backgroundImage;
    Image planeImage;
    private int planeX = (400 - 35) / 2;
    private int planeY = 600 - 25;
    private int w = 400;
    private int h = 600;
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

        // 2: Draw image
        repaint();

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                switch (e.getKeyCode()){

                    case ( KeyEvent.VK_RIGHT ): {
                    // TODO: move plane to right
                        if(planeX <400) {
                            planeX += 10;
                            repaint();
                            System.out.println("keyRight");
                        }

                        break;
                    }
                    case ( KeyEvent.VK_LEFT ): {
                        // TODO: move plane to left
                        if(planeX < 400 ) {
                            planeX -= 10;
                            repaint();
                            System.out.println("keyLeft");
                        }

                        break;
                    }
                    case ( KeyEvent.VK_UP ): {
                        // TODO: move plane to up
                        if(planeY < 600) {
                            planeY -= 10;
                            repaint();
                            System.out.println("keyUp");
                        }

                        break;
                    }
                    case ( KeyEvent.VK_DOWN ): {
                        // TODO: move plane to down
                        if( planeY < 600 ) {
                            planeY += 10;
                            repaint();
                            System.out.println("keyDown");
                        }

                        break;
                    }

                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
            }
        });
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
        g.drawImage(backgroundImage, 0, 0, 400, 600, null);
        g.drawImage(planeImage, planeX, planeY, 35, 25, null);
    }
}