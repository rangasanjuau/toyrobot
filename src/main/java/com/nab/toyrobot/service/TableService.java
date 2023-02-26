package com.nab.toyrobot.service;

import com.nab.toyrobot.model.Position;
import com.nab.toyrobot.model.Robot;
import com.nab.toyrobot.model.RotationDirection;

import java.util.Set;

public interface TableService {

    public Robot placeRobot(Position position) throws Exception;
    public Robot moveRobot();
    public Robot rotateRobot(RotationDirection rotationDirection);
    public Robot getRobotById(Long id) ;
    public Long getNextAvailableId();
    public Boolean isPositionEmpty(Position position);
    public Set<Robot> report();

}
