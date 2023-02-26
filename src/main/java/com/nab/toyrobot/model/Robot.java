package com.nab.toyrobot.model;


import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.UUID;

@Data
@Builder
public class Robot {

    private Long id;
    private Position position;
    private Direction currentDirection;
    private boolean isActive;


}
