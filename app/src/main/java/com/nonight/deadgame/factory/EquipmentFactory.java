package com.nonight.deadgame.factory;

import com.nonight.deadgame.model.Equipment;
import com.nonight.deadgame.model.Skill;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nonight on 2017/12/18.
 */

public class EquipmentFactory {





    public static List<Equipment> getAllSkills(){
        List<Equipment> result = new ArrayList<>();

        Equipment equipment = new Equipment();
        equipment.setCode(1);
        equipment.setName("P92");
        equipment.setIntroduction("一把性能不错的手枪");








        return result;
    }
}
