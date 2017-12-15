package ru.itis.Enemy_Types;

import ru.itis.Game_Screen.BasicBlocks;
import ru.itis.Game_Screen.Player;

import java.awt.*;
import java.util.ArrayList;

public interface EnemyType {

    public abstract void draw(Graphics2D g);
    public abstract void update(double delta, Player player, BasicBlocks blocks);
    public abstract void changeDirection(double delta);

    public abstract boolean deathScene();
    public abstract boolean collide(int i, Player player, BasicBlocks blocks, ArrayList<EnemyType> enemies);
    public abstract boolean isOutOfBounds();
}
