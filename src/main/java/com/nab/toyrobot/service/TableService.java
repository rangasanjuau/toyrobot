package com.nab.toyrobot.service;

import com.nab.toyrobot.exception.CollisionException;
import com.nab.toyrobot.model.Direction;
import com.nab.toyrobot.model.RobotPosition;
import com.nab.toyrobot.model.ToyRobot;
import com.nab.toyrobot.model.RotationDirection;

import java.util.Set;

public interface TableService {

    public ToyRobot placeRobot(RobotPosition position) throws CollisionException;
    public ToyRobot getRobotById(int id) ;
    public int getNextAvailableId();
    public boolean isOnTable(int x, int y);

}
