package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Cenario {
    private Picture cenario;
    private Picture sea;
    private Picture claw;
    private Picture fish;
    private Text score;
    private Text tries;
    private int counter;
    private int pic;

    public Cenario() {
        cenario = new Picture(10,10,"resources/cenario.jpg");
        cenario.draw();

        sea = new Picture(10,510,"resources/sea.png");

        fish = new Picture(970, 40, "resources/fish1.png");
        fish.draw();
        score = new Text( 1110,40, "0/10");
        score.draw();
        score.grow(50,50);

        claw = new Picture(0,10,"resources/claw.png");
        claw.draw();
        claw.grow(-40,-20);
        tries = new Text( 290,40, "x 30");
        tries.draw();
        tries.grow(50, 50);

        counter = 0;
        pic = 1;
    }

    public void seaDraw() {
        sea.draw();
    }

    public void seaMovements() {
        counter++;
        if (counter == 75) {
        if(pic == 3) {
            sea.load("resources/sea3.png");
            pic =2;
        }else if (pic == 2) {
                sea.load("resources/sea1.png");
                pic = 1;
            }
            else if (pic == 1) {
                sea.load("resources/sea.png");
                pic = 3;
            }
            counter=0;
        }
    }

    public void setScore(String s) {
        score.setText(s);
    }
    public void setTries(String s) {
        tries.setText(s);
    }
}
