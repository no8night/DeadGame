package com.nonight.deadgame.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.nonight.deadgame.thread.BGMThread;
import com.nonight.deadgame.utils.BGMManager;
import com.nonight.deadgame.utils.Logger;
import com.nonight.deadgame.utils.ThreadManager;

import java.util.List;

/**
 * Created by Administrator on 2018/1/15.
 */

public class BGMService extends Service {

    private static final String TAG = "BGM SERVICE";

    private BGMThread thread;

    private BGMManager bgmManager;

    private boolean isSetMusicStatus = false;

    private boolean isAutoPlay = true;
    //client 可以通过Binder获取Service实例
    public class MyBinder extends Binder {
        public BGMService getService() {
            return BGMService.this;
        }
    }

    //通过binder实现调用者client与Service之间的通信
    private MyBinder binder = new MyBinder();


    @Override
    public void onCreate() {
        Logger.d(TAG, "create");
        bgmManager = BGMManager.getInstance(this);
        thread = new BGMThread(bgmManager);
        ThreadManager.THREAD_POOL_EXECUTOR.execute(thread);
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        Logger.d(TAG, "destory");
        thread.stopThread();
        super.onDestroy();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Logger.d(TAG, "unbind");
        intent = new Intent();
        return super.onUnbind(intent);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Logger.d(TAG, "bind");
        return binder;
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        System.out.println("执行了onStartCommand()");
        return super.onStartCommand(intent, flags, startId);


    }









    public void setBGMList(List<String> bgmList) {
        thread.setMusicList(bgmList);

    }

    public void startMusic() {

        thread.setIsBGMContinue(true);
        thread.play(0);
    }

    public void stopMusic() {
        thread.setIsBGMContinue(false);
        bgmManager.stopBackgroundMusic();
    }
    public void stopMusic(List<String> musicList) {

        if (musicList == thread.getMusicList()) {

            thread.setIsBGMContinue(false);
            bgmManager.stopBackgroundMusic();
        }
    }
    public void changeStatus() {
        isSetMusicStatus = true;
        if (bgmManager.isBackgroundMusicPlaying()) {
            thread.setIsBGMContinue(false);
            bgmManager.stopBackgroundMusic();
        } else {
            thread.setIsBGMContinue(true);
            thread.play(0);
        }
        isAutoPlay = thread.getIsBGMContinue();

    }

    public boolean isSetMusicStatus(){
        return  isSetMusicStatus;
    }
    public boolean isAutoPlay(){
        return  isAutoPlay;
    }
}
