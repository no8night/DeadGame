package com.nonight.deadgame.model;

import java.io.Serializable;

/**
 * Created by nonight on 2017/12/17.
 */
public class Skill implements Serializable {


    private String name,introduction;
    private String code;

    private Double P;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getP() {
        return P;
    }

    public void setP(Double p) {
        P = p;
    }
}
