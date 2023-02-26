package com.nab.toyrobot.model;


import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.*;

@Data
@Builder
@Component
public class Table {
    private int length;
    private int breadth;
    private Set<Robot> robots = new HashSet<>();
    private Long activeRobotId;


}
