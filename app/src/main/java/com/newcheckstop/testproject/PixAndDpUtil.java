package com.newcheckstop.testproject;

import android.content.Context;
import android.util.Log;
import android.util.TypedValue;

public class PixAndDpUtil {
    //dp转px
    public int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
    //px转dp
    public int px2dip(Context context, int pxValue) {
        return ((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, pxValue, context.getResources().getDisplayMetrics()));
    }
}
