package com.nonight.deadgame.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.nonight.deadgame.R;
import com.nonight.deadgame.model.SaveData;
import com.nonight.deadgame.model.enums.TeamStatus;
import com.nonight.deadgame.utils.BGMManager;
import com.nonight.deadgame.utils.Config;

/**
 * Created by nonight on 2017/12/17.
 */
public class ControllerActivity extends Activity {

    BGMManager bgmManager;
    boolean isBGMContinue = true;
    SaveData saveData;
    TextView status_tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.control_activity);
        if (getIntent()!=null){
            saveData = (SaveData) getIntent().getSerializableExtra(Config.saveDataString);
        }
        initview();

    }

    private void initview() {

        status_tv = findViewById(R.id.control_status_tv);
        setStatusTv();

    }

    private void setStatusTv() {
        if (saveData.getTeamStatus() == TeamStatus.READY){

            StringBuffer sb = new StringBuffer();
            sb.append("团队人数 ： ");
            sb.append(saveData.getTeamMenbers().size());
            sb.append("    奖励点 ： ");
            sb.append(saveData.getRewardPoint());

            status_tv.setText(sb.toString());


        }

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
                            bgmManager.playBackgroundMusic("bgm/c_bgm-2.mp3", false);
                            break;
                        case 2:
                            music_seq = 1;
                            bgmManager.playBackgroundMusic("bgm/c_bgm-1.mp3", false);
                            break;
                        default:
                            music_seq = 1;
                            bgmManager.playBackgroundMusic("bgm/c_bgm-2.mp3", false);
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
