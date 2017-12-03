package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import static org.academiadecodigo.simplegraphics.mouse.MouseEventType.*;

public class Menu implements MouseHandler {

    private Picture menuRectangle;
    private Rectangle startRectangle;
    private Text start;
    private Text instructions;
    private Text gameOver;
    private boolean startClicked;
    private boolean isGameOver;
    private Picture[] menuFishes;
    private int pic;
    private Picture mouse;
    private Picture spacebar;

    public Menu() {
        Mouse menuMouse = new Mouse(this);
        menuMouse.addEventListener(MOUSE_CLICKED);
        menuMouse.addEventListener(MOUSE_MOVED);
        initMenu();
    }

    public void initMenu() {
        startClicked = false;
        menuRectangle = new Picture(10,10, "resources/bear.jpg");
        menuRectangle.draw();
        startRectangle = new Rectangle(500,650,200,70);

        start = new Text (590, 675, "START");
        start.draw();
        start.grow(30,25);

        mouse = new Picture(30,690, "resources/mouse.png");
        spacebar = new Picture(-30,650, "resources/spacebar.png");
        mouse.draw();
        mouse.grow(-10,-10);
        spacebar.draw();
        spacebar.grow(-110,-30);

        instructions = new Text (80, 650, "POINT     +     SHOOT!");
        instructions.grow(58,15);
        instructions.draw();

        if(isGameOver) {
            drawGameOver();
        }
        menuFishes = new Picture[6];
        menuFishes[0] = new Picture(505,640,"resources/fish1.png");
        menuFishes[1] = new Picture(570,640,"resources/fish1.png");
        menuFishes[2] = new Picture(635,640,"resources/fish1.png");
        menuFishes[3] = new Picture(505,710,"resources/fish5.png");
        menuFishes[4] = new Picture(570,710,"resources/fish5.png");
        menuFishes[5] = new Picture(635,710,"resources/fish5.png");
        for(int i = 0; i < menuFishes.length; i++) {
            menuFishes[i].draw();
        }
        pic = 1;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        double x = e.getX();
        double y = e.getY();
        clickStart(x, y);
    }

    private void clickStart(double x, double y)  {
        if((x >= startRectangle.getX() && x<= (startRectangle.getX()+startRectangle.getWidth())) && (y-25>= startRectangle.getY() && y-25<= (startRectangle.getY()+startRectangle.getHeight()))){
            startClicked = true;
            isGameOver = false;
        }
    }

    public void delete() {
        menuRectangle.delete();
        startRectangle.delete();
        start.delete();
        instructions.delete();
        mouse.delete();
        spacebar.delete();
        for(int i = 0; i < menuFishes.length; i++) {
            menuFishes[i].delete();
        }
        if(isGameOver) {
            gameOver.delete();
        }
    }

    public void changeToGameOver () {
        isGameOver = true;
    }

    public void drawGameOver() {
        this.gameOver = new Text (520, 340, "GREAT JOB!");
        gameOver.draw();
        gameOver.setColor(Color.ORANGE);
        gameOver.grow(40,35);
    }

    public void animationFishes() {
        if (pic == 6) {
            for (int i = 0; i < 3; i++) {
                menuFishes[i].load("resources/fish2.png");
            }
            for (int i = 3; i < 6; i++) {
                menuFishes[i].load("resources/fish6.png");
            }
            pic = 1;
        }
        if (pic == 5) {
            for (int i = 0; i < 3; i++) {
                menuFishes[i].load("resources/fish3.png");
            }
            for (int i = 3; i < 6; i++) {
                menuFishes[i].load("resources/fish7.png");
            }
            pic = 6;
        }
        if (pic == 4) {
            for (int i = 0; i < 3; i++) {
                menuFishes[i].load("resources/fish4.png");
            }
            for (int i = 3; i < 6; i++) {
                menuFishes[i].load("resources/fish8.png");
            }
            pic = 5;
        }
        if (pic == 3) {
            for (int i = 0; i < 3; i++) {
                menuFishes[i].load("resources/fish3.png");
            }
            for (int i = 3; i < 6; i++) {
                menuFishes[i].load("resources/fish7.png");
            }
            pic = 4;
        }
        if (pic == 2) {
            for (int i = 0; i < 3; i++) {
                menuFishes[i].load("resources/fish2.png");
            }
            for (int i = 3; i < 6; i++) {
                menuFishes[i].load("resources/fish6.png");
            }
            pic = 3;
        }
        if (pic == 1) {
            for (int i = 0; i < 3; i++) {
                menuFishes[i].load("resources/fish1.png");
            }
            for (int i = 3; i < 6; i++) {
                menuFishes[i].load("resources/fish5.png");
            }
            pic = 2;
        }
    }


    public boolean isStartClicked() {
        return startClicked;
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        double x = mouseEvent.getX();
        double y = mouseEvent.getY();
        if((x >= startRectangle.getX() && x<= (startRectangle.getX()+startRectangle.getWidth())) && (y-25>= startRectangle.getY() && y-25<= (startRectangle.getY()+startRectangle.getHeight()))){
            start.setColor(Color.WHITE);
        }
        else{
            start.setColor(Color.BLACK);
        }
    }
}