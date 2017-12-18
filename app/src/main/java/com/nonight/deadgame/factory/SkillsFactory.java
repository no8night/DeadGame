package com.nonight.deadgame.factory;

import com.nonight.deadgame.model.Skill;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nonight on 2017/12/18.
 */

public class SkillsFactory {

    public static final Integer PING_A = 1;
    private static final String PING_A_Introduce = "普通攻击";
    private static final String PING_A_Name = "普通攻击";




    public Skill getSkillByCode(Integer code){
        Skill skill = new Skill();
        skill.setCode(code);


    }





    public static List<Skill> getAllSkills(){
        List<Skill> result = new ArrayList<>();

        Skill skill = new Skill();
        skill.setCode(1);
        skill.setIntroduction("List<Skill>");
        skill.setName("平a");
        result.add(skill);










        return result;
    }
}
