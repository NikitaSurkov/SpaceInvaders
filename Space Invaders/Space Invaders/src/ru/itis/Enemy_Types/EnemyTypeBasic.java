package ru.itis.Enemy_Types;

import ru.itis.Game_Screen.BasicBlocks;
import ru.itis.Game_Screen.Player;
import ru.itis.Sprite.SpriteAnimation;
import ru.itis.Timer.Timer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class EnemyTypeBasic implements EnemyType {

    private Rectangle rect;
    private SpriteAnimation enemySprite;

    EnemyTypeBasic(double xPos, double yPos, int rows, int columns) {
        enemySprite = new SpriteAnimation(xPos, yPos, 300);

        try{
            URL url = this.getClass().getResource("/ru/itis/Images/Player.png");
            BufferedImage enemySprite = ImageIO.read(url);
            for(int i = 0; i < 2; i++) {
                
            }
        } catch(IOException e){};

    }
    @Override
    public void draw(Graphics2D g) {

    }

    @Override
    public void update(double delta, Player player, BasicBlocks blocks) {

    }

    @Override
    public void changeDirection(double delta) {

    }

    @Override
    public boolean deathScene() {
        return false;
    }

    @Override
    public boolean collide(int i, Player player, BasicBlocks blocks, ArrayList<EnemyType> enemies) {
        return false;
    }

    @Override
    public boolean isOutOfBounds() {
        return false;
    }
}
