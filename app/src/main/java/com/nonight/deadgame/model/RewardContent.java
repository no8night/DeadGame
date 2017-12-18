package com.nonight.deadgame.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/12/18.
 */

public class RewardContent implements Serializable {


    private String dramaString;

    private List<Item> items;

    private Integer rewardPoint;

    public String getDramaString() {
        return dramaString;
    }

    public void setDramaString(String dramaString) {
        this.dramaString = dramaString;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Integer getRewardPoint() {
        return rewardPoint;
    }

    public void setRewardPoint(Integer rewardPoint) {
        this.rewardPoint = rewardPoint;
    }
}
