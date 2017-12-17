package com.nonight.deadgame.utils;

import com.nonight.deadgame.model.Skill;

/**
 * Created by nonight on 2017/12/17.
 */
public class Config {


    public static final String saveDataString = "SaveData";

    public static final String saveDataKeyString = "data";

    public static final Skill pingA(){
        Skill pingA = new Skill();
        pingA.setCode(1991);
        pingA.setName("平a");
        pingA.setIntroduction("普通攻击");
        return pingA;
    }
}
