package com.nonight.deadgame.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.nonight.deadgame.R;
import com.nonight.deadgame.model.SaveData;
import com.nonight.deadgame.utils.BGMManager;
import com.nonight.deadgame.utils.Config;

/**
 * Created by nonight on 2017/12/17.
 */
public class PlayActivity extends Activity{

    BGMManager bgmManager;
    boolean isBGMContinue = true;
    SaveData saveData;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_activity);
        if (getIntent()!=null){
            saveData = (SaveData) getIntent().getSerializableExtra(Config.saveDataString);
        }
        initview();
        
    }

    private void initview() {

        listView = findViewById(R.id.play_lv);


        //判断有无副本是准备准备状态的
        saveData.get

    }



    @Override
    protected void onResume() {
        super.onResume();
        if (bgmManager == null)
            bgmManager = BGMManager.getInstance(this);
        isBGMContinue = true;
        if (bgmThread != null)
            bgmThread.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        isBGMContinue = false;
        bgmManager.stopBackgroundMusic();
    }


    Thread bgmThread = new Thread(new Runnable() {
        @Override
        public void run() {

            while (isBGMContinue) {
                int music_seq = 0;
                if (!bgmManager.isBackgroundMusicPlaying()) {
                    switch (music_seq) {
                        case 1:
                            music_seq = 2;
                            bgmManager.playBackgroundMusic("bgm/p_bgm-2.mp3", false);
                            break;
                        case 2:
                            music_seq = 1;
                            bgmManager.playBackgroundMusic("bgm/p_bgm-1.mp3", false);
                            break;
                        default:
                            music_seq = 1;
                            bgmManager.playBackgroundMusic("bgm/p_bgm-2.mp3", false);
                            break;
                    }

                }
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    });
}
