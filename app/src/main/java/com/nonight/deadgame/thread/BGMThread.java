package com.nonight.deadgame.thread;

import android.util.Log;

import com.nonight.deadgame.utils.BGMManager;
import com.nonight.deadgame.utils.Logger;

import java.util.List;

/**
 * Created by Administrator on 2018/1/12.
 */

public class BGMThread extends Thread {

    static BGMThread bgmThread;
    private Boolean isStopThread = false;
    private Boolean isBGMContinue = false;
    private BGMManager bgmManager;
    private List<String> musicList;
    private int index = 0;

    public BGMThread(BGMManager bgmManager){
        this.bgmManager = bgmManager;

    }





    @Override
    public void run() {
        super.run();
        while (!isStopThread) {


            while (isBGMContinue) {
                Logger.d("bgm thread" , "continue");
                if (!bgmManager.isBackgroundMusicPlaying()) {

                    if (index >= musicList.size()){
                        index = 0;
                    }
                    bgmManager.playBackgroundMusic(musicList.get(index), false);
                    index++;
                }
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }





    public void stopThread(){
        isStopThread = true;
    }
    public void setIsBGMContinue(boolean isBGMContinue){

        this.isBGMContinue = isBGMContinue;

    }
    public boolean getIsBGMContinue(){
        return  isBGMContinue;
    }
    public void play(int index){
        if (index<musicList.size()) {
            this.index = index;
            bgmManager.playBackgroundMusic(musicList.get(index),false);

        }
    }
    public void  setBgmManager(BGMManager bgmManager){

        this.bgmManager = bgmManager;
    }
    public void setMusicList(List<String> musicList){

        this.musicList = musicList;
    }

    public List<String> getMusicList(){

        return  musicList;
    }
}
