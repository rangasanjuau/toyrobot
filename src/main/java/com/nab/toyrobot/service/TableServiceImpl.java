package com.nab.toyrobot.service;

import com.nab.toyrobot.exception.CollisionException;
import com.nab.toyrobot.model.RobotPosition;
import com.nab.toyrobot.model.RobotTable;
import com.nab.toyrobot.model.ToyRobot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TableServiceImpl implements TableService{

    @Autowired
    RobotTable table;
    @Autowired
    DirectionService directionService;

    @Override
    public ToyRobot placeRobot(RobotPosition position) throws CollisionException {

        // Create a new robot
        ToyRobot robot = ToyRobot.builder().id(getNextAvailableId()).build();


        // If first robot then set ACTIVE
        if (table.getRobots() == null)
            table.setActiveRobotId(robot.getId());


        // Validate if the position is not a collision
        if(!table.isCollision(position.getX(), position.getY()))
        {
            robot.setPosition(position);
            table.getRobots().add(robot);
        }
        else
            throw new CollisionException("Collision Detected");

        return robot;
    }


    @Override
    public ToyRobot getRobotById(int id) {
        return table.getRobots()
                .stream()
                .filter(robot -> robot.getId() == id)
                .findAny()
                .orElse(null);
    }
    @Override
    public int getNextAvailableId()
    {
        int maxId =  table.getRobots()
                .stream().mapToInt(ToyRobot::getId).max().orElse(0);
        return maxId + 1;
    }

    @Override
    public boolean isOnTable(int x, int y) {
        return x >= 0 && x < table.getBreadth() && y >= 0 && y < table.getLength();
    }





}
