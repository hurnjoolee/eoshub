package io.eoshub.type;


import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

import io.eoshub.util.HashMapUtil;

public enum SortOrderType {

    ASC("ASC"),
    DESC("DESC");

    private static final Map<String, SortOrderType> LOOK_UP = new HashMap<String, SortOrderType>(
            HashMapUtil.getCapacity(SortOrderType.values().length));

    static {
        for (SortOrderType type : EnumSet.allOf(SortOrderType.class)) {
            LOOK_UP.put(type.getCode(), type);
        }
    }

    public static SortOrderType get(String code) {
        return LOOK_UP.get(code);
    }

    private String code;

    private SortOrderType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
