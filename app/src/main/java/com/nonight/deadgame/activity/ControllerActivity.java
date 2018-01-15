package com.nonight.deadgame.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nonight.deadgame.R;
import com.nonight.deadgame.config.MusicConfig;
import com.nonight.deadgame.model.SaveData;
import com.nonight.deadgame.model.enums.TeamStatus;
import com.nonight.deadgame.service.BGMService;
import com.nonight.deadgame.service.BGMServiceConnection;
import com.nonight.deadgame.thread.BGMThread;
import com.nonight.deadgame.utils.BGMManager;
import com.nonight.deadgame.utils.Config;
import com.skydoves.powermenu.MenuAnimation;
import com.skydoves.powermenu.OnMenuItemClickListener;
import com.skydoves.powermenu.PowerMenu;
import com.skydoves.powermenu.PowerMenuItem;

/**
 * Created by nonight on 2017/12/17.
 */
public class ControllerActivity extends Activity {

    BGMService service;
    SaveData saveData;
    TextView status_tv;
    TextView start_tv, buy_tv, menber_tv, item_tv;
    ImageView menu_iv;
    PowerMenu powerMenu;
    LinearLayout main_ll;
    BGMServiceConnection conn ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.control_activity);
        if (getIntent() != null) {
            saveData = (SaveData) getIntent().getSerializableExtra(Config.saveDataString);
        }
        initview();
        conn = new BGMServiceConnection(MusicConfig.getContollerMusicList());
    }

    private void initview() {

        status_tv = findViewById(R.id.control_status_tv);
        setStatusTv();

        start_tv = findViewById(R.id.control_start_tv);
        start_tv.setOnClickListener(listener);
        buy_tv = findViewById(R.id.control_buy_tv);
        buy_tv.setOnClickListener(listener);
        menber_tv = findViewById(R.id.control_team_menber_tv);
        menber_tv.setOnClickListener(listener);
        item_tv = findViewById(R.id.control_team_item_tv);
        item_tv.setOnClickListener(listener);

        menu_iv = findViewById(R.id.control_menu_iv);
        menu_iv.setOnClickListener(listener);

        main_ll = findViewById(R.id.control_main_ll);

    }

    private void createMenu(){
        OnMenuItemClickListener onMenuItemClickListener = new OnMenuItemClickListener() {
            @Override
            public void onItemClick(int position, Object item) {
                switch (position){

                    case 0 :
                        powerMenu.dismiss();
                        break;
                    case 2:

                        if (service == null){
                            service = conn.getService();
                        }
                        service.changeStatus();
                        powerMenu.dismiss();
                        break;
                    case 3:
                        powerMenu.dismiss();
                        finish();
                        break;

                }

            }
        };

        powerMenu = new PowerMenu.Builder(this)
                .addItem(new PowerMenuItem("回到游戏", false))
                .addItem(new PowerMenuItem("其他", false))
                .addItem(new PowerMenuItem("音乐开关", false))
                .addItem(new PowerMenuItem("返回主菜单", false))
                .setAnimation(MenuAnimation.SHOWUP_TOP_LEFT) // Animation start point (TOP | LEFT)
                .setMenuRadius(10f)
                .setMenuShadow(10f)
                .setTextColor(getResources().getColor(R.color.black))
                .setSelectedTextColor(Color.WHITE)
                .setMenuColor(Color.WHITE)
                .setSelectedMenuColor(getResources().getColor(R.color.colorPrimary))
                .setOnMenuItemClickListener(onMenuItemClickListener)
                .build();


    }

    private void showMenu(){
        if (powerMenu == null ){
            createMenu();

        }
        if (powerMenu.isShowing()){
            return;
        }
        powerMenu.showAtCenter(main_ll);
    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.control_menu_iv:
                    showMenu();
                    break;
                case R.id.control_team_menber_tv:

                    break;

                case R.id.control_buy_tv:

                    break;


                case R.id.control_start_tv:

                    break;

                case R.id.control_team_item_tv:

                    break;

                default:

                    break;


            }
        }
    };


    private void setStatusTv() {
        if (saveData.getTeamStatus() == TeamStatus.READY) {

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


        service = conn.getService();
        if ( service == null){
            Intent intent = new Intent(this, BGMService.class);
            bindService(intent, conn, BIND_AUTO_CREATE);
        }else if (service.isAutoPlay()) {
            service.setBGMList(MusicConfig.getContollerMusicList());
            service.startMusic();
        }


    }

    @Override
    protected void onStop() {
        super.onStop();
        service = conn.getService();
        service.stopMusic(MusicConfig.getContollerMusicList());

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(conn);
    }

    //监听返回键
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            showMenu();
            return false;
        } else {
            return super.onKeyDown(keyCode, event);
        }

    }

}
