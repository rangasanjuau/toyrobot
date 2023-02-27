package com.nab.toyrobot.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.nab.toyrobot.serialize.NameSerializer;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ToyRobot implements  Robot{


    @JsonProperty("id")
    @JsonSerialize(using = NameSerializer.class)
    private int id;

    private RobotPosition position;

    @Override
    public Robot move(Table table) {

        if (position != null) {
            RobotPosition newPosition = position.getNextPosition(position.getDirection());
            if (table.isOnTable(newPosition.getX(), newPosition.getY())) {
                position = newPosition;
            }
        }
        return this;
    }
    @Override
    public Robot left() {
        if (position != null) {
            position = position.turnLeft();
        }
        return this;
    }

    @Override
    public Robot right() {
        if (position != null) {
            position = position.turnRight();
        }
        return this;
    }

}
