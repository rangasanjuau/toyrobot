package com.nab.toyrobot.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.nab.toyrobot.serialize.NameSerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Component
public class RobotTable implements  Table{
    private int length = 5;
    private int breadth = 5;
    private Set<ToyRobot> robots = new HashSet<>();

    @JsonProperty("activeRobotId")
    @JsonSerialize(using = NameSerializer.class)
    private int activeRobotId;

    @Override
    public boolean isOnTable(int x, int y) {
        return x >= 0 && x < getBreadth() && y >= 0 && y < getLength();
    }

    @Override
    public boolean isCollision(int x, int y) {
        return robots.stream().anyMatch(e -> e.getPosition().equals(RobotPosition.builder().x(x).y(y).direction(e.getPosition().getDirection()).build()));
    }
    @Override
    public Set<Robot> report()
    {
        HashSet<Robot> robots = new HashSet<>();
        robots.addAll((Collection<? extends Robot>) getRobots());
        return robots;
    }


}
