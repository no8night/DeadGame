package com.nonight.deadgame.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import com.nonight.deadgame.R;
import com.nonight.deadgame.model.Instance;
import com.nonight.deadgame.model.InstanceNode;
import com.nonight.deadgame.model.SaveData;
import com.nonight.deadgame.model.enums.InstanceNodeType;
import com.nonight.deadgame.model.enums.InstanceStatus;
import com.nonight.deadgame.model.enums.TeamStatus;
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

    private Instance playingInstance;     //进行中的副本
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
        play();

    }

    private void play() {

        if (saveData.getTeamStatus()== TeamStatus.PLAYING){
            //找到进行的副本
            for (Instance instance :saveData.getInstances()){
                if (instance.getStatus()== InstanceStatus.PLAYING){
                    playingInstance = instance;
                }
            }
        }

        if (saveData.getTeamStatus()==TeamStatus.READY){
            //找到将要进行的副本
            for (Instance instance :saveData.getInstances()){
                if (instance.getStatus()== InstanceStatus.CREATE){
                    playingInstance = instance;
                }

            }
            if (playingInstance==null){
                //没有要开始的副本时  返回控制台

                saveData.save(this);
                returnToControllerActivity(saveData);

                finish();


            }
            //开始副本
            playingInstance.setStatus(InstanceStatus.PLAYING);
            saveData.setTeamStatus(TeamStatus.PLAYING);
        }



        playInstance();

    }

    private void returnToControllerActivity(SaveData saveData) {

        Intent intent = new Intent(this,ControllerActivity.class);
        intent.putExtra(Config.saveDataString,saveData);
        startActivity(intent);


    }

    private void playInstance() {

        if (playingInstance.getPlayNodesSeq()==null ||playingInstance.getPlayNodesSeq()<1 ){  //未开始
            playingInstance.setPlayNodesSeq(1);
        }else if (playingInstance.getPlayNodesSeq()<playingInstance.getNodeNumber()){   //进行

            playNode();
            playingInstance.setPlayNodesSeq(playingInstance.getPlayNodesSeq()+1);
        }else  if (playingInstance.getPlayNodesSeq()>=playingInstance.getNodeNumber()){  //结束

            playingInstance.setStatus(InstanceStatus.FINISH);
            saveData.setTeamStatus(TeamStatus.READY);

        }


    }

    private void playNode() {

        InstanceNode playNode = playingInstance.getNodes().get(playingInstance.getPlayNodesSeq());  //拿出要play的节点

        if (playNode.getNodeType()== InstanceNodeType.DRAMA){

        }else if (playNode.getNodeType()== InstanceNodeType.BATTLE){

        }else if (playNode.getNodeType()== InstanceNodeType.REWARD){

        }else {

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
