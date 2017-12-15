package ru.itis.Game_Screen;

import ru.itis.PlayerBullets.MachineGun;
import ru.itis.PlayerBullets.PlayerWeaponType;
import ru.itis.Timer.Timer;

import java.awt.*;
import java.util.ArrayList;

public class PlayerWeapons {

    private Timer timer;
    public ArrayList<PlayerWeaponType> weapons = new ArrayList<PlayerWeaponType>();

    public void draw(Graphics2D g) {

        for(int i = 0; i < weapons.size(); i++) {
            weapons.get(i).draw(g);
        }
    }

    public void update(double delta, BasicBlocks blocks) {


        for(int i = 0; i < weapons.size(); i++) {
            weapons.get(i).update(delta, blocks);
            if(weapons.get(i).destroy()) {
                weapons.remove(i);
            }

        }
    }

    public void shootBullet(double xPos, double yPos, int width, int height) {
        int a= 0;
            weapons.add(new MachineGun(xPos + 32.9, yPos + 18, width, height + 6));
    }

    public void reset() {
        weapons.clear();
    }
}
