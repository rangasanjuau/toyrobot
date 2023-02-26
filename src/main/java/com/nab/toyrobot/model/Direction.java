package com.nab.toyrobot.model;

public enum Direction {

    NORTH(0, 1),
    EAST(1, 0),
    SOUTH(0, -1),
    WEST(-1, 0);

    private final int xd;
    private final int yd;

    Direction(int xd, int yd) {
        this.xd = xd;
        this.yd = yd;
    }

    public int getX() {
        return xd;
    }

    public int getY() {
        return yd;
    }

    public Direction getLeft() {
        return values()[(ordinal() + 3) % 4];
    }

    public Direction getRight() {
        return values()[(ordinal() + 1) % 4];
    }
}
