package com.nonight.deadgame.factory;

import com.nonight.deadgame.model.Instance;
import com.nonight.deadgame.model.Skill;
import com.nonight.deadgame.model.enums.InstanceStatus;

import java.util.List;

/**
 * Created by Administrator on 2017/12/18.
 *
 * 生成副本的工厂类
 */

public class InstanceFactory {


    public static Instance createStartInstance(){

        return  StartInstanceFactory.create();
    }






}
