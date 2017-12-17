package com.nonight.deadgame.utils;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by nonight on 2017/12/17.
 */
public class GsonHelper {

    public static Gson getGson(){
        final GsonBuilder builder = new GsonBuilder();
        builder.setVersion(1.0);
        return builder.create();
    }
}
