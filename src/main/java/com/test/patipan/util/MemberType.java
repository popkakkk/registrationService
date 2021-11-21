package com.test.patipan.util;

import lombok.Getter;

@Getter
public enum MemberType {
    PLATINUM(1),
    GOLD(2),
    SILVER(3);

    private int id;

    MemberType(int id) {
        this.id = id;
    }
}
