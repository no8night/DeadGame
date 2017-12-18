package com.nonight.deadgame.model.enums;

import com.nonight.deadgame.model.BusinessException;

/**
 * Created by nonight on 2017/12/17.
 */
public enum EquipmentType {

    GUN("枪"),
    BATTLE("战斗"),
    REWARD("奖励");


    private String label;

    private EquipmentType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public static EquipmentType getEnum(String name) {
        if (name == null) {
            return null;
        }

        for (EquipmentType enums : values()) {
            if (enums.name().equals(name)) {
                return enums;
            }
        }
        return null;
    }

    /**
     * 如果没有对应的枚举则抛出异常
     *
     * @param name
     * @return
     */
    public static EquipmentType checkEnum(String name) throws BusinessException {
        EquipmentType enums = getEnum(name);
        if (enums == null) {
            throw new BusinessException("类型不正确");
        }
        return enums;
    }
}
