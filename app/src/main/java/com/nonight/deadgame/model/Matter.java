package com.nonight.deadgame.model;

import com.nonight.deadgame.model.enums.MatterType;

import java.util.Date;

/**
 * Created by Administrator on 2018/1/15.
 */

public class Matter {


    private Integer code;
    private Date time;
    private MatterType type;
    private String discription;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public MatterType getType() {
        return type;
    }

    public void setType(MatterType type) {
        this.type = type;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }
}
