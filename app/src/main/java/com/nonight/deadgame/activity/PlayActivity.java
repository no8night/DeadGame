package com.nonight.deadgame.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.nonight.deadgame.R;
import com.nonight.deadgame.adapter.NodeAdapter;
import com.nonight.deadgame.config.MusicConfig;
import com.nonight.deadgame.model.Instance;
import com.nonight.deadgame.model.InstanceNode;
import com.nonight.deadgame.model.Item;
import com.nonight.deadgame.model.RewardContent;
import com.nonight.deadgame.model.SaveData;
import com.nonight.deadgame.model.enums.InstanceNodeType;
import com.nonight.deadgame.model.enums.InstanceStatus;
import com.nonight.deadgame.model.enums.NodeStatus;
import com.nonight.deadgame.model.enums.TeamStatus;
import com.nonight.deadgame.service.BGMService;
import com.nonight.deadgame.service.BGMServiceConnection;
import com.nonight.deadgame.utils.BGMManager;
import com.nonight.deadgame.utils.Config;
import com.nonight.deadgame.utils.ThreadManager;

import java.util.ArrayList;
import java.util.List;

import cn.refactor.lib.colordialog.PromptDialog;

/**
 * Created by nonight on 2017/12/17.
 */
public class PlayActivity extends Activity {

    SaveData saveData;
    ListView listView;
    TextView finish_tv;
    private Integer playTime = 0;
    private Instance playingInstance;     //进行中的副本

    private NodeAdapter nodeAdapter;
    private List<InstanceNode> playingNodeList = new ArrayList<>();
    private static final int PLAYING = 0x122;

