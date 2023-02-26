package com.nab.toyrobot.factory;

import com.nab.toyrobot.model.Table;

public final class TableFactory {

    private static final Table INSTANCE = Table.builder().build();

    public static Table getInstance() {
        return INSTANCE;
    }




}
