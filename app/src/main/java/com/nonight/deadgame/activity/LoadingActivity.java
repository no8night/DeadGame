package com.nonight.deadgame.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;

import com.ldoublem.loadingviewlib.LVLineWithText;
import com.nonight.deadgame.R;
import com.nonight.deadgame.utils.Config;

/**
 * Created by Administrator on 2018/1/2..
 *
 *
 * 先不用
 */

public class LoadingActivity extends Activity {

    private LVLineWithText lv_linetext;
    public static final int TASK_FINISHED = 0x111;


    Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {

            switch (msg.what) {
                case TASK_FINISHED:
                    finishLoad();


                    break;

                default:
                    finishLoad();
                    break;


            }
            return false;
        }
    });

    private void finishLoad() {


        if (targetActivity!=null){
            Intent intent = new Intent(LoadingActivity.this,targetActivity);
            startActivity(intent);
        }else {
            Intent intent = new Intent(LoadingActivity.this,MainActivity.class);
            startActivity(intent);
        }
        finish();
    }

    private Class<?> targetActivity;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.loading_activity);

        targetActivity = (Class<?>) getIntent().getSerializableExtra(Config.targetIntent);
        initview();
    }

    private void initview() {

        lv_linetext = findViewById(R.id.lv_linetext);

        new Thread(new Runnable() {
            @Override
            public void run() {

                int progress = 0;

                while (progress <= 100) {

                    progress++;
                    if (progress < 20) {
                        final int finalProgress = progress;
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                lv_linetext.setValue(finalProgress);

                            }
                        });
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else if (progress < 50) {
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else if (progress == 50) {
                        final int finalProgress1 = progress;
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                lv_linetext.setValue(finalProgress1);
                            }
                        });
                    } else if (progress < 100) {
                        final int finalProgress = progress;
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                lv_linetext.setValue(finalProgress);

                            }
                        });
                        try {
                            Thread.sleep(80);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else if (progress == 100) {

                    }


                }


            }
        }).start();


    }
}
