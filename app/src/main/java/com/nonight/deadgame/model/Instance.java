package com.nonight.deadgame.model;

import com.nonight.deadgame.model.enums.InstanceStatus;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/12/18.
 */

public class Instance implements Serializable {

    private Integer id;                 //副本id

    private Integer nodeNumber ;        //节点数量

    private List<InstanceNode> nodes;

    private InstanceStatus status;

    private Integer playNodesSeq ;                 //进行中的节点


    public List<InstanceNode> getNodes() {
        return nodes;
    }

    public void setNodes(List<InstanceNode> nodes) {
        this.nodes = nodes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNodeNumber() {
        return nodeNumber;
    }

    public void setNodeNumber(Integer nodeNumber) {
        this.nodeNumber = nodeNumber;
    }

    public InstanceStatus getStatus() {
        return status;
    }

    public void setStatus(InstanceStatus status) {
        this.status = status;
    }

    public Integer getPlayNodesSeq() {
        return playNodesSeq;
    }

    public void setPlayNodesSeq(Integer playNodesSeq) {
        this.playNodesSeq = playNodesSeq;
    }
}
