package com.nonight.deadgame.model;

import com.nonight.deadgame.model.enums.Gender;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/12/18.
 */

public class NPC implements Serializable {

    private String name;
    private Integer L,M,T,J,RP;
    private List<Skill> skills;
    private List<Equipment> equipments;
    private Integer hp,mp;
    private Gender gender;


    public NPC(String name,Gender gender, Integer l, Integer m, Integer t, Integer j, Integer RP, List<Skill> skills) {
        this.name = name;
        this.gender = gender;
        L = l;
        M = m;
        T = t;
        J = j;
        this.RP = RP;
        this.skills = skills;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getL() {
        return L;
    }

    public void setL(Integer l) {
        L = l;
    }

    public Integer getM() {
        return M;
    }

    public void setM(Integer m) {
        M = m;
    }

    public Integer getT() {
        return T;
    }

    public void setT(Integer t) {
        T = t;
    }

    public Integer getJ() {
        return J;
    }

    public void setJ(Integer j) {
        J = j;
    }

    public Integer getRP() {
        return RP;
    }

    public void setRP(Integer RP) {
        this.RP = RP;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public List<Equipment> getEquipments() {
        return equipments;
    }

    public void setEquipments(List<Equipment> equipments) {
        this.equipments = equipments;
    }

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public Integer getMp() {
        return mp;
    }

    public void setMp(Integer mp) {
        this.mp = mp;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
