package com.nab.toyrobot.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.nab.toyrobot.serialize.NameSerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.internal.util.stereotypes.ThreadSafe;
import org.springframework.stereotype.Component;

import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Component

public final class RobotTable implements  Table{

    // private static variable to hold the singleton instance
    private static volatile Table instance;


    private int length = 5;
    private int breadth = 5;
    private Set<ToyRobot> robots = new HashSet<>();


    // private constructor to prevent instantiation from outside
    private RobotTable(int length, int breadth) {
        this.length = length;
        this.breadth = breadth;
    }


    @JsonProperty("activeRobotId")
    @JsonSerialize(using = NameSerializer.class)
    private int activeRobotId;

    @Override
    public boolean isOnTable(int x, int y) {
        return x >= 0 && x < getBreadth() && y >= 0 && y < getLength();
    }

    @Override
    public boolean detectCollision(int x, int y) {
        return robots.stream().anyMatch(e -> e.getPosition().equals(RobotPosition.builder().x(x).y(y).direction(e.getPosition().getDirection()).build()));
    }
    @Override
    public Set<Robot> report()
    {
        HashSet<Robot> robotList = new HashSet<>();
        robotList.addAll((Collection<? extends Robot>) getRobots());
        return robotList;
    }

    // public static method to get the singleton instance

    public static Table getInstance(int length, int breadth) {
        if (instance == null) { // check if the instance is not already created
            synchronized (Table.class) { // acquire lock on the class object
                if (instance == null) { // double check for thread-safety
                    instance = new RobotTable(length, breadth); // create the singleton instance
                }
            }
        }
        return instance; // return the singleton instance
    }


}
