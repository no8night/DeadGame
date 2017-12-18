package com.nonight.deadgame.model.enums;

import com.nonight.deadgame.model.BusinessException;

/**
 * Created by nonight on 2017/12/17.
 */
public enum TeamStatus {

    READY("准备中"),
    PLAYING("副本进行中"),
    FAILED("全员死亡");


    private String label;

    private TeamStatus(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public static TeamStatus getEnum(String name) {
        if (name == null) {
            return null;
        }

        for (TeamStatus enums : values()) {
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
    public static TeamStatus checkEnum(String name) throws BusinessException {
        TeamStatus enums = getEnum(name);
        if (enums == null) {
            throw new BusinessException("类型不正确");
        }
        return enums;
    }
}
