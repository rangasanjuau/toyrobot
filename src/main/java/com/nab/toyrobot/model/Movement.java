package com.nab.toyrobot.model;

public interface Movement {

    public enum Direction {
        NORTH, SOUTH, EAST, WEST;
    }

    Position move(Direction direction) throws Exception;

    Position rotateLeft(Position position, int angle);

    Position rotateRight(Position position, int angle);

}
