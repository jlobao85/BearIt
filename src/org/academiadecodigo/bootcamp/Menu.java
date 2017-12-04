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

    private Picture[] menuFishes;
    private Picture menuRectangle;
    private Picture mouse;
    private Picture spacebar;
    private Picture logoAcademia = new Picture(865, 470, "resources/logo.png");
    private Rectangle startRectangle;
    private Rectangle creditsRectangle;
    private Text start;
    private Text credits;
    private Text instructions;
    private Text winMsg;
    private Text gameOver;
    private Text fishyTeam = new Text(895, 560, "THOSE FISHY GUYS:");
    private Text amelia = new Text(926, 580, "AMÉLIA");;
    private Text andre = new Text(926, 600, "ANDRÉ");;
    private Text joao = new Text(926, 620, "JOÃO L.");;
    private Text sofia = new Text(926, 640, "SOFIA");;
    private boolean startClicked;
    private boolean isWin;
    private boolean isGameOver;
    private int pic;

    //HAS AND DRAWS ALL ELEMENTS IN THE MENU
    public Menu() {
        Mouse menuMouse = new Mouse(this);
        menuMouse.addEventListener(MOUSE_CLICKED);
        menuMouse.addEventListener(MOUSE_MOVED);
    }

    public void initMenu() {
        startClicked = false;
        menuRectangle = new Picture(10,10, "resources/bear.jpg");
        menuRectangle.draw();

        startRectangle = new Rectangle(500,650,200,70);
        start = new Text (590, 675, "START");
        start.grow(30,25);
        start.draw();
        creditsRectangle = new Rectangle(900,650,100,70);
        credits = new Text(920, 675, "CREDITS");
        credits.grow(30,25);
        credits.draw();

        mouse = new Picture(30,690, "resources/mouse.png");
        mouse.grow(-10,-10);
        mouse.draw();
        spacebar = new Picture(-30,650, "resources/spacebar.png");
        spacebar.grow(-110,-30);
        spacebar.draw();

        instructions = new Text (80, 650, "POINT     +     CATCH!");
        instructions.grow(58,15);
        instructions.draw();

        if(isWin) {
            drawWinMsg();
        }
        if(isGameOver){
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
            delete();
            startClicked = true;
            isWin = false;
            isGameOver = false;
        }
    }

    public boolean isStartClicked() {
        return startClicked;
    }

    public void delete() {
        menuRectangle.delete();
        startRectangle.delete();
        creditsRectangle.delete();
        start.delete();
        credits.delete();
        instructions.delete();
        mouse.delete();
        spacebar.delete();
        for(int i = 0; i < menuFishes.length; i++) {
            menuFishes[i].delete();
        }
        if(isWin) {
            winMsg.delete();
        }
        if(isGameOver){
            gameOver.delete();
        }
    }

    public void changeToWinMsg() {
        isWin = true;
    }
    public void changeToGameOver() {
        isGameOver = true;
    }

    public void drawWinMsg() {
        this.winMsg = new Text (520, 340, "GREAT JOB!");
        winMsg.grow(40,35);
        winMsg.draw();
        winMsg.setColor(Color.ORANGE);
    }

    public void drawGameOver(){
        this.gameOver = new Text (520, 340, "GAME OVER!");
        gameOver.grow(40,35);
        gameOver.draw();
        gameOver.setColor(Color.RED);
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

    public void credits(){
        fishyTeam.setColor(Color.ORANGE);
        fishyTeam.draw();
        logoAcademia.draw();
        amelia.draw();
        andre.draw();
        joao.draw();
        sofia.draw();
    }
    public void deleteCredits(){
        fishyTeam.delete();
        logoAcademia.delete();
        amelia.delete();
        andre.delete();
        joao.delete();
        sofia.delete();
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        double x = mouseEvent.getX();
        double y = mouseEvent.getY();
        if((x >= startRectangle.getX() &&
                x<= (startRectangle.getX()+startRectangle.getWidth())) &&
                (y-25>= startRectangle.getY() && y-25<= (startRectangle.getY()+startRectangle.getHeight()))){
            start.setColor(Color.WHITE);
            credits.setColor(Color.BLACK);
        }
        else if((x >= creditsRectangle.getX() &&
                x<= (creditsRectangle.getX()+creditsRectangle.getWidth())) &&
                (y-25>= creditsRectangle.getY() && y-25<= (creditsRectangle.getY()+creditsRectangle.getHeight()))){
            credits.setColor(Color.WHITE);
            credits();
        }
        else{
            start.setColor(Color.BLACK);
            credits.setColor(Color.BLACK);
            deleteCredits();
        }
    }
}