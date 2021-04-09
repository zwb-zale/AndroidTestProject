package com.newcheckstop.testproject;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {
    public static final String TITLE = "title";
    public static final String USER_INFO = "userInfo";
    public static final int REQUEST_CODE = 9999;
    public static final String TAG = HomeActivity.class.getSimpleName();
    private TextView mtextView;
    Handler mhandler = new Handler(Looper.myLooper());
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mtextView = (TextView) findViewById(R.id.homepage);
        final String title = mtextView.getText().toString();
        mhandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                UserInfo userInfo = new UserInfo("小明",12);
                Intent intent = new Intent(HomeActivity.this, MainActivity.class);
                intent.putExtra(TITLE, "这是主页传过来的数据");
                intent.putExtra(USER_INFO, userInfo);

                startActivityForResult(intent, REQUEST_CODE);
            }
        },1000);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE && resultCode == MainActivity.RESULT_CODE){
            if(data != null){
                String title = data.getStringExtra(TITLE);
                mtextView.setText(title);
            }
        }
    }
}
