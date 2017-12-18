package com.nonight.deadgame.model.enums;

import com.nonight.deadgame.model.BusinessException;

/**
 * Created by nonight on 2017/12/17.
 */
public enum InstanceStatus {

    CREATE("副本创建"),
    PLAYING("副本进行"),
    FINISH("副本结束");


    private String label;

    private InstanceStatus(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public static InstanceStatus getEnum(String name) {
        if (name == null) {
            return null;
        }

        for (InstanceStatus enums : values()) {
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
    public static InstanceStatus checkEnum(String name) throws BusinessException {
        InstanceStatus enums = getEnum(name);
        if (enums == null) {
            throw new BusinessException("类型不正确");
        }
        return enums;
    }
}
