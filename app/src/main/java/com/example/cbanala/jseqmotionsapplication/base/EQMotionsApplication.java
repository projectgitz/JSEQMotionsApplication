package com.example.cbanala.jseqmotionsapplication.base;

import android.app.Application;

import com.example.cbanala.jseqmotionsapplication.bridge.JSBridge;

import java.io.IOException;

/**
 * Created by chethanbanala on 2/2/17.
 */

public class EQMotionsApplication extends Application {

    private static EQMotionsApplication instance;
    private JSBridge jsBridge;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        jsBridge = new JSBridge(this);
        try {
            jsBridge.startEngine();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static final EQMotionsApplication getInstance() {
        return instance;
    }

    public JSBridge getJsBridge() {
        return jsBridge;
    }
}
