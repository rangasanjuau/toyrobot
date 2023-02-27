package com.nab.toyrobot.model;

import com.nab.toyrobot.enums.Direction;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RobotPosition implements Position{


    private int x;

    private int y;

    private Direction direction;


    @Override
    public RobotPosition getNextPosition(Direction direction) {

        switch (direction) {
            case NORTH:
                y += 1;
                break;
            case SOUTH:
                y -= 1;
                break;
            case WEST:
                x += 1;
                break;
            case EAST:
                x -= 1;
                break;
        }

        return RobotPosition.builder().x(x).y(y).direction(direction).build();
    }


    @Override
    public RobotPosition turnLeft() {
        return new RobotPosition(x, y, direction.nextDirection(Rotation.LEFT));
    }
    @Override
    public RobotPosition turnRight() {
        return new RobotPosition(x, y, direction.nextDirection(Rotation.RIGHT));
    }

}
