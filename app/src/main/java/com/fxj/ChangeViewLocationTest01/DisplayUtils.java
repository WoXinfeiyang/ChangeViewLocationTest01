package com.fxj.ChangeViewLocationTest01;

import android.content.Context;

public class DisplayUtils {

    public static int getScreenWidth(Context context){
       return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeight(Context context){
        return context.getResources().getDisplayMetrics().heightPixels;
    }
}
