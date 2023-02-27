package com.nab.toyrobot.service;

import com.nab.toyrobot.enums.Direction;
import com.nab.toyrobot.exception.CollisionException;
import com.nab.toyrobot.model.*;

import java.awt.event.ComponentEvent;
import java.util.Optional;
import java.util.Set;

public interface TableService {

    public Robot placeRobot(Position position) throws CollisionException;
    public Optional<ToyRobot> getRobotById(int id) ;
    public int getNextAvailableId();
    public boolean isOnTable(int x, int y);
    public ToyRobot moveRobot();
    public ToyRobot rotateRobot(Rotation rotationDirection);

    public Table report();

}
