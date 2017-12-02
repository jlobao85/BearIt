package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Cenario {
    private Picture cenario;
    private Picture minirect;
    private Text score;
    private int counter;
    private int pic;

    public Cenario() {
        this.cenario = new Picture(10,10,"resources/cenario.jpg");
        cenario.draw();
        this.minirect = new Picture(10,510,"resources/sea.png");
        //minirect.draw();
        score = new Text( 1120,40, "0/10");
        score.draw();
        score.grow(50,50);
        counter = 0;
        pic = 1;
    }

    public void seaDraw() {
        minirect.draw();
    }

    public void seaMovements() {
        counter++;
        if (counter == 75) {
        if(pic == 3) {
            minirect.load("resources/sea3.png");
            pic =2;
        }else if (pic == 2) {
                minirect.load("resources/sea1.png");
                pic = 1;
            }
            else if (pic == 1) {
                minirect.load("resources/sea.png");
                pic = 3;
            }
            counter=0;
        }
    }
    public int getCenarioHeight() {
        return cenario.getHeight();
    }

    public int getCenarioWidth() {
        return cenario.getWidth();
    }

    public void setScore(String s) {
        score.setText(s);
    }
}
