package ru.itis.Game_Screen;

import ru.itis.Display.Display;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class Player implements KeyListener {

    private final double speed = 7.5d;

    private BufferedImage pSprite;
    private Rectangle rect;
    private double xPos, yPos, startXPos, startYPos;
    private int width, height;
    private boolean left = false, right = false, shoot = false;
    private BasicBlocks blocks;

    public PlayerWeapons playerWeapons;

    public Player(double xPos, double yPos, int width, int height, BasicBlocks blocks) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.width = width;
        this.height = height;

        rect = new Rectangle((int) xPos,(int) yPos, width, height);

        try{
            URL url = this.getClass().getResource("/ru/itis/Images/Player.png");
            pSprite = ImageIO.read(url);
        } catch(IOException e){};

        this.blocks = blocks;
        playerWeapons = new PlayerWeapons();
    }

    public void draw(Graphics2D g) {
        g.drawImage(pSprite,(int) xPos,(int) yPos, width, height, null);
        playerWeapons.draw(g);
    }

    public void update(double delta) {
        if(right && !left && xPos < Display.WIDTH-width){
            xPos += speed * delta;
            rect.x = (int) xPos;
        }if(!right && left && xPos > 10){
            xPos -= speed * delta;
            rect.x = (int) xPos;
        }
        playerWeapons.update(delta,blocks);

        if(shoot) {
            playerWeapons.shootBullet(xPos, yPos, 5, 5);
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) {
            right = true;
        } else if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) {
            left = true;
        }
        if (key == KeyEvent.VK_UP){
            shoot = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) {
            right = false;
        } else if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) {
            left = false;
        }

        if (key == KeyEvent.VK_UP){
            shoot = false;
        }
    }
}
