package com.nab.toyrobot.service;

import com.nab.toyrobot.model.Direction;
import com.nab.toyrobot.model.RotationDirection;

public interface DirectionService {
    Direction  getDefaultDirection();
    Direction  getNextDirection(Direction currentDirection, RotationDirection rotationDirection);
}