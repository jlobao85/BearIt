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

    private Picture[] menuFishes1;
    private Picture[] menuFishes2;
    private Picture[] menuFishes3;
    private Picture[] menuFishes4;
    private Picture[] menuFishes5;
    private Picture[] menuFishes6;
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
    private Text amelia = new Text(926, 580, "AMÉLIA");
    private Text andre = new Text(926, 600, "ANDRÉ");
    private Text joao = new Text(926, 620, "JOÃO L.");
    private Text sofia = new Text(926, 640, "SOFIA");
    private boolean startClicked;
    private boolean isWin;
    private boolean isGameOver;
    private boolean isOnMenu;
    private int pic;

    //HAS AND DRAWS ALL ELEMENTS IN THE MENU
    public Menu() {
        Mouse menuMouse = new Mouse(this);
        menuMouse.addEventListener(MOUSE_CLICKED);
        menuMouse.addEventListener(MOUSE_MOVED);
        menuRectangle = new Picture(10,10, "resources/bear.jpg");
        startRectangle = new Rectangle(500,650,200,70);
        start = new Text (590, 675, "START");
        start.grow(30,25);
        creditsRectangle = new Rectangle(900,650,100,70);
        credits = new Text(920, 675, "CREDITS");
        credits.grow(30,25);
        mouse = new Picture(30,690, "resources/mouse.png");
        mouse.grow(-10,-10);
        spacebar = new Picture(-30,650, "resources/spacebar.png");
        spacebar.grow(-110,-30);
        instructions = new Text (80, 650, "    POINT       +       CATCH!");
        instructions.grow(58,15);
        winMsg = new Text (520, 340, "GREAT JOB!");
        winMsg.grow(40,35);
        gameOver = new Text (520, 340, "GAME OVER!");
        gameOver.grow(40,35);
        menuFishes1 = new Picture[4];
        menuFishes1[0] = new Picture(505,640,"resources/fish1.png");
        menuFishes1[1] = new Picture(505,640,"resources/fish2.png");
        menuFishes1[2] = new Picture(505,640,"resources/fish3.png");
        menuFishes1[3] = new Picture(505,640,"resources/fish4.png");
        menuFishes2 = new Picture[4];
        menuFishes2[0] = new Picture(570,640,"resources/fish1.png");
        menuFishes2[1] = new Picture(570,640,"resources/fish2.png");
        menuFishes2[2] = new Picture(570,640,"resources/fish3.png");
        menuFishes2[3] = new Picture(570,640,"resources/fish4.png");
        menuFishes3 = new Picture[4];
        menuFishes3[0] = new Picture(635,640,"resources/fish1.png");
        menuFishes3[1] = new Picture(635,640,"resources/fish2.png");
        menuFishes3[2] = new Picture(635,640,"resources/fish3.png");
        menuFishes3[3] = new Picture(635,640,"resources/fish4.png");
        menuFishes4 = new Picture[4];
        menuFishes4[0] = new Picture(505,710,"resources/fish5.png");
        menuFishes4[1] = new Picture(505,710,"resources/fish6.png");
        menuFishes4[2] = new Picture(505,710,"resources/fish7.png");
        menuFishes4[3] = new Picture(505,710,"resources/fish8.png");
        menuFishes5 = new Picture[4];
        menuFishes5[0] = new Picture(570,710,"resources/fish5.png");
        menuFishes5[1] = new Picture(570,710,"resources/fish6.png");
        menuFishes5[2] = new Picture(570,710,"resources/fish7.png");
        menuFishes5[3] = new Picture(570,710,"resources/fish8.png");
        menuFishes6 = new Picture[4];
        menuFishes6[0] = new Picture(635,710,"resources/fish5.png");
        menuFishes6[1] = new Picture(635,710,"resources/fish6.png");
        menuFishes6[2] = new Picture(635,710,"resources/fish7.png");
        menuFishes6[3] = new Picture(635,710,"resources/fish8.png");
    }

    public void initMenu() {
        isOnMenu = true;
        startClicked = false;
        menuRectangle.draw();
        start.draw();
        credits.draw();
        mouse.draw();
        spacebar.draw();
        instructions.draw();
        if(isWin) {
            drawWinMsg();
        }
        if(isGameOver){
            drawGameOver();
        }
        for(int i = 0; i < menuFishes1.length; i++) {
            menuFishes1[i].draw();
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
            isOnMenu = false;
            startClicked = true;
            isWin = false;
            isGameOver = false;
        }
    }

    public boolean isStartClicked() {
        return startClicked;
    }

    public void delete() {
        deleteCredits();
        menuRectangle.delete();
        startRectangle.delete();
        creditsRectangle.delete();
        start.delete();
        credits.delete();
        instructions.delete();
        mouse.delete();
        spacebar.delete();
        for(int i = 0; i < menuFishes1.length; i++) {
            menuFishes1[i].delete();
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
        winMsg.draw();
        winMsg.setColor(Color.ORANGE);
    }

    public void drawGameOver(){
        gameOver.draw();
        gameOver.setColor(Color.RED);
    }

    public void animationFishes() {

        if (pic == 6 && isOnMenu) {
            menuFishes1[2].delete();
            menuFishes2[2].delete();
            menuFishes3[2].delete();
            menuFishes4[2].delete();
            menuFishes5[2].delete();
            menuFishes6[2].delete();
            menuFishes1[1].draw();//("resources/fish2.png");
            menuFishes2[1].draw();
            menuFishes3[1].draw();
            menuFishes4[1].draw();
            menuFishes5[1].draw();
            menuFishes6[1].draw();
            pic = 1;
        }
        if (pic == 5 && isOnMenu) {
            menuFishes1[3].delete();
            menuFishes2[3].delete();
            menuFishes3[3].delete();
            menuFishes4[3].delete();
            menuFishes5[3].delete();
            menuFishes6[3].delete();
            menuFishes1[2].draw();//("resources/fish3.png");
            menuFishes2[2].draw();
            menuFishes3[2].draw();
            menuFishes4[2].draw();
            menuFishes5[2].draw();
            menuFishes6[2].draw();
            pic = 6;
        }
        if (pic == 4 && isOnMenu) {
            menuFishes1[2].delete();
            menuFishes2[2].delete();
            menuFishes3[2].delete();
            menuFishes4[2].delete();
            menuFishes5[2].delete();
            menuFishes6[2].delete();
            menuFishes1[3].draw();//("resources/fish4.png");
            menuFishes2[3].draw();
            menuFishes3[3].draw();
            menuFishes4[3].draw();
            menuFishes5[3].draw();
            menuFishes6[3].draw();
            pic = 5;
        }
        if (pic == 3 && isOnMenu) {
            menuFishes1[1].delete();
            menuFishes2[1].delete();
            menuFishes3[1].delete();
            menuFishes4[1].delete();
            menuFishes5[1].delete();
            menuFishes6[1].delete();
            menuFishes1[2].draw();//("resources/fish3.png");
            menuFishes2[2].draw();
            menuFishes3[2].draw();
            menuFishes4[2].draw();
            menuFishes5[2].draw();
            menuFishes6[2].draw();
            pic = 4;
        }
        if (pic == 2 && isOnMenu) {
            menuFishes1[0].delete();
            menuFishes2[0].delete();
            menuFishes3[0].delete();
            menuFishes4[0].delete();
            menuFishes5[0].delete();
            menuFishes6[0].delete();
            menuFishes1[1].draw();//("resources/fish2.png");
            menuFishes2[1].draw();
            menuFishes3[1].draw();
            menuFishes4[1].draw();
            menuFishes5[1].draw();
            menuFishes6[1].draw();
            pic = 3;
        }
        if (pic == 1 && isOnMenu) {
            menuFishes1[1].delete();
            menuFishes2[1].delete();
            menuFishes3[1].delete();
            menuFishes4[1].delete();
            menuFishes5[1].delete();
            menuFishes6[1].delete();
            menuFishes1[0].draw();//("resources/fish1.png");
            menuFishes2[0].draw();
            menuFishes3[0].draw();
            menuFishes4[0].draw();
            menuFishes5[0].draw();
            menuFishes6[0].draw();
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
            if (isOnMenu) {
                credits.setColor(Color.WHITE);
                credits();
            }
        }
        else{
            start.setColor(Color.BLACK);
            credits.setColor(Color.BLACK);
            deleteCredits();
        }
    }
}