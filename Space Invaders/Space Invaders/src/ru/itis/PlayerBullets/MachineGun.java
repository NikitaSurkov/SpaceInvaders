package ru.itis.PlayerBullets;

import ru.itis.Display.Display;
import ru.itis.Game_Screen.BasicBlocks;

import java.awt.*;

public class MachineGun extends PlayerWeaponType {

    private Rectangle bullet;
    private final double speed = 2.5d;

    public MachineGun(double xPos, double yPos, int width,int height) {
        this.setxPos(xPos);
        this.setyPos(yPos);
        this.setWidth(width);
        this.setHeight(height);

        this.bullet = new Rectangle((int) getxPos(),(int) getyPos(), getWidth(), getHeight());
    }


    @Override
    public void draw(Graphics2D g) {
        if(bullet == null) {
            return;
        }

        g.setColor(Color.RED);
        g.fill(bullet);

    }

    @Override
    public void update(double delta, BasicBlocks blocks) {
        if(bullet == null) {
            return;
        }
        this.setyPos(getyPos() - (delta * speed));
        bullet.y = (int) this.getyPos();
        wallCollide(blocks);
        isOutOfBounds();
    }

    @Override
    public boolean collisionRect(Rectangle rect) {
        if(this.bullet == null) {
            return false;
        }

        if(bullet.intersects(rect)) {
            this.bullet = null;
            return true;
        }

        return false;
    }

    @Override
    public boolean collisionPoly(Polygon poly) {
        return false;
    }

    @Override
    public boolean destroy() {
        if(bullet == null)
            return true;

        return false;
    }

    @Override
    protected void wallCollide(BasicBlocks blocks) {
        for(int i = 0; i < blocks.wall.size(); i++) {
            if(bullet.intersects(blocks.wall.get(i))) {
                blocks.wall.remove(i);
                bullet = null;
                return;
            }
        }

    }

    @Override
    protected void isOutOfBounds() {
        if(this.bullet == null) {
            return;
        }

        if(bullet.y < 0 || bullet.y > Display.HEIGHT || bullet.x < 0 || bullet.x > Display.WIDTH){
            bullet = null;
        }

    }
}
