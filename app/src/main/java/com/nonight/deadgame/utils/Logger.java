package com.nonight.deadgame.utils;

/**
 * Created by Administrator on 2018/1/12.
 */

public class Logger {

    private enum Type {

        debug,product;
    }

    private final static Type type = Type.debug;



    public static void d(String tag,String value){

        if (type == Type.debug) {
            System.out.println(tag + " : " + value);
        }
    }
    public static void e(String tag,String value){


            System.out.println(tag + " : " + value);
    }
}
