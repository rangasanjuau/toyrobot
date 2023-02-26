package com.nab.toyrobot.model;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ToyRobot implements  Robot{

    private int id;

    private RobotPosition position;

    @Override
    public Robot move(RobotTable table) {

        if (position != null) {
            RobotPosition newPosition = position.getNextPosition();
            if (table.isOnTable(newPosition.getX(), newPosition.getY())) {
                position = newPosition;
            }
        }
        return this;
    }
    @Override
    public Robot left() {
        if (position != null) {
            position = position.turnLeft();
        }
        return this;
    }

    @Override
    public Robot right() {
        if (position != null) {
            position = position.turnRight();
        }
        return this;
    }

}
