package com.nonight.deadgame.service;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;

import com.nonight.deadgame.utils.Logger;

import java.util.List;

/**
 * Created by Administrator on 2018/1/15.
 */

public class BGMServiceConnection implements ServiceConnection {

    private static final String TAG = "BGM CONNECTION";
    private boolean isBind = false;
    private BGMService service;
    List<String> musicList;
    public BGMServiceConnection (List<String> musicList){
        this.musicList = musicList;
    }

    @Override
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {



        isBind = true;
        BGMService.MyBinder myBinder = (BGMService.MyBinder) iBinder;
        service = myBinder.getService();
        if (!service.isSetMusicStatus()) {
            service.setBGMList(musicList);
            service.startMusic();
        }
        Logger.d(TAG, componentName.getClassName() + " - onServiceConnected");

    }

    @Override
    public void onServiceDisconnected(ComponentName componentName) {
        isBind = true;

        Logger.d(TAG, componentName.getClassName() + " - onServiceDisconnected");
    }

    @Override
    public void onBindingDied(ComponentName name) {

    }

    public boolean getIsBind(){
        return  isBind;
    }

    public BGMService getService(){
        return service;
    }
}
