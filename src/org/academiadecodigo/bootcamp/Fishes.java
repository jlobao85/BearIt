package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.tinysound.Sound;
import org.academiadecodigo.bootcamp.tinysound.TinySound;
import org.academiadecodigo.simplegraphics.pictures.Picture;

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
    private Picture[] resources;

    public Fishes(int startX, int startY) {
        fish = new Picture(startY, startX, "resources/fish1.png");
        pic = 1;
        fish.draw();
        direction = Direction.values()[Randomizer.randomNumber(1,2)];
        prevY = Randomizer.randomNumber(WATERMINY,WATERMAXY);

        resources = new Picture[24];
        resources[0] = fish;
        for (int i = 1; i < resources.length; i++) {
            String resource = "resources/fish"+(1+i)+".png";
            resources[i] = new Picture(0, 0, resource);
        }
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

        fish.delete();

        if (prevDirection == Direction.RIGHT && goUp) {
            if (pic == 6) {
                resources[9].translate((fish.getX() - resources[9].getX()), (fish.getY() - resources[9].getY()));
                fish = resources[9]; //fish.load("resources/fish10.png");
                pic = 1;
            }
            if (pic == 5) {
                resources[10].translate((fish.getX() - resources[10].getX()), (fish.getY() - resources[10].getY()));
                fish = resources[10]; //fish.load("resources/fish11.png");
                pic = 6;
            }
            if (pic == 4) {
                resources[11].translate((fish.getX() - resources[11].getX()), (fish.getY() - resources[11].getY()));
                fish = resources[11]; //fish.load("resources/fish12.png");
                pic = 5;
            }
            if (pic == 3) {
                resources[10].translate((fish.getX() - resources[10].getX()), (fish.getY() - resources[10].getY()));
                fish = resources[10]; //fish.load("resources/fish11.png");
                pic = 4;
            }
            if (pic == 2) {
                resources[9].translate((fish.getX() - resources[9].getX()), (fish.getY() - resources[9].getY()));
                fish = resources[9]; //fish.load("resources/fish10.png");
                pic = 3;
            }
            if (pic == 1) {
                resources[8].translate((fish.getX() - resources[8].getX()), (fish.getY() - resources[8].getY()));
                fish = resources[8]; //fish.load("resources/fish9.png");
                pic = 2;
            }
        }
        else if (prevDirection == Direction.RIGHT && !goUp) {
            if (pic == 6) {
                resources[13].translate((fish.getX() - resources[13].getX()), (fish.getY() - resources[13].getY()));
                fish = resources[13]; //fish.load("resources/fish14.png");
                pic = 1;
            }
            if (pic == 5) {
                resources[14].translate((fish.getX() - resources[14].getX()), (fish.getY() - resources[14].getY()));
                fish = resources[14]; //fish.load("resources/fish15.png");
                pic = 6;
            }
            if (pic == 4) {
                resources[15].translate((fish.getX() - resources[15].getX()), (fish.getY() - resources[15].getY()));
                fish = resources[15]; //fish.load("resources/fish16.png");
                pic = 5;
            }
            if (pic == 3) {
                resources[14].translate((fish.getX() - resources[14].getX()), (fish.getY() - resources[14].getY()));
                fish = resources[14]; //fish.load("resources/fish15.png");
                pic = 4;
            }
            if (pic == 2) {
                resources[13].translate((fish.getX() - resources[13].getX()), (fish.getY() - resources[13].getY()));
                fish = resources[13]; //fish.load("resources/fish14.png");
                pic = 3;
            }
            if (pic == 1) {
                resources[12].translate((fish.getX() - resources[12].getX()), (fish.getY() - resources[12].getY()));
                fish = resources[12]; //fish.load("resources/fish13.png");
                pic = 2;
            }
        }
        else if (prevDirection == Direction.LEFT && goUp) {
            if (pic == 6) {
                resources[17].translate((fish.getX() - resources[17].getX()), (fish.getY() - resources[17].getY()));
                fish = resources[17]; //fish.load("resources/fish18.png");
                pic = 1;
            }
            if (pic == 5) {
                resources[18].translate((fish.getX() - resources[18].getX()), (fish.getY() - resources[18].getY()));
                fish = resources[18]; //fish.load("resources/fish19.png");
                pic = 6;
            }
            if (pic == 4) {
                resources[19].translate((fish.getX() - resources[19].getX()), (fish.getY() - resources[19].getY()));
                fish = resources[19]; //fish.load("resources/fish20.png");
                pic = 5;
            }
            if (pic == 3) {
                resources[18].translate((fish.getX() - resources[18].getX()), (fish.getY() - resources[18].getY()));
                fish = resources[18]; //fish.load("resources/fish19.png");
                pic = 4;
            }
            if (pic == 2) {
                resources[17].translate((fish.getX() - resources[17].getX()), (fish.getY() - resources[17].getY()));
                fish = resources[17]; //fish.load("resources/fish18.png");
                pic = 3;
            }
            if (pic == 1) {
                resources[16].translate((fish.getX() - resources[16].getX()), (fish.getY() - resources[16].getY()));
                fish = resources[16]; //fish.load("resources/fish17.png");
                pic = 2;
            }
        }
        else {
            if (pic == 6) {
                resources[21].translate((fish.getX() - resources[21].getX()), (fish.getY() - resources[21].getY()));
                fish = resources[21]; //fish.load("resources/fish22.png");
                pic = 1;
            }
            if (pic == 5) {
                resources[22].translate((fish.getX() - resources[22].getX()), (fish.getY() - resources[22].getY()));
                fish = resources[22]; //fish.load("resources/fish23.png");
                pic = 6;
            }
            if (pic == 4) {
                resources[23].translate((fish.getX() - resources[23].getX()), (fish.getY() - resources[23].getY()));
                fish = resources[23]; //fish.load("resources/fish24.png");
                pic = 5;
            }
            if (pic == 3) {
                resources[22].translate((fish.getX() - resources[22].getX()), (fish.getY() - resources[22].getY()));
                fish = resources[22]; //fish.load("resources/fish23.png");
                pic = 4;
            }
            if (pic == 2) {
                resources[21].translate((fish.getX() - resources[21].getX()), (fish.getY() - resources[21].getY()));
                fish = resources[21]; //fish.load("resources/fish22.png");
                pic = 3;
            }
            if (pic == 1) {
                resources[20].translate((fish.getX() - resources[20].getX()), (fish.getY() - resources[20].getY()));
                fish = resources[20]; //fish.load("resources/fish21.png");
                pic = 2;
            }
        }

        if (!isFished()) {
            fish.draw();
        }

    }

    private void animationLeft() {
        fish.delete();
        if (pic == 6) {
            resources[5].translate((fish.getX() - resources[5].getX()), (fish.getY() - resources[5].getY()));
            fish = resources[5]; //fish.load("resources/fish6.png");
            pic = 1;
        }
        if (pic == 5) {
            resources[6].translate((fish.getX() - resources[6].getX()), (fish.getY() - resources[6].getY()));
            fish = resources[6]; //fish.load("resources/fish7.png");
            pic = 6;
        }
        if (pic == 4) {
            resources[7].translate((fish.getX() - resources[7].getX()), (fish.getY() - resources[7].getY()));
            fish = resources[7]; //fish.load("resources/fish8.png");
            pic = 5;
        }
        if (pic == 3) {
            resources[6].translate((fish.getX() - resources[6].getX()), (fish.getY() - resources[6].getY()));
            fish = resources[6]; //fish.load("resources/fish7.png");
            pic = 4;
        }
        if (pic == 2) {
            resources[5].translate((fish.getX() - resources[5].getX()), (fish.getY() - resources[5].getY()));
            fish = resources[5]; //fish.load("resources/fish6.png");
            pic = 3;
        }
        if (pic == 1) {
            resources[4].translate((fish.getX() - resources[4].getX()), (fish.getY() - resources[4].getY()));
            fish = resources[4]; //fish.load("resources/fish5.png");
            pic = 2;
        }

        if (!isFished()) {
            fish.draw();
        }
    }

    private void animationRight() {
        fish.delete();
        if (pic == 6) {
            resources[1].translate((fish.getX() - resources[1].getX()), (fish.getY() - resources[1].getY()));
            fish = resources[1]; //fish.load("resources/fish2.png");
            pic = 1;
        }
        if (pic == 5) {
            resources[2].translate((fish.getX() - resources[2].getX()), (fish.getY() - resources[2].getY()));
            fish = resources[2]; //fish.load("resources/fish3.png");
            pic = 6;
        }
        if (pic == 4) {
            resources[3].translate((fish.getX() - resources[3].getX()), (fish.getY() - resources[3].getY()));
            fish = resources[3]; //fish.load("resources/fish4.png");
            pic = 5;
        }
        if (pic == 3) {
            resources[2].translate((fish.getX() - resources[2].getX()), (fish.getY() - resources[2].getY()));
            fish = resources[2]; //fish.load("resources/fish3.png");
            pic = 4;
        }
        if (pic == 2) {
            resources[1].translate((fish.getX() - resources[1].getX()), (fish.getY() - resources[1].getY()));
            fish = resources[1]; //fish.load("resources/fish2.png");
            pic = 3;
        }
        if (pic == 1) {
            resources[0].translate((fish.getX() - resources[0].getX()), (fish.getY() - resources[0].getY()));
            fish = resources[0]; //fish.load("resources/fish1.png");
            pic = 2;
        }

        if (!isFished()) {
            fish.draw();
        }
    }

    private void checkBounds()  {
            if ((fish.getX() <= 20 && direction == Direction.LEFT) ||
            (fish.getX() >= 1190 - fish.getWidth() && direction == Direction.RIGHT)){
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
            //IF FISH IS OUT OF WATER BECOMES FISHABLE AND SPLASHES OUT
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
            //IF FISH IS OUT OF WATER BECOMES FISHABLE AND IF ENTERS WATER SPLASHES IN
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

            //WHEN HE REACHES HIS PREVIOUS LOCATION, HE IS OUT OF JUMPING ANIMATION(jump = false)
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
