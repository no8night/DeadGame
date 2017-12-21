package com.nonight.deadgame.model;

import com.nonight.deadgame.model.enums.Gender;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nonight on 2017/12/17.
 */
public class TeamMenber implements Serializable {


    private String name;
    private Integer L,M,T,J,RP;
    private SkillList skills;
    private List<Equipment> equipments;
    private Integer hp,mp;
    private Gender gender;
    private Double P;     //评价  属性、技能更改后会更新

    public TeamMenber(String name,Gender gender, Integer l, Integer m, Integer t, Integer j, Integer RP) {
        this.name = name;
        this.gender = gender;
        L = l;
        M = m;
        T = t;
        J = j;
        this.RP = RP;
    }

    public void updateP(){

        //计算属性评分
        if (L>=M && L>=T && L>=J){
            P = L + (M+T+J)*0.7;
        }else  if (M>=L && M>=T && M>=J){
            P = L + (M+T+J)*0.7;
        }else if (T>=M && T>=L && T>=J){
            P = L + (M+T+J)*0.7;
        }else if (J>=M && J>=T && J>=L){
            P = L + (M+T+J)*0.7;
        }else {
            P = (double) (L + M + T + J);
        }
        //计算技能评分
        for (Skill skill: skills) {
            if (skill!=null) {
                P = P + skill.getP();
            }
        }

    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
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



    public Integer getM() {
        return M;
    }


    public Integer getT() {
        return T;
    }


    public Integer getJ() {
        return J;
    }


    public void setT(Integer t) {
        T = t;
        updateP();
    }
    public void setL(Integer l) {
        L = l;
        updateP();
    }
    public void setM(Integer m) {
        M = m;
        updateP();
    }
    public void setJ(Integer j) {
        J = j;
        updateP();
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

//    public void setSkills(List<Skill> skills) {
//        this.skills = skills;
//    }

    public void addSkills(Skill skill){
        if (skills==null){
            skills = new SkillList();
        }
        skills.add(skill);
        updateP();
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

    public Double getP() {
        return P;
    }

    public void setP(Double p) {
        P = p;
    }
}
