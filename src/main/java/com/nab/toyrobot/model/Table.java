package com.nab.toyrobot.model;

import java.util.Set;

public interface Table {
    public boolean isOnTable(int x, int y);

    public boolean isCollision(int x, int y);

    public Set<ToyRobot> report();
}
