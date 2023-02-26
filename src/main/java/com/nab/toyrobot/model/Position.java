package com.nab.toyrobot.model;

public interface Position {
    public RobotPosition getNextPosition();

    public RobotPosition turnLeft();

    public RobotPosition turnRight();
}
