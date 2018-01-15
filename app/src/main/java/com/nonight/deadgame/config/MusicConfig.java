package com.nonight.deadgame.config;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/1/12.
 */

public class MusicConfig {
    static List<String> mainMusicList;
    static List<String> controllerMusicList;
    static List<String> playMusicList;


    private static String main_musc_1 = "bgm/bgm_main_activity.mp3";

    private static String control_musc_1 = "bgm/c_bgm_1.mp3";
    private static String control_musc_2 = "bgm/c_bgm_2.mp3";


    private static String play_musc_1 = "bgm/p_bgm_1.mp3";
    private static String play_musc_2 = "bgm/p_bgm_2.mp3";


    public static List<String> getMainMusicList(){

        if (mainMusicList == null) {
            mainMusicList = new ArrayList<>();
            mainMusicList.add(main_musc_1);
        }
        return  mainMusicList;


    }

    public static List<String> getContollerMusicList(){

        if (controllerMusicList==null) {
            controllerMusicList = new ArrayList<>();
            controllerMusicList.add(control_musc_1);
            controllerMusicList.add(control_musc_2);
        }
        return controllerMusicList;

    }
    public static List<String> getPlayMusicList(){

        if (playMusicList==null) {
            playMusicList = new ArrayList<>();
            playMusicList.add(play_musc_1);
            playMusicList.add(play_musc_2);
        }
        return playMusicList;

    }

}
