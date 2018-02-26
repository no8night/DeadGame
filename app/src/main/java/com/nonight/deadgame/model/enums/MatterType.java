package com.nonight.deadgame.model.enums;

import com.nonight.deadgame.model.BusinessException;

/**
 * Created by nonight on 2017/12/17.
 */
public enum MatterType {

    COMMON("普通"),
    IMPORTANT("重要"),
    POSITIVE("积极"),
    NEGATIVE("消极");

    private String label;

    private MatterType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public static MatterType getEnum(String name) {
        if (name == null) {
            return null;
        }

        for (MatterType enums : values()) {
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
    public static MatterType checkEnum(String name) throws BusinessException {
        MatterType enums = getEnum(name);
        if (enums == null) {
            throw new BusinessException("类型不正确");
        }
        return enums;
    }
}
