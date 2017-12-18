package com.nonight.deadgame.factory;

import com.nonight.deadgame.model.Instance;
import com.nonight.deadgame.model.enums.InstanceStatus;

/**
 * Created by Administrator on 2017/12/18.
 *
 * 生成副本的工厂类
 */

public class InstanceFactory {


    public static void createStartInstance(){

        Instance instance = new Instance();

        instance.setId(1);
        instance.setNodeNumber(8);
        instance.setStatus(InstanceStatus.CREATE);

    }


}
