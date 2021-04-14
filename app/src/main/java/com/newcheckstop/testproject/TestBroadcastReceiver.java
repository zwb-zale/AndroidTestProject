package com.newcheckstop.testproject;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

public class TestBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });
        if(intent != null){
            if(TextUtils.equals(intent.getAction(),SendBrocastActivity.COM_NEWCHECKSTOP_TESTPROJECT_BROADCAST)){
                Log.i("TestBroadcastReceiver","onReceive");
                String toastString = intent.getStringExtra("toast");
                Toast.makeText(context,toastString,Toast.LENGTH_LONG).show();
            }
        }
    }

}
