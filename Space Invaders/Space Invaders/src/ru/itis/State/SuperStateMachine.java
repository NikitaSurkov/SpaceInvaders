package ru.itis.State;

import java.awt.*;

public interface SuperStateMachine {

    public void update(double delta);
    public abstract void draw(Graphics2D g);
    public abstract void init(Canvas canvas);
}
