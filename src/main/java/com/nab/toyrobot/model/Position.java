package com.nab.toyrobot.model;

import com.nab.toyrobot.enums.Direction;

public interface Position {

    public Position getNextPosition(Direction direction);
    public Position turnLeft();
    public Position turnRight();
}
