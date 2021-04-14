package com.newcheckstop.testproject;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SendBrocastActivity extends AppCompatActivity {

    public static final String COM_NEWCHECKSTOP_TESTPROJECT_BROADCAST = "com.newcheckstop.testproject.broadcast";
    private  TestBroadcastReceiver mTestBroadcastReceiver = new TestBroadcastReceiver();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bracast_send);

        Button sendBroadcastButton = (Button) findViewById(R.id.send_broadcast_button);
        sendBroadcastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(COM_NEWCHECKSTOP_TESTPROJECT_BROADCAST);
                intent.putExtra("toast","this is my toast of broadcast");
                sendBroadcast(intent);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        //动态注册广播
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.newcheckstop.testproject.broadcast");
        registerReceiver(mTestBroadcastReceiver,intentFilter);

    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(mTestBroadcastReceiver);
    }
}
