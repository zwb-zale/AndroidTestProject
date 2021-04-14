package com.newcheckstop.testproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MusicButtonActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = MusicButtonActivity.class.getSimpleName();
    private Button mMusic_start;
    private Button mMusic_stop;
    private MusicService mMusicService;
    private ServiceConnection mServiceConnection = new ServiceConnection(){

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MusicService.LocalBinder localBinder = (MusicService.LocalBinder) service;
            mMusicService = localBinder.getService();
            mMusicService.startService();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_button);

        mMusic_start = (Button) findViewById(R.id.music_start);
        mMusic_stop = (Button) findViewById(R.id.music_stop);

        mMusic_start.setOnClickListener(this);
        mMusic_stop.setOnClickListener(this);

        if(mMusicService != null){
            int progress = mMusicService.getMusicPlayProgress();
            Log.i(TAG,String.valueOf(progress));
        }
    }

    @Override
    public void onClick(View v) {
        int button_id = v.getId();
        Intent intent = new Intent(MusicButtonActivity.this,MusicService.class);
        if(button_id == R.id.music_start){
            startService(intent);
            bindService(intent,mServiceConnection,BIND_AUTO_CREATE);
        } else if (button_id == R.id.music_stop){
            unbindService(mServiceConnection);
            stopService(intent);
        }
    }
}