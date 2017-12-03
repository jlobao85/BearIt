package org.academiadecodigo.bootcamp;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import org.academiadecodigo.bootcamp.tinysound.Sound;
import org.academiadecodigo.bootcamp.tinysound.TinySound;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Shape;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.awt.event.MouseEvent;

public class Fishes{

    private boolean fishable = false;
    private boolean fished = false;
    private Picture fish;
    private Direction direction;
    private Direction prevDirection;
    private int prevY;
    private boolean jump = false;
    private boolean goUp = true;
    private int pic;
    private int counter = 0;
    public static final int WATERMINY = 520;
    public static final int WATERMAXY = 750;
    private static final int JUMPREACH = 350;
    private Sound waterIn = TinySound.loadSound("water_in.wav");
    private Sound waterOut = TinySound.loadSound("water_out.wav");

    public Fishes(int startX, int startY) {
        fish = new Picture(startY, startX, "resources/fish1.png");
        pic = 1;
        fish.draw();
        direction = Direction.values()[Randomizer.randomNumber(1,2)];
        prevY = Randomizer.randomNumber(WATERMINY,WATERMAXY);
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
        if(Randomizer.randomNumber(1,500) == 99 && goUp) {
            jump = true;
            prevY = Randomizer.randomNumber(WATERMINY,WATERMAXY);
        }
    }


