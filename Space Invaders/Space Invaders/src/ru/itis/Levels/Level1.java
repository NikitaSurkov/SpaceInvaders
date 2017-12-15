package ru.itis.Levels;

import ru.itis.Enemy_Types.EnemyType;
import ru.itis.Game_Screen.BasicBlocks;
import ru.itis.Game_Screen.Player;

import java.awt.*;
import java.util.ArrayList;

public class Level1 implements SuperLevel {

    private Player player;
    private ArrayList<EnemyType> enemies = new ArrayList<EnemyType>();

    public Level1(Player player) {
        this.player = player;
    }

        @Override
        public void draw (Graphics2D g){

        }

        @Override
        public void update ( double delta, BasicBlocks blocks){

        }

        @Override
        public void hasDirectionChange ( double delta){

        }

        @Override
        public void changeDirectionAllEnemies ( double delta){

        }

        @Override
        public boolean isGameOver () {
            return false;
        }

        @Override
        public boolean isComplete () {
            return false;
        }

        @Override
        public void destroy () {

        }

        @Override
        public void reset () {

        }
    }

