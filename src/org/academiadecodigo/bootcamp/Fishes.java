package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Fishes {
    private boolean fishable = false;
    private boolean fished = false;
    private Picture fish;
    private Direction direction;
    private int prevY;
    private boolean jump = false;
    private boolean goUp = true;
    private int pic;
    private int counter = 0;

    public Fishes(int startX, int startY) {
        fish = new Picture(startY, startX, "resources/fish1.png");
        pic=1;
        fish.draw();
        direction = Direction.values()[Randomizer.randomNumber(1,2)];
        prevY = Randomizer.randomNumber(520,780);
    }

    private void changeDirection(Direction direction) {
        //1 CHANCE IN 150 TO CHANGE DIRECTION
    if(Randomizer.randomNumber(1,150) == 99) {
        direction = direction.getOppositeDirection();
        this.direction = direction;
    }
    }

    private void randomJump() {
        //1 CHANCE IN 500 TO JUMP
        if(Randomizer.randomNumber(1,500) == 99 && goUp == true) {
            jump = true;
            prevY = Randomizer.randomNumber(520,780);
        }
    }


    public void move(Direction direction) {
        changeDirection(direction);
        randomJump();
        if(jump) {
            direction = Direction.JUMP;
        }
        fishAnimationCounter();
        switch (direction) {
            case LEFT:
                fish.translate(-Randomizer.randomNumber(1,3),0);
                break;
            case RIGHT:
                fish.translate(Randomizer.randomNumber(1,3),0);
                break;
            case JUMP:
                jump();
                break;
        }
    }

    private void fishAnimationCounter() {
        counter++;
        if (counter == 10){
            fishAnimation(direction);
            counter = 0;
        }
    }

    private void fishAnimation(Direction direction) {
        switch (direction) {
            case RIGHT:
                animationRight();
            break;
            case LEFT:
                animationLeft();
                break;
        }
    }

    private void animationLeft() {
        if (pic == 6) {
            fish.load("resources/fish6.png");
            pic = 1;
        }
        if (pic == 5) {
            fish.load("resources/fish7.png");
            pic = 6;
        }
        if (pic == 4) {
            fish.load("resources/fish8.png");
            pic = 5;
        }
        if (pic == 3) {
            fish.load("resources/fish7.png");
            pic = 4;
        }
        if (pic == 2) {
            fish.load("resources/fish6.png");
            pic = 3;
        }
        if (pic == 1) {
            fish.load("resources/fish5.png");
            pic = 2;
        }
    }

    private void animationRight() {
        if (pic == 6) {
            fish.load("resources/fish2.png");
            pic = 1;
        }
        if (pic == 5) {
            fish.load("resources/fish3.png");
            pic = 6;
        }
        if (pic == 4) {
            fish.load("resources/fish4.png");
            pic = 5;
        }
        if (pic == 3) {
            fish.load("resources/fish3.png");
            pic = 4;
        }
        if (pic == 2) {
            fish.load("resources/fish2.png");
            pic = 3;
        }
        if (pic == 1) {
            fish.load("resources/fish1.png");
            pic = 2;
        }
    }

    public void checkBounds()  {
        if (fish.getX() <= 20 || fish.getX() >= 1200 - fish.getWidth()) {
            direction = direction.getOppositeDirection();
            while (fish.getX()<=30 || fish.getX() >= 1190 - fish.getWidth()) {
                moveFromBounds(direction);
            }
        }
    }

    private void moveFromBounds(Direction direction) {
        switch (direction) {
            case LEFT:
                //Thread.sleep(1);
                fish.translate(-Randomizer.randomNumber(1,3),0);
                break;
            case RIGHT:
                //Thread.sleep(1);
                fish.translate(Randomizer.randomNumber(1,3),0);
                break;
            case JUMP:
                break;
        }
    }

    private void jump()  {
        //IS FISH IS GOING UP
        if (goUp) {
            //IF FISH IS OUT OF WATER BECOMES FISHABLE
            if (fish.getY() <= 510) {
                fishable = true;
            } else {
                fishable = false;
            }
            fish.translate(0, -5);
            //WHEN HE REACHES THE HEIGHT OF 350, HE STARTS GOING DOWN (goUp = FALSE)
            if (fish.getY() <= 350) {
                goUp = false;
            }
        }
        //IF FISH IS GOING DOWN
        if(!goUp) {
            //IF FISH IS OUT OF WATER BECOMES FISHABLE
            if (fish.getY() <= 510) {
                fishable = true;
            } else {
                fishable = false;
            }
            //Thread.sleep(1);
            fish.translate(0, 5);
            //WHEN HE REACHES HIS PREVIOUS LOCATION, HE IS OUT OF JUMPING ANYMATION(jump = false)
            if(fish.getY() >= prevY) {
                jump = false;
                goUp = true;
            }
        }
    }

    public Direction getDirection() {
        return direction;
    }

    public boolean isFishable() {
        return fishable;
    }

    public boolean isFished() {
        return fished;
    }

    public void setFished(boolean fished) {
        this.fished = fished;
    }

    public int getX() {
        return fish.getX();
    }

    public int getY() {
        return fish.getY();
    }

    public int getWidth() {
        return fish.getWidth();
    }

    public int getHeight() {
        return fish.getHeight();
    }

    public void delete(){
        fish.delete();
    }
}
