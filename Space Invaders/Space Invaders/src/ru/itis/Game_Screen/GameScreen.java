package ru.itis.Game_Screen;

import ru.itis.Display.Display;
import ru.itis.Enemy_Types.EnemyType;
import ru.itis.State.SuperStateMachine;

import java.awt.*;
import java.util.ArrayList;

public class GameScreen implements SuperStateMachine {

    private Player player;
    private BasicBlocks blocks;

    public GameScreen() {
        blocks = new BasicBlocks();
        player = new Player(Display.WIDTH / 2,Display.HEIGHT * (3.3/4),70,70, blocks);

    }
    @Override
    public void update(double delta) {
        player.update(delta);
    }

    @Override
    public void draw(Graphics2D g) {
        player.draw(g);
        blocks.draw(g);
    }

    @Override
    public void init(Canvas canvas) {
        canvas.addKeyListener(player);
    }
}
