package com.nonight.deadgame.model;

import com.nonight.deadgame.model.enums.EquipmentType;

import java.io.Serializable;

/**
 * Created by nonight on 2017/12/17.
 */
public class Equipment implements Serializable {


    private String name,introduction; //名字  介绍
    private String code;           //代码  评分
    private Double P;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public Double getP() {
        return P;
    }

    public void setP(Double p) {
        P = p;
    }
}
