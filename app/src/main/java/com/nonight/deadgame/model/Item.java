package com.nonight.deadgame.model;

import java.io.Serializable;

/**
 * Created by nonight on 2017/12/17.
 */
public class Item  implements Serializable {




    private String name,introduction;
    private Integer code;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
