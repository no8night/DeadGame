package com.nonight.deadgame.utils;

import java.util.Random;

/**
 * Created by nonight on 2017/12/17.
 */
public class RandomUtils {

    private static String[] firstName = {"陈","李","赵","钱","孙","周","吴","郑","王","冯","卫","蒋","沈","韩","杨","朱","秦","许","何","吕","张","孔","曹"};
    private static String[] ManName = {"尤星","翼辰","安勋","离浩","司明","子皓","皖翼","熠辰","希影","辰希","离然","亦辰","黎川","黎辰","寒熙","伊耀","离痕","影安","冰夜","熠然","辰希"};
    private static String[] WomanName = {"映容","冰萱","沛旋","幻容","涵青","白琴","安曼","思海","晓霜","曼春","海波","冬松","采白","巧菱","书天","凌青","初珊","含安","向珍"};




    public static  Integer randomNumberIn100(){
        Random ran =new Random(System.currentTimeMillis());
        return ran.nextInt(100);
    }
    public static  Integer randomNumberInX(Integer X){
        Random ran =new Random(System.currentTimeMillis());
        return ran.nextInt(X);
    }
    public static String randomManName(){
        return firstName[randomNumberInX(firstName.length)] + ManName[randomNumberInX(ManName.length)];
    }

    public static  String randomWomanName(){
        return firstName[randomNumberInX(firstName.length)] + ManName[randomNumberInX(WomanName.length)];
    }
}
