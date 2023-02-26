package com.nab.toyrobot.model;


import lombok.Builder;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
@Builder
public class Table {
    private int length;
    private int breadth;
    private Map<Position, Boolean> positionStatus = new HashMap<>();

}