    public void move(Direction direction) {
        checkBounds();
        randomJump();
        //GET PREVIOUS DIRECTION BEFORE MOVING
        prevDirection = getDirection();

        //IF ON JUMP CHANGE DIRECTION METHOD NOT AVAILABLE
        if(jump) {
            direction = Direction.JUMP;
        }
        else{
            changeDirection(direction);
        }

        //FISHES CAN TAKE JUMP DIRECTION AS ARGUMENT NOT JUST RIGHT OR LEFT ANYMORE, THIS WILL MAKE POSSIBLE TO GET PREVDIRECTION IF ON JUMP
        //SO THAT CORRECT ANIMATION IS PICKED FOR JUMP MOVEMENT AND DIRECTION
        fishAnimationCounter(direction);
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

    private void fishAnimationCounter(Direction direction) {
        counter++;
        if (counter == 10){
            fishAnimation(direction);
            counter = 0;
        }
    }

    private void fishAnimation(Direction direction) {
        switch (direction) {
            case JUMP:
                //IF JUMP GET PREVIOUS DIRECTION SO THE RIGHT ANIMATION CAN BE PICKED (LEFT OR RIGHT ANIMATION PICTURES)
                animationJump(prevDirection);
                break;
            case RIGHT:
                animationRight();
                break;
            case LEFT:
                animationLeft();
                break;
        }
    }

    private void animationJump(Direction prevDirection) {
        this.prevDirection = prevDirection;

        if (prevDirection == Direction.RIGHT && goUp) {
            if (pic == 6) {
                fish.load("resources/fish10.png");
                pic = 1;
            }
            if (pic == 5) {
                fish.load("resources/fish11.png");
                pic = 6;
            }
            if (pic == 4) {
                fish.load("resources/fish12.png");
                pic = 5;
            }
            if (pic == 3) {
                fish.load("resources/fish11.png");
                pic = 4;
            }
            if (pic == 2) {
                fish.load("resources/fish10.png");
                pic = 3;
            }
            if (pic == 1) {
                fish.load("resources/fish9.png");
                pic = 2;
            }
        }
        else if (prevDirection == Direction.RIGHT && !goUp) {
            if (pic == 6) {
                fish.load("resources/fish14.png");
                pic = 1;
            }
            if (pic == 5) {
                fish.load("resources/fish15.png");
                pic = 6;
            }
            if (pic == 4) {
                fish.load("resources/fish16.png");
                pic = 5;
            }
            if (pic == 3) {
                fish.load("resources/fish15.png");
                pic = 4;
            }
            if (pic == 2) {
                fish.load("resources/fish14.png");
                pic = 3;
            }
            if (pic == 1) {
                fish.load("resources/fish13.png");
                pic = 2;
            }
        }
        else if (prevDirection == Direction.LEFT && goUp) {
            if (pic == 6) {
                fish.load("resources/fish18.png");
                pic = 1;
            }
            if (pic == 5) {
                fish.load("resources/fish19.png");
                pic = 6;
            }
            if (pic == 4) {
                fish.load("resources/fish20.png");
                pic = 5;
            }
            if (pic == 3) {
                fish.load("resources/fish19.png");
                pic = 4;
            }
            if (pic == 2) {
                fish.load("resources/fish18.png");
                pic = 3;
            }
            if (pic == 1) {
                fish.load("resources/fish17.png");
                pic = 2;
            }
        }
        else {
            if (pic == 6) {
                fish.load("resources/fish22.png");
                pic = 1;
            }
            if (pic == 5) {
                fish.load("resources/fish23.png");
                pic = 6;
            }
            if (pic == 4) {
                fish.load("resources/fish24.png");
                pic = 5;
            }
            if (pic == 3) {
                fish.load("resources/fish23.png");
                pic = 4;
            }
            if (pic == 2) {
                fish.load("resources/fish22.png");
                pic = 3;
            }
            if (pic == 1) {
                fish.load("resources/fish21.png");
                pic = 2;
            }
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
            if (fish.getX() <= 20 && direction == Direction.LEFT){
                direction = direction.getOppositeDirection();
                moveFromBounds(direction);
            } else if(fish.getX() >= 1190 - fish.getWidth() && direction == Direction.RIGHT){
                direction = direction.getOppositeDirection();
                moveFromBounds(direction);
            }

    }

    private void moveFromBounds(Direction direction) {
        switch (direction) {
            case LEFT:
                fish.translate(-Randomizer.randomNumber(1,3),0);
                break;
            case RIGHT:
                fish.translate(Randomizer.randomNumber(1,3),0);
                break;
            case JUMP:
                break;
        }
    }

    private void playSound(Sound sound){
        sound.play();
    }
    private void jump()  {
        //IS FISH IS GOING UP
        if (goUp) {
            //IF FISH IS OUT OF WATER BECOMES FISHABLE
            if(fish.getY() < WATERMINY && fish.getY() > WATERMINY - 7){
                fishable = true;
                if(!fished)playSound(waterOut);
            }
            else if(fish.getY() < WATERMINY - 10) {
                fishable = true;
            } else {
                fishable = false;
            }

            //ON GOING UP MOVEMENT GET DIRECTION AND TRANSLATE ACCORDINGLY
            if(getDirection() == Direction.LEFT){
                fish.translate(-5, -5);
            }
            else if(getDirection() == Direction.RIGHT){
                fish.translate(5, -5);
            }

            //WHEN HE REACHES THE HEIGHT OF 350, HE STARTS GOING DOWN (goUp = FALSE)
            if (fish.getY() <= JUMPREACH) {
                goUp = false;
            }
        }
        //IF FISH IS GOING DOWN
        if(!goUp) {
            //IF FISH IS OUT OF WATER BECOMES FISHABLE
            if(fish.getY() < WATERMINY && fish.getY() > WATERMINY - 7){
                fishable = true;
                if(!fished)playSound(waterIn);
            }
            else if(fish.getY() <= WATERMINY - 10){
                fishable = true;
            }
            else{
                fishable = false;
            }

            //ON GOING DOWN MOVEMENT GET DIRECTION AND TRANSLATE ACCORDINGLY
            if(getDirection() == Direction.LEFT){
                fish.translate(-5, 5);
            }
            else if(getDirection() == Direction.RIGHT){
                fish.translate(5, 5);
            }

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
        if(fished){
            String[] sounds = {"roar.ogg", "ilovethisfish.ogg"};
            Sound sound = TinySound.loadSound(sounds[Randomizer.randomNumber(2)]);
            sound.play();
        }
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
