package com.nonight.deadgame.model;

import android.content.Context;

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
    private List<TeamMenber> teamMenbers;        //队伍成员
    private Integer rewardPoint;                 //奖励点
    private Double appraise;                     //评价
    private List<Equipment> equipments;
    private List<Item> items;

    private TeamStatus teamStatus;               //状态

    private List<Instance> instances;            //曾经经历过的副本

    private Date createDate;
    private Date updateDate;


    //初始化存档
    public SaveData init() {
        theNumberOfCompletedTasks = 0;
        theNumberOfTeamMenber = 3;
        rewardPoint = 300;
        List<Skill> skills = new ArrayList<>();
        skills.add(Config.pingA());
        TeamMenber mainTeamMenber = new TeamMenber("郑吒", Gender.Man, 9, 8, 10, 5, 10, skills);
        TeamMenber manTeamMenber = new TeamMenber(RandomUtils.randomManName(), Gender.Man, 5 + RandomUtils.randomNumberInX(4), 5 + RandomUtils.randomNumberInX(4),
                5 + RandomUtils.randomNumberInX(4), 5 + RandomUtils.randomNumberInX(4), 1 + RandomUtils.randomNumberInX(5),skills);
        TeamMenber womanTeamMenber = new TeamMenber(RandomUtils.randomWomanName(), Gender.Woman, 5 + RandomUtils.randomNumberInX(4), 5 + RandomUtils.randomNumberInX(4),
                5 + RandomUtils.randomNumberInX(4), 5 + RandomUtils.randomNumberInX(4), 1 + RandomUtils.randomNumberInX(5),skills);
        teamMenbers = new ArrayList<>();
        teamMenbers.add(mainTeamMenber);
        teamMenbers.add(womanTeamMenber);
        teamMenbers.add(manTeamMenber);

        return this;
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
}
