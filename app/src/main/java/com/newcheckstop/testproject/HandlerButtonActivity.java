package com.newcheckstop.testproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import java.lang.ref.WeakReference;

public class HandlerButtonActivity extends AppCompatActivity {

    public static final int MESSAGE_CODE = 888888;

    private TextView mTextView;

    private final TestHandler mTestHandler = new TestHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_button);

        mTextView = (TextView) findViewById(R.id.handler_text_id);
        Message message = mTestHandler.obtainMessage();

        message.arg1 = 0;
        message.arg2 = 1;
        message.what = MESSAGE_CODE;
        message.obj = 10000;

        mTestHandler.sendMessageDelayed(message,1000);
    }

    private TextView getTextView() {
        return mTextView;
    }
    public class TestHandler extends Handler{

        public final WeakReference<HandlerButtonActivity> mHandlerButtonActivityWeakReference;
        public TestHandler(HandlerButtonActivity activity){

            mHandlerButtonActivityWeakReference = new WeakReference<>(activity);
        }
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            HandlerButtonActivity handlerButtonActivity = mHandlerButtonActivityWeakReference.get();
            //接受消息
            if (msg.what == MESSAGE_CODE) {
                int value = (int) msg.obj;
                handlerButtonActivity.getTextView().setText(String.valueOf(value / 1000));
                msg = Message.obtain();
                msg.arg1 = 0;
                msg.arg2 = 1;
                msg.what = MESSAGE_CODE;
                msg.obj = value - 1000;
                if (value > 0) {
                    sendMessageDelayed(msg, 1000);
                }
            }
        }
    }


}