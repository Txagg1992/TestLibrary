package com.curiourapps.biolibrary;

import android.app.Application;
import android.content.Context;

public class AppliContext extends Application {


    private static Context context;

    public void onCreate(){
        super.onCreate();
        AppliContext.context = getApplicationContext();
    }

    public static Context getContext(){
        return AppliContext.context;
    }

}
