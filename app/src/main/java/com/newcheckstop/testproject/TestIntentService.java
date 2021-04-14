package com.newcheckstop.testproject;

import android.app.IntentService;
import android.content.Intent;

import androidx.annotation.Nullable;

public class TestIntentService extends IntentService {
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public TestIntentService(String name) {
        super(name);
    }

    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        //排队--》像MessageQueue

        if(intent != null){

        }
    }
}
