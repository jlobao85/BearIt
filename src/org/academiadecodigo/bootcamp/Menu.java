package org.academiadecodigo.bootcamp;


import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import static org.academiadecodigo.simplegraphics.mouse.MouseEventType.*;

public class Menu implements MouseHandler {

    private Picture menuRectangle;
    private Rectangle startRectangle;
    private Rectangle bear;
    private Text start;
    private boolean startClicked;
    private Picture[] menuFishes;
    private int pic;

    public Menu() {

        this.menuRectangle = new Picture(10,10, "resources/bear.jpg");
        menuRectangle.draw();
        this.startRectangle = new Rectangle(500,650,200,70);
        this.start = new Text (590, 675, "START");
        start.draw();
        start.grow(30,25);
        Mouse menuMouse = new Mouse(this);
        menuMouse.addEventListener(MOUSE_CLICKED);
        startClicked = false;
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

    public void init() throws InterruptedException {


    }

    public int getX(){
        return startRectangle.getX();
    }

    public int getY(){
        return startRectangle.getY();
    }

    public int getWidth(){
        return startRectangle.getWidth();
    }

    public int getHeight(){
        return startRectangle.getHeight();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        double x = e.getX();
        double y = e.getY();
        clickStart(x, y);
    }

    private void clickStart(double x, double y)  {
        if((x >= startRectangle.getX() && x<= (startRectangle.getX()+startRectangle.getWidth())) && (y-25>= startRectangle.getY() && y-25<= (startRectangle.getY()+startRectangle.getHeight()))){
            this.startClicked = true;
        }
    }

    public void delete() {
        menuRectangle.delete();
        startRectangle.delete();
        start.delete();
        for(int i = 0; i < menuFishes.length; i++) {
            menuFishes[i].delete();
        }
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

    }
}