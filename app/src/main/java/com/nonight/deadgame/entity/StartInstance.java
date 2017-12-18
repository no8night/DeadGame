package com.nonight.deadgame.entity;

import com.nonight.deadgame.model.Instance;
import com.nonight.deadgame.model.InstanceNode;
import com.nonight.deadgame.model.enums.InstanceStatus;

import java.util.List;

/**
 * Created by Administrator on 2017/12/18.
 */

public class StartInstance extends Instance {

    private Integer id = 1;                 //副本id

    private Integer nodeNumber = 8;        //节点数量

    private List<InstanceNode> nodes;

    private InstanceStatus status;

    
}
