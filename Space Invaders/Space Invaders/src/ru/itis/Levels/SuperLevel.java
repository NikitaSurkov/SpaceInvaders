package ru.itis.Levels;

import ru.itis.Game_Screen.BasicBlocks;

import java.awt.*;

public interface SuperLevel {

    void draw(Graphics2D g);
    void update(double delta, BasicBlocks blocks);
    void hasDirectionChange(double delta);
    void changeDirectionAllEnemies(double delta);

    boolean isGameOver();
    boolean isComplete();

    void destroy();
    void reset();
}
