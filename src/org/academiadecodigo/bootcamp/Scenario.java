package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Scenario {
    private Picture scenario;
    private Picture[] seaResources;
    private Picture sea;
    private Picture claw;
    private Picture fish;
    private Text score;
    private Text tries;
    private int counter;
    private int pic;

    //HAS AND DRAWS ALL ELEMENTS IN THE GAME BUT NOT IN THE MENU WHICH HAS ITS OWN CLASS
    public Scenario() {
        scenario = new Picture(10,10,"resources/scenario.jpg");
        seaResources = new Picture[3];
        seaResources[0] = new Picture(10,510,"resources/sea.png");
        seaResources[1] = new Picture(10,510, "resources/sea1.png");
        seaResources[2] = new Picture(10,510, "resources/sea3.png");
        fish = new Picture(970, 40, "resources/fish1.png");
        score = new Text( 1110,40, "0/10");
        score.grow(50,50);
        claw = new Picture(0,10,"resources/claw.png");
        claw.grow(-40,-20);
        tries = new Text( 290,40, "x 50");
        tries.grow(50, 50);

        sea = seaResources[0];
        scenario.draw();
        fish.draw();
        score.draw();
        claw.draw();
        tries.draw();
        counter = 0;
        pic = 1;
    }


    public void seaMovements() {
        counter++;
        if (counter == 75) {
        if(pic == 3) {
            sea.delete();
            sea = seaResources[2];
            sea.draw();
            //sea.load("resources/sea3.png");
            pic =2;
        }else if (pic == 2) {
            sea.delete();
            sea = seaResources[1];
            sea.draw();
            //sea.load("resources/sea1.png");
            pic = 1;
            }
            else if (pic == 1) {
            sea.delete();
            sea = seaResources[0];
            sea.draw();
            //sea.load("resources/sea.png");
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
