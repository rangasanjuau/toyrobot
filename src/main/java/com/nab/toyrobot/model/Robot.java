package com.nab.toyrobot.model;

import lombok.Data;

@Data
public class Robot implements Movement {

    private Position position;

    private Direction facing;

    private Table table;

    @Override
    public Position move(Direction direction) throws Exception {

        detectCollision();

        switch (direction) {
            case NORTH:
                if ((position.getY() + 1)  < table.getBreadth())               // Check Edge Condition
                    position.setY(position.getY()+1);
                break;
            case SOUTH:
                if ((position.getY() + 1 >= 0))                                  // Check Edge Condition
                    position.setY(position.getY()-1);
                break;
            case EAST:
                if ((position.getX() + 1)  < table.getLength())                // Check Edge Condition
                    position.setX(position.getX()+1);
                break;
            case WEST:
                if ((position.getX() - 1)  >= 0 )
                    position.setX(position.getX()-1);
                break;
            default:
                throw new IllegalArgumentException("Invalid direction: " + direction);
        }

        return position;
    }

    private void detectCollision() {




    }

    @Override
    public Position rotateLeft(Position position, int angle) {
        return null;
    }

    @Override
    public Position rotateRight(Position position, int angle) {
        return null;
    }
}
