package com.nab.toyrobot.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RobotPosition implements  Position{


    private int x;

    private int y;

    private Direction direction;


    @Override
    public RobotPosition getNextPosition() {

        int nextX = x + direction.getX();
        int nextY = y + direction.getY();
        return new RobotPosition(nextX, nextY, direction);
    }
    @Override
    public RobotPosition turnLeft() {
        return new RobotPosition(x, y, direction.getLeft());
    }
    @Override
    public RobotPosition turnRight() {
        return new RobotPosition(x, y, direction.getRight());
    }

}
