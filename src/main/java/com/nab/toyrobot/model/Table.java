package com.nab.toyrobot.model;


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
public class Table {
    private int length = 5;
    private int breadth = 5;
    private Set<Robot> robots = new HashSet<>();
    private Long activeRobotId;


}
