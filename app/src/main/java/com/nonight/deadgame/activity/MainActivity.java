package com.nonight.deadgame.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.nonight.deadgame.R;
import com.nonight.deadgame.utils.BGMManager;
import com.nonight.deadgame.model.SaveData;
import com.nonight.deadgame.utils.Config;

public class MainActivity extends AppCompatActivity {

    BGMManager bgmManager;

    TextView start_tv, continue_tv, exit_tv, option_tv;
    SaveData saveData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        start_tv = (TextView) findViewById(R.id.main_start_tv);
        continue_tv = (TextView) findViewById(R.id.main_contune_tv);
        exit_tv = (TextView) findViewById(R.id.main_option_tv);
        option_tv = (TextView) findViewById(R.id.main_exit_tv);
        start_tv.setOnClickListener(viewListener);
        option_tv.setOnClickListener(viewListener);
        exit_tv.setOnClickListener(viewListener);
        saveData = SaveData.loadSaveData(this);
        if (saveData!=null){
            continue_tv.setTextColor(getResources().getColor(R.color.white));
            continue_tv.setOnClickListener(viewListener);
        }else {
            continue_tv.setTextColor(getResources().getColor(R.color.lightgray));
        }

    }
    /** 開始新遊戲  */
    private void startGame() {
        //初始化存檔
        saveData = new SaveData();
        saveData.init();
        saveData.save(this);
        Intent intent = new Intent(this,PlayActivity.class);
        intent.putExtra(Config.saveDataString,saveData);
        startActivity(intent);
    }
    View.OnClickListener viewListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){

                case R.id.main_contune_tv:

                    break;

                case R.id.main_start_tv:
                    startGame();

                    break;

                case R.id.main_option_tv:

                    break;
                case R.id.main_exit_tv:
                    finish();
                    break;
                default:

                    break;
            }
        }
    };



    @Override
    protected void onResume() {
        super.onResume();
        if (bgmManager == null)
            bgmManager = BGMManager.getInstance(this);
        bgmManager.playBackgroundMusic("bgm/bgm_main_activity.mp3", true);
    }

    @Override
    protected void onStop() {
        super.onStop();
        bgmManager.stopBackgroundMusic();
    }
}
