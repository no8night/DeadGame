package com.nonight.deadgame.factory;

import com.nonight.deadgame.model.Instance;
import com.nonight.deadgame.model.InstanceNode;
import com.nonight.deadgame.model.enums.InstanceNodeType;
import com.nonight.deadgame.model.enums.InstanceStatus;
import com.nonight.deadgame.model.enums.NodeStatus;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/12/18.
 * 新游戏开场副本节点生成工厂
 * id = 1
 * 8 个节点
 * 节点1-7是剧本节点  一句话
 * 节点8 是结束节点 奖励300
 */

public class StartInstanceFactory {


    public static Instance create(){

        Instance instance = new Instance();
        instance.setId(1);    //每个副本id不同
        instance.setStatus(InstanceStatus.CREATE);    //副本创建状态
        instance.setNodeNumber(8);   //指定副本节点   开始副本固定为8

        instance.setNodes(createNodes(instance));
        return instance;
    }

    private static List<InstanceNode> createNodes(Instance instance) {




    }

    private static InstanceNode createNode(int id){
        InstanceNode instanceNode = new InstanceNode();
        instanceNode.setId(id);
        instanceNode.setStatus(NodeStatus.CREATE);
        switch (id){            //根据节点id生成节点内容
            case 1:
                instanceNode.setNodeType(InstanceNodeType.DRAMA);
                instanceNode.setDramaContent(drama1);
                break;
            case 2:
                instanceNode.setNodeType(InstanceNodeType.DRAMA);
                instanceNode.setDramaContent(drama2);

                break;
            case 3:
                instanceNode.setNodeType(InstanceNodeType.DRAMA);
                instanceNode.setDramaContent(drama3);

                break;
            case 4:
                instanceNode.setNodeType(InstanceNodeType.DRAMA);
                instanceNode.setDramaContent(drama4);

                break;
            case 5:
                instanceNode.setNodeType(InstanceNodeType.DRAMA);
                instanceNode.setDramaContent(drama5);

                break;
            case 6:
                instanceNode.setNodeType(InstanceNodeType.DRAMA);
                instanceNode.setDramaContent(drama6);

                break;
            case 7:
                instanceNode.setNodeType(InstanceNodeType.DRAMA);
                instanceNode.setDramaContent(drama7);

                break;
            case 8:
                instanceNode.setNodeType(InstanceNodeType.REWARD);
                instanceNode.setDramaContent(drama1);

                break;
        }




    }
    private static final String drama1 = "冰冷，抖动。。。";

    private static final String drama2 = "随着他们3人的醒来，在接受了一段不属于他们自己的记忆后，他们不得不面临一个非常不科学的事实，他们竟然进入了传说中的主神空间。";
    private static final String drama3 = "在主神空间中，他们会被主神派去一个又一个的冒险世界。";
    private static final String drama4 = "而在冒险世界中，他们需要完成主神指定的任务，克服一个又一个的难关和挑战。";
    private static final String drama5 = "每完成一次冒险世界，他们每人将最少会500点奖励点，奖励点可以在主神处兑换各种的能力、物品，从而提升自己。";
    private static final String drama6 = "当小队在主神处的评价达到所期望的评价时，小队将会被派往完成最终任务，完成最终挑战后，队员们则可以带着兑换的能力和物品返回现实世界。";
    private static final String drama7 = ">现在，他们3人每人身上有100点奖励点数。";

    private static final String drama8 = "在30分钟后，他们即将进入他们的第一个冒险世界。";

    /*
    <string name="start_game_1">冰冷，抖动。。。</string>
    <string name="start_game_2">随着他们3人的醒来，在接受了一段不属于他们自己的记忆后，他们不得不面临一个非常不科学的事实，他们竟然进入了传说中的主神空间。</string>
    <string name="start_game_3">在主神空间中，他们会被主神派去一个又一个的冒险世界。</string>
    <string name="start_game_4">而在冒险世界中，他们需要完成主神指定的任务，克服一个又一个的难关和挑战。</string>
    <string name="start_game_5">每完成一次冒险世界，他们每人将最少会500点奖励点，奖励点可以在主神处兑换各种的能力、物品，从而提升自己。</string>
    <string name="start_game_6">当小队在主神处的评价达到所期望的评价时，小队将会被派往完成最终任务，完成最终挑战后，队员们则可以带着兑换的能力和物品返回现实世界。</string>
    <string name="start_game_7">现在，他们3人每人身上有100点奖励点数。</string>
    <string name="start_game_8">在30分钟后，他们即将进入他们的第一个冒险世界。</string>
    */


}
