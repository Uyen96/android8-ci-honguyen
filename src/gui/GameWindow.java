package gui;

import controllers.*;
import javafx.scene.input.KeyCode;
import model.EnemyPlaneModel;
import utils.KeyInPut;
import utils.RandomAll;
import utils.Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.*;

import static java.awt.event.KeyEvent.*;
import static utils.RandomAll.nextX;

/**
 * Created by HongUyen on 27-Feb-17.
 */
public class GameWindow extends Frame {
    public static final int SCREEN_HEIGHT = 600;
    public static final int SCREEN_WIDTH = 400;
    public static final int TIME_GAME_LOOP = 17;



    private BufferedImage backBufferedImage;
    private Graphics backGraphics;

    private ControllerManager controllerManagers;
    private BackGroundController backGroundController;
    private Vector<IsLandController> isLandControllers;
    private PlayerPlaneController playerPlaneController;
    private Vector<PlayerBulletController> playerBulletControllers;
    private Vector<EnemyPlaneController> enemyPlaneControllers ;
    private Vector<EnemyBulletController> enemyBulletControllers ;

    private boolean isMoveRight;
    private boolean isMoveLeft;
    private boolean isMoveUp;
    private boolean isMoveDown;
    private boolean isShoot;


    Thread thread;



    public GameWindow(){
        this.setVisible(true);
        this.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        this.setLocationRelativeTo(null);

        isLandControllers = new Vector<>();
        playerBulletControllers = new Vector<>();
        enemyPlaneControllers = new Vector<>();
        enemyBulletControllers = new Vector<>();
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("Window closing");
                System.exit(0);
            }
        });

        controllerManagers = new ControllerManager(isLandControllers,
                playerBulletControllers,
                enemyPlaneControllers,
                enemyBulletControllers);


        playerPlaneController = new PlayerPlaneController((SCREEN_WIDTH - 35)/2, SCREEN_HEIGHT - 31,
                playerBulletControllers);
        backGroundController = new BackGroundController();
        // Buffer Image
        backBufferedImage = new BufferedImage(
                SCREEN_WIDTH,
                SCREEN_HEIGHT,
                BufferedImage.TYPE_INT_ARGB);

        backGraphics = backBufferedImage.getGraphics();


        addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                int key = e.getKeyCode();
                if (key == KeyEvent.VK_RIGHT)  {
                    isMoveRight = true;
                }
                else if (key == KeyEvent.VK_LEFT)  {
                    isMoveLeft = true;
                }
                else if (key == KeyEvent.VK_UP) {
                    isMoveUp = true;
                }
                else if (key == KeyEvent.VK_DOWN) {
                    isMoveDown = true;
                }
                if (key == KeyEvent.VK_SPACE ){
                    isShoot = true;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                int key = e.getKeyCode();
                if (key == KeyEvent.VK_RIGHT)  {
                    isMoveRight = false;
                }
                else if (key == KeyEvent.VK_LEFT)  {
                    isMoveLeft = false;
                }
                else if (key == KeyEvent.VK_UP) {
                    isMoveUp = false;
                }
                else if (key == KeyEvent.VK_DOWN) {
                    isMoveDown = false;
                }
                else if(key == KeyEvent.VK_SPACE){
                    isShoot = false;
                }
            }
        });

        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    backGroundController.run();
                    islandCreate();
                    enemyCreate();
                  //      controllerManagers.run();

                    try {
                        Thread.sleep(TIME_GAME_LOOP);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    movePlane();
                    repaint();
                }

            }
        });


    }

    public void start(){
        thread.start();
    }




    public void islandCreate(){
        if (isLandControllers.size() < 4) {
            isLandControllers.add(new IsLandController(RandomAll.nextX(SCREEN_WIDTH - 50, 0), 10));
        }
    }

    public void enemyCreate(){
        int r = RandomAll.nextX(3,1);
        if (r == 2 ) {
            EnemyPlaneController enemyPlaneController = new EnemyPlaneController(
                    RandomAll.nextX(SCREEN_WIDTH - EnemyPlaneModel.DEFAULT_WIDTH, 0), 0,
                    enemyBulletControllers);
            enemyPlaneControllers.add(enemyPlaneController);
        }
    }


    public void removeByIterator(){
        //remove bullets out side
        Iterator<PlayerBulletController> iterator = playerBulletControllers.iterator();
        while(iterator.hasNext()){
            if(iterator.next().getModel().getHeight() < 0){
                iterator.remove();
            }
        }

        //remove enemy out side
        Iterator<EnemyPlaneController> iteratorEnemy = enemyPlaneControllers.iterator();
        while(iteratorEnemy.hasNext()){
            if(iteratorEnemy.next().getModel().getX() > SCREEN_HEIGHT)iteratorEnemy.remove();
        }

//        Iterator<EnemyPlaneController> iteratorEnemy2 = enemies2.iterator();
//        while(iteratorEnemy.hasNext()){
//            if(iteratorEnemy.next().getModel().getEnemyX() > SCREEN_HEIGHT)iteratorEnemy.remove();
//        }

        //remove plaerbullet out side
        Iterator<PlayerBulletController> iteratorBullet = playerBulletControllers.iterator();
        while(iteratorBullet.hasNext()){
            if(iteratorBullet.next().getModel().getY() <= 0)iteratorBullet.remove();
        }

    }

    private void isDestroyEnemy() {
        Iterator<EnemyPlaneController> enemyItr = enemyPlaneControllers.iterator();
        Iterator<PlayerBulletController> playerBulletItr = playerBulletControllers.iterator();
        if(playerBulletControllers.size() == 5){


        } else {
            while (enemyItr.hasNext()) {
                EnemyPlaneController enemy = enemyItr.next();
                while (playerBulletItr.hasNext()) {
                    PlayerBulletController playerBullet = playerBulletItr.next();
                    if ((playerBullet.getModel().getX() + playerBullet.getModel().getWidth()
                            >= enemy.getModel().getX() && playerBullet.getModel().getX()
                            <= enemy.getModel().getWidth() + enemy.getModel().getX() - playerBullet.getModel().getWidth())
                            && (playerBullet.getModel().getHeight() + playerBullet.getModel().getY())
                            <= (enemy.getModel().getHeight() + enemy.getModel().getY())) {
                        playerBulletItr.remove();
                        enemyItr.remove();
                        break;
                    }
                }
            }
        }
    }
    @Override
    public synchronized void update(Graphics g) {
        if(backBufferedImage!=null) {
            backGraphics = backBufferedImage.getGraphics();
            backGroundController.draw(backGraphics);
            playerPlaneController.draw(backGraphics);

            //controllerManagers.draw(backGraphics);
            g.drawImage(backBufferedImage,0,0,null);

        }
    }

    private void movePlane(){
        if(isMoveUp){
            playerPlaneController.flyUp();
        }
        //move plane to down
        if(isMoveDown){
            playerPlaneController.flyDown();
        }
        //move plane to left
        if(isMoveLeft){
            playerPlaneController.flyLeft();
        }
        //move plane to right
        if(isMoveRight){
            playerPlaneController.flyRight();
        }
        if(isShoot ){
            playerPlaneController.shoot();
        }
    }
}
