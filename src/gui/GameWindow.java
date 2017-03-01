package gui;

import controllers.*;
import model.EnemyBulletModel;
import model.EnemyPlaneModel;
import model.PlayerBulletModel;
import model.PlayerPlaneModel;
import utils.KeyInPut;
import utils.Utils;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.Random;

/**
 * Created by HongUyen on 27-Feb-17.
 */
public class GameWindow extends Frame {
    private static final int SPEED = 3;
    public static final int SCREEN_HEIGHT = 600;
    public static final int SCREEN_WIDTH = 400;
    private static final double AOT = 60.0;

    private BufferedImage backBufferImage;
    private Graphics backGraphics;

    private PlayerPlaneController playerPlaneController;
    private EnemyPlaneController enemy;

    private boolean isCount = false;
    private long now;
    private long lastTime;
    private long lastTime2;
    private long lastTime3;
    private long lastTimePress = 0;
    private int delayEnemyMove;
    private int typeEnemy;
    private int delayItems;
    Thread thread;
//bullet

    private Image playerBullet;

    private boolean isMoveRight;
    private boolean isMoveLeft;
    private boolean isMoveUp;
    private boolean isMoveDown;
    private boolean isShoot;

    private ArrayList<PlayerBulletController> bullets;
    private ArrayList<EnemyBulletController> enemyBullets;
    private ArrayList<EnemyPlaneController> enemyY;
    private ArrayList<EnemyPlaneController> enemyB;
    private BackGroundController backGround;

