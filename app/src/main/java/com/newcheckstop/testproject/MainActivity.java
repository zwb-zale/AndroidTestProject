package com.newcheckstop.testproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = MainActivity.class.getSimpleName();
    public static final int RESULT_CODE = 1234;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG,"onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        Button mfirstbutton = (Button) findViewById(R.id.button_first);
        mfirstbutton.setOnClickListener(this);

        Button msecondbutton = (Button) findViewById(R.id.button_second);
        msecondbutton.setOnClickListener(this);

        Button mthirdbutton = (Button) findViewById(R.id.button_third);
        mthirdbutton.setOnClickListener(this);

        Button mfivebutton = (Button) findViewById(R.id.button_five);
        mfivebutton.setOnClickListener(this);

        Button mfragmenbutton = (Button) findViewById(R.id.button_fragment);
        mfragmenbutton.setOnClickListener(this);

        Button mhandlerbutton = (Button) findViewById(R.id.button_handler);
        mhandlerbutton.setOnClickListener(this);

        Button mservicebutton = (Button) findViewById(R.id.button_musice_service);
        mservicebutton.setOnClickListener(this);

        Button mbroadcastbutton = (Button) findViewById(R.id.button_broadcast);
        mbroadcastbutton.setOnClickListener(this);

        Button mwebviewbutton = (Button) findViewById(R.id.button_webview);
        mwebviewbutton.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_first:
                startActivity(new Intent(MainActivity.this,HomeActivity.class));
                break;
            case R.id.button_second:
                startActivity(new Intent(MainActivity.this,ListViewDemoActivity.class));
                break;
            case R.id.button_third:
                startActivity(new Intent(MainActivity.this,GridViewDemoActivity.class));
                break;
            case R.id.button_five:
                startActivity(new Intent(MainActivity.this,TestViewButtonActivity.class));
                break;
            case R.id.button_fragment:
                startActivity(new Intent(MainActivity.this,TestFragmentActivity.class));
                break;
            case R.id.button_handler:
                startActivity(new Intent(MainActivity.this,HandlerButtonActivity.class));
                break;
            case R.id.button_musice_service:
                startActivity(new Intent(MainActivity.this,MusicButtonActivity.class));
                break;
            case R.id.button_broadcast:
                startActivity(new Intent(MainActivity.this,SendBrocastActivity.class));
                break;
            case R.id.button_webview:
                startActivity(new Intent(MainActivity.this,WebViewButtonActivity.class));
                break;
        }
    }
}