package com.nab.toyrobot.service;

import com.nab.toyrobot.enums.Direction;
import com.nab.toyrobot.exception.CollisionException;
import com.nab.toyrobot.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class TableServiceImpl implements TableService{

    @Autowired
    RobotTable table;

    @Override
    public Robot placeRobot(Position position) throws CollisionException {

        RobotPosition robotPosition = (RobotPosition) position;
        // Create a new robot
        ToyRobot robot = ToyRobot.builder().id(getNextAvailableId()).build();


        // If first robot then set ACTIVE
        if (table.getRobots().isEmpty())
            table.setActiveRobotId(robot.getId());


        // Validate if the position is not a collision
        if(!table.isCollision(robotPosition.getX(), robotPosition.getY()))
        {
            robot.setPosition(robotPosition);
            table.getRobots().add(robot);
        }
        else
            throw new CollisionException("Collision Detected");

        return robot;
    }

    @Override
    public ToyRobot rotateRobot(Rotation rotationDirection)  {


        Optional<ToyRobot> robot = getRobotById(table.getActiveRobotId());

        if(!robot.isEmpty())
        {
            if(rotationDirection.equals(Rotation.LEFT))
                robot.get().left();
            else
                robot.get().right();
        }
        return robot.get();
    }

    @Override
    public ToyRobot moveRobot()  {

        RobotTable robotTable = (RobotTable) table;

        Optional<ToyRobot> robot = getRobotById(robotTable.getActiveRobotId());
        return (ToyRobot) robot.get().move(robotTable);
    }

    @Override
    public Table report()  {
        return table;
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

    @Override
    public Optional<ToyRobot> getRobotById(int id)
    {
        return table.getRobots()
                .stream()
                .filter(r -> r.getId() == table.getActiveRobotId())
                .findFirst();
    }



}
