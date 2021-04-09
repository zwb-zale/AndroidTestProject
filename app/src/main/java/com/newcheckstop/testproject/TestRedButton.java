package com.newcheckstop.testproject;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public class TestRedButton extends View implements View.OnClickListener {
    private Paint mPaint;
    private Rect mRect;
    private int mNumber = 20;

    private int mBackgroundColor;
    private int mTextSize;

    public TestRedButton(Context context) {
        this(context,null);
    }

    public TestRedButton(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TestRedButton(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context,attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public TestRedButton(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

    }

    private void init(Context context, AttributeSet attrs){
        mPaint = new Paint();
        mRect = new Rect();
        this.setOnClickListener(this);
        PixAndDpUtil pixAndDpUtil = new PixAndDpUtil();
        TypedArray typedArray = context.obtainStyledAttributes(attrs,R.styleable.TestRedButton);
        mBackgroundColor = typedArray.getColor(R.styleable.TestRedButton_backgroundColor,Color.RED);

        mTextSize = typedArray.getDimensionPixelSize(R.styleable.TestRedButton_textSize,180);
        mTextSize = pixAndDpUtil.px2dip(context, mTextSize);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.i(HomeActivity.TAG,"onDraw");
        //设置画布为红色
        mPaint.setColor(mBackgroundColor);
        canvas.drawCircle(getWidth()/2, getWidth()/2, getWidth()/2, mPaint);
        //中建白色数字
        mPaint.setColor(Color.WHITE);
        mPaint.setTextSize(mTextSize);

        String text = String.valueOf(mNumber);
        mPaint.getTextBounds(text,0,text.length(),mRect);

        int textWidth = mRect.width();
        int textHeight = mRect.height();
        canvas.drawText(text, getWidth()/2 - textWidth/2, getHeight()/2 + textHeight/2, mPaint);
    }

    @Override
    public void onClick(View v) {
        if(mNumber>0){
            mNumber--;
            invalidate();
        }
    }
}
