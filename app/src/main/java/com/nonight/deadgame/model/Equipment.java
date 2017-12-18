package com.nonight.deadgame.model;

import java.io.Serializable;

/**
 * Created by nonight on 2017/12/17.
 */
public class Equipment implements Serializable {


    private String name,introduction; //名字  介绍
    private Integer code,P;           //代码  评分

    private String imgPath;           //图片asset路径
    private EquipmentType type;

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

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public Integer getP() {
        return P;
    }

    public void setP(Integer p) {
        P = p;
    }
}
