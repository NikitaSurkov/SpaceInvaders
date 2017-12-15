package ru.itis.State;

import ru.itis.Game_Screen.GameScreen;

import java.awt.*;
import java.util.ArrayList;

public class StateMachine {

    private ArrayList<SuperStateMachine> states = new ArrayList<SuperStateMachine>();
    private Canvas canvas;
    private byte selectState = 0;

    public StateMachine(Canvas canvas) {
        SuperStateMachine game = new GameScreen();
        states.add(game);

        this.canvas = canvas;
    }

    public void draw(Graphics2D g) {
        states.get(selectState).draw(g);
    }

    public void update(double delta) {
        states.get(selectState).update(delta);
    }

    public void setState(byte b) {
        for(int i = 0; i < canvas.getKeyListeners().length; i++)
            canvas.removeKeyListener(canvas.getKeyListeners()[i]);
        selectState = b;
        states.get(selectState).init(canvas);
    }

    public byte getStates() {
        return selectState;
    }
}
