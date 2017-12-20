package com.nonight.deadgame.model;

import android.content.Context;

import com.nonight.deadgame.factory.InstanceFactory;
import com.nonight.deadgame.factory.SkillsFactory;
import com.nonight.deadgame.model.enums.Gender;
import com.nonight.deadgame.model.enums.TeamStatus;
import com.nonight.deadgame.utils.Config;
import com.nonight.deadgame.utils.GsonHelper;
import com.nonight.deadgame.utils.RandomUtils;
import com.nonight.deadgame.utils.SharedPrefsUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by nonight on 2017/12/17.
 */
public class SaveData implements Serializable{

    private Integer theNumberOfCompletedTasks;   //完成任务次数
    private Integer theNumberOfTeamMenber;   //队伍人数

    private Integer rewardPoint;                 //奖励点
    private Double appraise;                     //评价
    private TeamStatus teamStatus;               //状态


    private List<Equipment> equipments;
    private List<Item> items;
    private List<TeamMenber> teamMenbers;        //队伍成员
    private List<Instance> instances;            //曾经经历过的副本

    private Date createDate;
    private Date updateDate;


    //初始化存档
    public SaveData init(Context context) {

        initLibrary(context);


        theNumberOfCompletedTasks = 0;
        theNumberOfTeamMenber = 3;
        rewardPoint = 0;

        teamStatus = TeamStatus.READY;




        TeamMenber mainTeamMenber = new TeamMenber("郑吒", Gender.Man, 9, 8, 10, 5, 10);
        TeamMenber manTeamMenber = new TeamMenber(RandomUtils.randomManName(), Gender.Man, 5 + RandomUtils.randomNumberInX(4), 5 + RandomUtils.randomNumberInX(4),
                5 + RandomUtils.randomNumberInX(4), 5 + RandomUtils.randomNumberInX(4), 1 + RandomUtils.randomNumberInX(5));
        TeamMenber womanTeamMenber = new TeamMenber(RandomUtils.randomWomanName(), Gender.Woman, 5 + RandomUtils.randomNumberInX(4), 5 + RandomUtils.randomNumberInX(4),
                5 + RandomUtils.randomNumberInX(4), 5 + RandomUtils.randomNumberInX(4), 1 + RandomUtils.randomNumberInX(5));

        mainTeamMenber.addSkills(SkillsFactory.getSkillByCode(context,SkillsFactory.PING_A));
        manTeamMenber.addSkills(SkillsFactory.getSkillByCode(context,SkillsFactory.PING_A));
        womanTeamMenber.addSkills(SkillsFactory.getSkillByCode(context,SkillsFactory.PING_A));

        teamMenbers = new ArrayList<>();
        teamMenbers.add(mainTeamMenber);
        teamMenbers.add(womanTeamMenber);
        teamMenbers.add(manTeamMenber);


        equipments = new ArrayList<>();
        items = new ArrayList<>();
        instances = new ArrayList<>();

        Instance startInstance = InstanceFactory.createStartInstance();
        instances.add(startInstance);




        return this;
    }

    public List<Instance> getInstances() {
        return instances;
    }

    public void setInstances(List<Instance> instances) {
        this.instances = instances;
    }

    private void initLibrary(Context context) {

        List<Skill> skills = SkillsFactory.getAllSkills();
        for (Skill skill:skills) {
            SharedPrefsUtil.putValue(context,Config.skillsLibrary,skill.getCode().toString(),GsonHelper.getGson().toJson(skill));
        }
        //TODo : 装备的初始化先跳过

    }


    public void save(Context context){
        String saveDataString = GsonHelper.getGson().toJson(this);
        SharedPrefsUtil.putValue(context,Config.saveDataString,Config.saveDataKeyString,saveDataString);
    }

    public static  SaveData loadSaveData(Context context){
        String saveDataString = SharedPrefsUtil.getValue(context,Config.saveDataString,Config.saveDataKeyString,null);
        SaveData saveData = null;
        if (saveDataString!=null){
            saveData = GsonHelper.getGson().fromJson(saveDataString,SaveData.class);

        }

        return saveData;

    }

    public Integer getTheNumberOfCompletedTasks() {
        return theNumberOfCompletedTasks;
    }

    public void setTheNumberOfCompletedTasks(Integer theNumberOfCompletedTasks) {
        this.theNumberOfCompletedTasks = theNumberOfCompletedTasks;
    }

    public Integer getTheNumberOfTeamMenber() {
        return theNumberOfTeamMenber;
    }

    public void setTheNumberOfTeamMenber(Integer theNumberOfTeamMenber) {
        this.theNumberOfTeamMenber = theNumberOfTeamMenber;
    }

    public List<TeamMenber> getTeamMenbers() {
        return teamMenbers;
    }

    public void setTeamMenbers(List<TeamMenber> teamMenbers) {
        this.teamMenbers = teamMenbers;
    }

    public Integer getRewardPoint() {
        return rewardPoint;
    }

    public void setRewardPoint(Integer rewardPoint) {
        this.rewardPoint = rewardPoint;
    }

    public Double getAppraise() {
        return appraise;
    }

    public void setAppraise(Double appraise) {
        this.appraise = appraise;
    }

    public List<Equipment> getEquipments() {
        return equipments;
    }

    public void setEquipments(List<Equipment> equipments) {
        this.equipments = equipments;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public TeamStatus getTeamStatus() {
        return teamStatus;
    }

    public void setTeamStatus(TeamStatus teamStatus) {
        this.teamStatus = teamStatus;
    }
}
