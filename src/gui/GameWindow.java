package gui;

import com.sun.deploy.panel.AbstractRadioPropertyGroup;
import controllers.*;
import utils.Utils;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Created by HongUyen on 27-Feb-17.
 */
public class GameWindow extends Frame {
    public static final int WIDTH = 400;
    public static final int HEIGHT= 600;

    public static int getWIDTH() {
        return WIDTH;
    }

    public static int getHEIGHT() {
        return HEIGHT;
    }

    BufferedImage backBufferedImage;
    private Graphics backGraphics;
    BackGroundController backGround;
    PlayerPlaneController plane;
    ArrayList<PlayerBulletController> playerBulletList;
    EnemyPlaneController enemy;
    EnemyBulletController enemyBullet;
    Thread thread;


    public GameWindow(){
        setVisible(true);
        setSize(WIDTH, HEIGHT);



        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                super.windowClosing(windowEvent);
                System.out.println("Closing");
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent windowEvent) {
                super.windowClosed(windowEvent);
                System.out.println("Closed");
                System.exit(0);
            }
        });

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                switch (e.getKeyCode()){
                    case(KeyEvent.VK_LEFT):{
                        plane.getModel().moveLeft();
                        break;
                    }
                    case ( KeyEvent.VK_RIGHT):{
                        plane.getModel().moveRight();
                        break;
                    }
                    case (KeyEvent.VK_DOWN):{
                        plane.getModel().moveDown();
                        break;
                    }
                    case (KeyEvent.VK_UP):{
                        plane.getModel().moveUp();
                        break;
                    }
                    case (KeyEvent.VK_SPACE):{
                        PlayerBulletController playerBullet = new PlayerBulletController(plane.getModel().getX(),
                                plane.getModel().getY());
                        playerBullet.draw(getGraphics());
                        playerBulletList.add(playerBullet);
                      //  playerBullet.run();
                        break;

                    }
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
            }
        });
        backGround  = new BackGroundController(0, 0, WIDTH, HEIGHT);
        plane = new PlayerPlaneController((WIDTH - 35)/2, HEIGHT -25, 35,25);
        playerBulletList = new ArrayList<>();
        update(getGraphics());
        repaint();


        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                    while (true) {
                        try {
                            Thread.sleep(17);

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        repaint();
                        for (PlayerBulletController playerBullet : playerBulletList) {
                            playerBullet.run();
                        }
                    }
                }
            
        });
        backBufferedImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
        backGraphics = backBufferedImage.getGraphics();
    }



    public void start(){
        thread.start();
    }

    @Override
    public void update(Graphics graphics) {
        if (backBufferedImage != null) {
            backGround.draw(backGraphics);
            plane.draw(backGraphics);
        }
        for(PlayerBulletController playerBullet : playerBulletList){
            playerBullet.draw(getGraphics());
        }
        graphics.drawImage(backBufferedImage, 0,0,null);
    }
}
