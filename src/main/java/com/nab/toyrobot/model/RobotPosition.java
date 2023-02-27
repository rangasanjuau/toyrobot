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
        int nx = x;
        int ny = y;

        switch (direction) {
            case NORTH:
                ny += 1;
                break;
            case SOUTH:
                ny -= 1;
                break;
            case WEST:
                nx += 1;
                break;
            case EAST:
                nx -= 1;
                break;
        }

        //return new RobotPosition(nx,ny,direction);
        return RobotPosition.builder().x(nx).y(ny).direction(direction).build();
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
