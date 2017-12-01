package org.academiadecodigo.bootcamp;


import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;

import static org.academiadecodigo.simplegraphics.mouse.MouseEventType.*;

public class Menu implements MouseHandler {

    private Rectangle menuRectangle;
    private Rectangle startRectangle;
    private Text start;
    private boolean startClicked;


    public Menu() {

        this.menuRectangle = new Rectangle(10,10,1200,800);
        menuRectangle.draw();
        this.startRectangle = new Rectangle(500,400,200,70);
        startRectangle.draw();
        this.start = new Text (590, 425, "START");
        start.draw();
        start.grow(30,25);
        Mouse menuMouse = new Mouse(this);
        menuMouse.addEventListener(MOUSE_CLICKED);
        startClicked = false;
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
    }

    public boolean isStartClicked() {
        return startClicked;
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }
}