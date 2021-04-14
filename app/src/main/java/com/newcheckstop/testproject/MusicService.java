package com.newcheckstop.testproject;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class MusicService extends Service {

    private static final String TAG = MusicService.class.getSimpleName();

    private MediaPlayer mMediaPlayer;

    private IBinder mIBinder = new LocalBinder();

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG,"onCreate");
        mMediaPlayer = MediaPlayer.create(this,R.raw.shanbian);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG,"onStartCommand");
        mMediaPlayer.start();
        return START_STICKY_COMPATIBILITY;

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"onDestroy");
        mMediaPlayer.stop();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mIBinder;
    }

    public class LocalBinder extends Binder{
        MusicService getService () {
            return MusicService.this;
        }
    }
    public void startService (){
        mMediaPlayer.start();
    }
    public int getMusicPlayProgress(){
        return 18;
    }
}