    public GameWindow(){
        setVisible(true);
        setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        bullets = new ArrayList<>();
        enemyY = new ArrayList<>();
        enemyB = new ArrayList<>();

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.out.println("WindowClosing");
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent e) {
                super.windowClosed(e);
                System.out.println("WindowClosed");
            }
        });

        //2: Draw image
        backGround = new BackGroundController();
        playerPlaneController = new PlayerPlaneController(SCREEN_WIDTH /2,SCREEN_HEIGHT - 35);
        playerBullet = Utils.loadImageFromRes("bullet.png");
        update(getGraphics());

        addKeyListener(new KeyInPut(this));

        thread = new Thread(new Runnable(){
            @Override
            public void run() {
                lastTime = getNow();
                lastTime2 = getNow();
                double ns = 1000000000/AOT;
                double delta = 0;
                double alpha = 0;
                double gamma = 0;
                int countEnemy = 0;
                int count = 0;
                int random = 0;
                while(true){
                    backGround.run();
                    try {
                        Thread.sleep(17);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    movePlane();
                    repaint();
                    if(bullets != null){
                        for (PlayerBulletController bullet : bullets)
                            bullet.run();
                    }

                    now = getNow();
                    delta += (now - lastTime);
                    lastTime = now;


                    delayEnemyMove = Utils.RandomAll(10000,2000);

                    delayItems = Utils.RandomAll(50000,20000);

                    if(delta >= delayEnemyMove){
                        countEnemy++;
                        typeEnemy = Utils.RandomAll(2,1);
                        EnemyCreate(typeEnemy);
                        delta-=delayEnemyMove;
                    }
                    now = getNow();
                    gamma += (now - lastTime2);
                    lastTime2 = now;

                    if(enemyY != null){
                        for (EnemyPlaneController enemy : enemyY){
                            enemy.run(1);

                            random = Utils.RandomAll(2,1);
                            if(random == 1) {
                                count++;
                                if (count == 45) {
                                    if (enemy.getModel().getBullets().size() < 3) {
                                        enemy.addBullet(new EnemyBulletController(enemy.getModel().getEnemyX() + enemy.getModel().getWidth() / 2 - 9 / 2,
                                                enemy.getModel().getHeight() + enemy.getModel().getEnemyY()));
                                    }
                                    count = 0;
                                }
                            }
                        }

                    }

                    isDestroyEnemy();
                    for (EnemyPlaneController enemy : enemyY) {
                        if (enemy.getModel().getBullets() != null) {
                            if(random == 1) {
                                for (EnemyBulletController enemyBullet : enemy.getModel().getBullets()) {
                                    enemyBullet.run(1);

                                }
                            } else if(random == 2){
                                for (EnemyBulletController enemyBullet : enemy.getModel().getBullets()) {
                                    enemyBullet.run(2);
                                }
                            }
                        }
                    }

                    removeByIterator();
                }
            }
        });


        backBufferImage = new BufferedImage(
                SCREEN_WIDTH,
                SCREEN_HEIGHT,
                BufferedImage.TYPE_INT_ARGB);


    }



    public void ItemsCreate(){

        int random = Utils.RandomAll(2,1);
        String direct = "";
        if(random == 1){
            direct = "power-up.png";
        } else if(random == 3){

        }
    }

    public void removeByIterator(){
        Iterator<PlayerBulletController> iterator = bullets.iterator();
        while(iterator.hasNext()){
            if(iterator.next().getModel().getHeight() < 0){
                iterator.remove();
            }
        }

        Iterator<EnemyPlaneController> iteratorEnemy = enemyY.iterator();
        while(iteratorEnemy.hasNext()){
            if(iteratorEnemy.next().getModel().getEnemyX() > SCREEN_HEIGHT)iteratorEnemy.remove();
        }

        Iterator<EnemyPlaneController> iteratorEnemy2 = enemyB.iterator();
        while(iteratorEnemy.hasNext()){
            if(iteratorEnemy.next().getModel().getEnemyX() > SCREEN_HEIGHT)iteratorEnemy.remove();
        }

        Iterator<PlayerBulletController> iteratorBullet = bullets.iterator();
        while(iteratorBullet.hasNext()){
            if(iteratorBullet.next().getModel().getY() <= 0)iteratorBullet.remove();
        }

    }


    private void isDestroyEnemy() {
        Iterator<EnemyPlaneController> enemyItr = enemyY.iterator();
        Iterator<PlayerBulletController> playerBulletItr = bullets.iterator();
        if(bullets.size() == 5){


        } else {
            while (enemyItr.hasNext()) {
                EnemyPlaneController enemy = enemyItr.next();
                while (playerBulletItr.hasNext()) {
                    PlayerBulletController playerBullet = playerBulletItr.next();
                    if ((playerBullet.getModel().getX() + playerBullet.getModel().getWidth()
                            >= enemy.getModel().getEnemyX() && playerBullet.getModel().getX()
                            <= enemy.getModel().getWidth() + enemy.getModel().getEnemyX() - playerBullet.getModel().getWidth())
                            && (playerBullet.getModel().getHeight() + playerBullet.getModel().getY())
                            <= (enemy.getModel().getHeight() + enemy.getModel().getEnemyY())) {
                        playerBulletItr.remove();
                        enemyItr.remove();
                        break;
                    }
                }
            }
        }
    }


    //key input
    public void keyPressed(KeyEvent e)                                                                              {
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


    public void keyReleased(KeyEvent e){
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






    private long getNow(){
        return System.currentTimeMillis();
    }

    private void movePlane(){

        if(isMoveUp){
            playerPlaneController.run(1);
        }

        if(isMoveDown){
            playerPlaneController.run(2);
        }

        if(isMoveLeft){
            playerPlaneController.run(3);
        }

        if(isMoveRight){
            playerPlaneController.run(4);
        }
        if(isShoot && getNow() - lastTimePress > 300){
            bullets.add(new PlayerBulletController(playerPlaneController.getModel().getPlaneX() + 30/2,
                    playerPlaneController.getModel().getPlaneY() - 15));
            lastTimePress = getNow();
        }

    }

    public void start(){
        thread.start();
    }

    //load image with path


    private void EnemyCreate(int typeEnemy){


        if(typeEnemy == 1) {
            enemy = new EnemyPlaneController(Utils.RandomAll(SCREEN_WIDTH - 50, 80), 0,
                    Utils.loadImageFromRes("enemy_plane_white_3.png"));
        } else if(typeEnemy == 2){
            enemy = new EnemyPlaneController(Utils.RandomAll(SCREEN_WIDTH - 50, 80), 0,
                    Utils.loadImageFromRes("enemy_plane_yellow_2.png"));
        }
        enemyY.add(enemy);

    }

    @Override
    public void update(Graphics g) {
        if(backBufferImage != null) {
            backGraphics = backBufferImage.getGraphics();
            backGround.draw(backGraphics);

            playerPlaneController.draw(backGraphics);
            if(bullets != null) {
                for (PlayerBulletController bullet : bullets) {
                    bullet.draw(backGraphics);
                }
            }

            if(enemyBullets != null){
                for (EnemyBulletController bullet : enemyBullets){
                    bullet.draw(backGraphics);
                }
            }



            if(enemyY != null){
                for (EnemyPlaneController enemy : enemyY){
                    enemy.draw(backGraphics);
                }
            }

            for (EnemyPlaneController enemy : enemyY){
                for (EnemyBulletController bullets : enemy.getModel().getBullets()){
                    bullets.draw(backGraphics);
                }
            }

            g.drawImage(backBufferImage, 0, 0, null);
        }
    }

}
