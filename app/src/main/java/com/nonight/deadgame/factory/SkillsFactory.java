package com.nonight.deadgame.factory;

import android.content.Context;

import com.nonight.deadgame.model.BusinessException;
import com.nonight.deadgame.model.Skill;
import com.nonight.deadgame.utils.Config;
import com.nonight.deadgame.utils.GsonHelper;
import com.nonight.deadgame.utils.SharedPrefsUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nonight on 2017/12/18.
 */

public class SkillsFactory {

    public static final String PING_A = "1";


    public static List<Skill> getAllSkills(){
        List<Skill> result = new ArrayList<>();

        Skill skill = new Skill();
        skill.setCode("1");
        skill.setIntroduction("List<Skill>");
        skill.setName("平a");
        result.add(skill);


        //添加技能








        return result;
    }

    public static Skill getSkillByCode(Context context,String code) {
        String json = SharedPrefsUtil.getValue(context, Config.skillsLibrary,code,null);

        if (json == null){
            throw new BusinessException("skill code not exist");
        }

        Skill skill = GsonHelper.getGson().fromJson(json,Skill.class);
        return  skill;

    }
}
