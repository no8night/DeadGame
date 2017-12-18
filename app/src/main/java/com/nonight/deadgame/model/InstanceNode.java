package com.nonight.deadgame.model;

import com.nonight.deadgame.model.enums.InstanceNodeType;
import com.nonight.deadgame.model.enums.NodeStatus;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/12/18.
 */

public class InstanceNode implements Serializable {

    private Integer id;
    private NodeStatus status;
    private InstanceNodeType nodeType;

    private String dramaContent;

    private BattleContent battleContent;

    private RewardContent rewardContent;

    public String getDramaContent() {
        return dramaContent;
    }

    public void setDramaContent(String dramaContent) {
        this.dramaContent = dramaContent;
    }

    public BattleContent getBattleContent() {
        return battleContent;
    }

    public void setBattleContent(BattleContent battleContent) {
        this.battleContent = battleContent;
    }

    public RewardContent getRewardContent() {
        return rewardContent;
    }

    public void setRewardContent(RewardContent rewardContent) {
        this.rewardContent = rewardContent;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public NodeStatus getStatus() {
        return status;
    }

    public void setStatus(NodeStatus status) {
        this.status = status;
    }

    public InstanceNodeType getNodeType() {
        return nodeType;
    }

    public void setNodeType(InstanceNodeType nodeType) {
        this.nodeType = nodeType;
    }
}
