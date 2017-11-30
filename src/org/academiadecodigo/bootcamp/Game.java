package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;


public class Game implements MouseHandler, KeyboardHandler {
    private Fishes[] fishes;
    private double posX;
    private double posY;
    private int score = 0;

    public Game() {
        fishes = new Fishes[10];
    }
    public void start(Cenario cenario, Player player) throws InterruptedException {
        createFishes();

        //MOUSE EVENTS
        Mouse mouse = new Mouse(this);
        mouse.addEventListener(MouseEventType.MOUSE_CLICKED);
        mouse.addEventListener(MouseEventType.MOUSE_MOVED);

        //KEYBOARD EVENT
        Keyboard keyboard = new Keyboard(this);
        KeyboardEvent pressSpace = new KeyboardEvent();
        pressSpace.setKey(KeyboardEvent.KEY_SPACE);
        pressSpace.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(pressSpace);


        while(score < fishes.length){
            score = 0;
            for (int i = 0; i < fishes.length; i++) {
                //for(int y = 0; y <= 500; y++) {
                //    System.out.println(y);
                //}
                if(fishes[i].isFished()) {
                    score++;
                }
                Thread.sleep(2);
                fishes[i].checkBounds();
                fishes[i].move(fishes[i].getDirection());
            }
            cenario.setScore(score + "/" + fishes.length);
        }
    }

    public void createFishes() {
        for (int i = 0; i < fishes.length; i++) {
            fishes[i] = new Fishes(Randomizer.randomNumber(520,780),Randomizer.randomNumber(30,900));
        }
    }



    public boolean isInsideFish(double x, double y) {
        for (Fishes f : fishes) { //recognize that the mouse is inside the rectangle
            if (x >= f.getX() && x <= (f.getX() + f.getWidth()/*FISH SIZE*/) &&
                    (y - 25/*mouse Y default value*/ >= f.getY()) && (y - 25/*mouse Y default value*/ <= (f.getY() + f.getHeight()/*FISH SIZE*/))) {
                if (f.isFishable()) {
                        f.setFished(true);
                        f.delete();
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        if(keyboardEvent.KEY_SPACE == keyboardEvent.getKey()) {
            isInsideFish(posX, posY);
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        posX = e.getX();
        posY = e.getY();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }
}
