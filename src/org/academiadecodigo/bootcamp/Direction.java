package org.academiadecodigo.bootcamp;

public enum Direction {
    JUMP,
    LEFT,
    RIGHT;

    public Direction getOppositeDirection() {
        Direction newDirection = null;
        switch (this) {
            case RIGHT:
                newDirection = Direction.LEFT;
                break;
            case LEFT:
                newDirection = Direction.RIGHT;
                break;
            default:
                newDirection = this;
                break;
        }
        return newDirection;
    }
}
