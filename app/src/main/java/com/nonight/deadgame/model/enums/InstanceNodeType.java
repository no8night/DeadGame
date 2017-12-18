package com.nonight.deadgame.model.enums;

import com.nonight.deadgame.model.BusinessException;

/**
 * Created by nonight on 2017/12/17.
 */
public enum InstanceNodeType {

    DRAMA("剧本"),
    BATTLE("战斗"),
    REWARD("奖励");


    private String label;

    private InstanceNodeType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public static InstanceNodeType getEnum(String name) {
        if (name == null) {
            return null;
        }

        for (InstanceNodeType enums : values()) {
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
    public static InstanceNodeType checkEnum(String name) throws BusinessException {
        InstanceNodeType enums = getEnum(name);
        if (enums == null) {
            throw new BusinessException("类型不正确");
        }
        return enums;
    }
}
