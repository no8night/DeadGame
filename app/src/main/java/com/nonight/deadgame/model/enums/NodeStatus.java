package com.nonight.deadgame.model.enums;

import com.nonight.deadgame.model.BusinessException;

/**
 * Created by nonight on 2017/12/17.
 */
public enum NodeStatus {

    CREATE("创建"),
    ING("进行中"),
    FINISHED("结束");


    private String label;

    private NodeStatus(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public static NodeStatus getEnum(String name) {
        if (name == null) {
            return null;
        }

        for (NodeStatus enums : values()) {
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
    public static NodeStatus checkEnum(String name) throws BusinessException {
        NodeStatus enums = getEnum(name);
        if (enums == null) {
            throw new BusinessException("类型不正确");
        }
        return enums;
    }
}
