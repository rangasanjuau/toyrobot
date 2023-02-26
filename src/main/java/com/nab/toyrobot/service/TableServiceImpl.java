package com.nab.toyrobot.service;

import com.nab.toyrobot.model.*;
import org.springframework.beans.factory.annotation.Autowired;

public class TableServiceImpl {

    @Autowired
    Table table;

    @Autowired
    DirectionService directionService;

    public Robot placeRobot(Position position) throws Exception {

        // Create a new robot
        Robot robot = Robot.builder().id(getNextAvailableId()).currentDirection(directionService.getDefaultDirection()).build();

        // If first robot then set ACTIVE
        if (table.getActiveRobotId() == null) {
            robot.setActive(true);
            table.setActiveRobotId(robot.getId());
        } else {
            robot.setActive(false);
        }

        // Validate if the position is empty
        if(isPositionEmpty(position))
        {
            robot.setPosition(position);
            table.getRobots().add(robot);
        }
        else
            throw new Exception();

        return robot;
    }

    public void moveRobot()
    {
        Robot robot = getRobotById(table.getActiveRobotId());
        Position position = robot.getPosition();

        switch (robot.getCurrentDirection()) {
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
                throw new IllegalArgumentException("Invalid Move: ");
        }
    }

    public void rotateRobot(RotationDirection rotationDirection)
    {
        Robot robot = getRobotById(table.getActiveRobotId());
        robot.setCurrentDirection(directionService.getNextDirection(robot.getCurrentDirection(), rotationDirection));
    }


    public Robot getRobotById(Long id) {
        return table.getRobots()
                .stream()
                .filter(robot -> robot.getId() == id)
                .findAny()
                .orElse(null);
    }

    public Long getNextAvailableId()
    {
        Long maxId =  table.getRobots()
                .stream().mapToLong(Robot::getId).max().orElse(0);
        return maxId + 1;
    }

    public Boolean isPositionEmpty(Position position)
    {
        return table.getRobots().stream().anyMatch( r -> r.getPosition().equals(position));
    }

}
