package com.nab.toyrobot.service;


import com.nab.toyrobot.model.Direction;
import com.nab.toyrobot.model.RotationDirection;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DirectionServiceImpl implements DirectionService {
    private final List<Direction> directions = List.of(Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST);

    @Override
    public Direction getDefaultDirection() {
        return Direction.NORTH;
    }

    @Override
    public Direction getNextDirection(Direction currentDirection, RotationDirection rotationDirection) {
        int currentIndex = directions.indexOf(currentDirection);
        int newIndex = rotationDirection == RotationDirection.RIGHT ? (currentIndex + 1) % directions.size() :
                (currentIndex + directions.size() - 1) % directions.size();
        return directions.get(newIndex);
    }
}