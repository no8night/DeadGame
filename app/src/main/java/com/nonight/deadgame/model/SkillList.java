package com.nonight.deadgame.model;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Administrator on 2017/12/20.
 */

public class SkillList extends ArrayList<Skill> {

    public SkillList() {
        super();
    }

    public SkillList(@NonNull Collection c) {
        super(c);
    }

    @Override
    public int size() {
        return super.size();
    }


    public boolean contains(Skill skill) {

        for(Skill tempskill:this){
            if (tempskill.getCode().equals(skill.getCode())){
                return true;
            }
        }
        return false;

    }

    @Override
    public Skill get(int index) {
        return super.get(index);
    }

    @Override
    public boolean add(Skill o) {

        if (!contains(o)) {
            return super.add(o);
        }else {
            return false;
        }
    }

    @Override
    public void add(int index, Skill element) {
        super.add(index, element);
    }

    @Override
    public boolean addAll(Collection c) {
        return super.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return super.addAll(index, c);
    }
}
