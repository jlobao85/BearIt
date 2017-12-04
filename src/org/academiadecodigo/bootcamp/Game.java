package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.tinysound.Music;
import org.academiadecodigo.bootcamp.tinysound.TinySound;
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
    private Menu menu;
    private Cenario cenario;
    private double posX;
    private double posY;
    private int score;
    private int tries;

    public Game() {
        fishes = new Fishes[10];
        menu = new Menu();

        //MOUSE EVENT
        Mouse mouse = new Mouse(this);
        mouse.addEventListener(MouseEventType.MOUSE_MOVED);

        //KEYBOARD EVENT
        Keyboard keyboard = new Keyboard(this);
        KeyboardEvent pressSpace = new KeyboardEvent();
        pressSpace.setKey(KeyboardEvent.KEY_SPACE);
        pressSpace.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(pressSpace);
    }

    public void menu() throws InterruptedException{
        TinySound.init();
        //PLAY SONG GAME
        Music song = TinySound.loadMusic("song.wav");
        song.play(true);

        //RESTARTS THE MENU
        menu.initMenu();

        //WHILE START ISN'T CLICKED
        while(!menu.isStartClicked()) {
            menu.animationFishes();
            Thread.sleep(100);
            if (menu.isStartClicked()) {
                //menu.delete();
                song.stop();
                start();
            }
        }
    }

    public void start() throws InterruptedException {
        score = 0;
        tries = 30;
        cenario = new Cenario();
        createFishes();
        cenario.seaDraw();

        Music water = TinySound.loadMusic("water_moving.wav");
        water.play(true);

        //WHILE FISHES NOT CATCHED AND NUM OF TRIES REACHES ZERO
        while(score < fishes.length && tries > 0){
            score = 0;
            //THREAD
            for (int i = 0; i < fishes.length; i++) {
                for(int y = 0; y <= 200; y++) {
                    System.out.println(y);
                }
                cenario.seaMovements();
                if(fishes[i].isFished()) {
                    score++;
                }
                //Thread.sleep(0);
                fishes[i].move(fishes[i].getDirection());
            }
            cenario.setScore(score + "/" + fishes.length); //SET AND DISPLAYS THE SCORES
            cenario.setTries("x " + tries); //SETS AND DISPLAYS THE TRIES
        }
        if(score == fishes.length){
            menu.changeToWinMsg(); //WIN
        }
        else{
            menu.changeToGameOver(); //LOSE
        }
        TinySound.shutdown(); //STOP GAMEPLAY SOUNDS
        menu(); // RESTART EVERYTHING AGAIN NOW WITH A WIN/LOSE MESSAGE

    }

    public void createFishes() {
        for (int i = 0; i < fishes.length; i++) {
            fishes[i] = new Fishes(Randomizer.randomNumber(Fishes.WATERMINY,Fishes.WATERMAXY),Randomizer.randomNumber(30,900));
        }
    }



    public boolean isInsideFish(double x, double y) {
        //IF SATISFIES CRITERIA TO CATCH AND IF CATCHES OR NOT THE FISH
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
        //IF SPACEBAR PRESSED CHECK IF CATCH FISH OR NOT
        if(keyboardEvent.KEY_SPACE == keyboardEvent.getKey()) {
            tries--;
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