    Handler mhandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {

            switch (msg.arg1) {

                case PLAYING:
                    InstanceNode node = (InstanceNode) msg.obj;
                    node.setStatus(NodeStatus.FINISHED);
                    playingInstance.setPlayNodesSeq(node.getInstanceSeq());
                    play();
                    break;

                default:

                    break;

            }


            return false;
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_activity);
        if (getIntent() != null) {
            saveData = (SaveData) getIntent().getSerializableExtra(Config.saveDataString);
        }
        initview();
        conn = new BGMServiceConnection(MusicConfig.getPlayMusicList());
    }

    private void initview() {
        finish_tv = findViewById(R.id.play_finish_tv);
        listView = findViewById(R.id.play_lv);

        finish_tv.setVisibility(View.GONE);
        finish_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData.save(PlayActivity.this);
                returnToControllerActivity(saveData);
            }
        });


        nodeAdapter = new NodeAdapter(this, playingNodeList);
        listView.setAdapter(nodeAdapter);
        //判断有无副本是准备准备状态的
        play();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (playingNodeList.get(i).getNodeType()==InstanceNodeType.REWARD){
                    showRewardDialog(playingNodeList.get(i).getRewardContent());
                }
            }
        });
    }

    private void play() {
        System.out.println("playtime = " + playTime);
        playTime++;
        if (finish_tv.getVisibility()!=View.VISIBLE) {
            if (playTime > 30) {
                //不可能进行这么多次  出现了bug
                finish_tv.setText("任务世界发生错误，请返回主神空间重新开始任务");
                finish_tv.setVisibility(View.VISIBLE);
                return;
            }
        }else {
            return;  //等待玩家结束
        }
        if (saveData.getTeamStatus() == TeamStatus.PLAYING) {
            //找到进行的副本
            for (Instance instance : saveData.getInstances()) {
                if (instance.getStatus() == InstanceStatus.PLAYING) {
                    playingInstance = instance;
                }
            }
        }

        if (saveData.getTeamStatus() == TeamStatus.READY) {
            //找到将要进行的副本
            for (Instance instance : saveData.getInstances()) {
                if (instance.getStatus() == InstanceStatus.CREATE) {
                    playingInstance = instance;
                }

            }
            if (playingInstance == null) {
                //没有要开始的副本时  返回控制台

                finish_tv.setVisibility(View.VISIBLE);
                Animation an = AnimationUtils.loadAnimation(PlayActivity.this,R.anim.in_downtoup);
                finish_tv.setAnimation(an);

            }else {
                //开始副本
                playingInstance.setStatus(InstanceStatus.PLAYING);
                saveData.setTeamStatus(TeamStatus.PLAYING);
            }
        }


        playInstance();

    }


    private void returnToControllerActivity(SaveData saveData) {

        Intent intent = new Intent(this, ControllerActivity.class);
        intent.putExtra(Config.saveDataString, saveData);
        startActivity(intent);


    }

    private void playInstance() {
        if (playingInstance==null){
            play();
            return;

        }


        System.out.println("-------------- playy instance");
        if (playingInstance.getPlayNodesSeq() == null || playingInstance.getPlayNodesSeq() < 0) {  //未开始
            playingInstance.setPlayNodesSeq(0);
            playNode();
        } else if (playingInstance.getPlayNodesSeq() < playingInstance.getNodeNumber()) {   //进行
            playNode();
        } else if (playingInstance.getPlayNodesSeq() >= playingInstance.getNodeNumber()) {  //结束
            playingInstance.setStatus(InstanceStatus.FINISH);
            saveData.setTeamStatus(TeamStatus.READY);
            playingInstance = null;
            play();
        }


    }

    private void waitAndSendMsg(final InstanceNode instanceNode) {
        ThreadManager.THREAD_POOL_EXECUTOR.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Message msg = new Message();
                msg.arg1 = PLAYING;
                msg.obj = instanceNode;
                mhandler.sendMessage(msg);
            }
        });
    }

    private void showRewardDialog(RewardContent rewardContent){

        StringBuilder showContent = new StringBuilder();
        if (rewardContent.getRewardPoint()!=null ){
            showContent.append("恭喜你们获得了").append(rewardContent.getRewardPoint()).append("奖励点");
        }
        if (rewardContent.getItems()!=null && !rewardContent.getItems().isEmpty()){
            if (rewardContent.getRewardPoint()!=null) {
                showContent.append("\n");
            }
            showContent.append("获得物品：");
            for (int i = 0 ;i<rewardContent.getItems().size();i++){
                if (i!=0){
                    showContent.append("、");
                }

                showContent.append(rewardContent.getItems().get(i).getName());

            }

        }
        new PromptDialog(this)
                .setDialogType(PromptDialog.DIALOG_TYPE_SUCCESS)
                .setAnimationEnable(true)
                .setTitleText("提示")
                .setContentText(showContent)
                .setPositiveListener("确认", new PromptDialog.OnPositiveListener() {
                    @Override
                    public void onClick(PromptDialog dialog) {
                        dialog.dismiss();
                    }
                }).show();
    }

    private void playNode() {
        System.out.println("---------------------- play node");
        System.out.println("playingInstance.getPlayNodesSeq() = " + playingInstance.getPlayNodesSeq());
        InstanceNode playNode = playingInstance.getNodes().get(playingInstance.getPlayNodesSeq());  //拿出要play的节点
        if (playNode.getStatus() == NodeStatus.CREATE || playNode.getStatus() == NodeStatus.ING) {

            if (playNode.getNodeType() == InstanceNodeType.DRAMA) {
                playNode.setStatus(NodeStatus.ING);
                playingNodeList.add(playNode);
                nodeAdapter.notifyDataSetChanged();
                waitAndSendMsg(playNode);
            } else if (playNode.getNodeType() == InstanceNodeType.BATTLE) {

            } else if (playNode.getNodeType() == InstanceNodeType.REWARD) {
                if (playNode.getRewardContent().getItems()!=null && !playNode.getRewardContent().getItems().isEmpty()){

                    saveData.addItems(playNode.getRewardContent().getItems());
                }

                saveData.setRewardPoint(saveData.getRewardPoint()+playNode.getRewardContent().getRewardPoint());



                showRewardDialog(playNode.getRewardContent());


                playNode.setStatus(NodeStatus.ING);
                playingNodeList.add(playNode);
                nodeAdapter.notifyDataSetChanged();
                waitAndSendMsg(playNode);

            } else {

            }

        } else {
            playingInstance.setPlayNodesSeq(playingInstance.getPlayNodesSeq() + 1);
        }
    }

    BGMService service;
    private BGMServiceConnection conn;
    @Override
    protected void onResume() {
        super.onResume();


        service = conn.getService();
        if (service == null) {
            Intent intent = new Intent(this, BGMService.class);
            bindService(intent, conn, BIND_AUTO_CREATE);
        } else if (service.isAutoPlay()) {
            service.setBGMList(MusicConfig.getPlayMusicList());
            service.startMusic();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        service = conn.getService();
        service.stopMusic(MusicConfig.getPlayMusicList());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(conn);
    }
}
