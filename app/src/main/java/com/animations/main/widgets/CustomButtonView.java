package com.animations.main.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

/**
 * View的事件分发机制
 * 总结：（以一个MotionEvent为例）
 * 第一步：父级的dispatchTouchEvent->子级内部的dispatchTouchEvent
 * 第二步：子级内部的dispatchTouchEvent->子级的OnTouchListener
 * 第三步：子级的OnTouchListener->子级内部的onTouchEvent
 * 第四步：子级内部的onTouchEvent所有操作执行完后，最后执行子级的OnClickListener
 */

public class CustomButtonView extends android.support.v7.widget.AppCompatButton {

    public static final String TAG = "Custom";

    public CustomButtonView(Context context) {
        super(context);
        init();
    }

    public CustomButtonView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomButtonView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        setText("事件分发传递机制");
        setTextColor(Color.RED);
        setTextSize(16);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:{
                Log.i(TAG, "自定义控件内部 onTouchEvent: ACTION_DOWN");
                break;
            }
            case MotionEvent.ACTION_UP:{
                Log.i(TAG, "自定义控件内部 onTouchEvent: ACTION_UP");
                break;
            }
        }
        return super.onTouchEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:{
                Log.i(TAG, "自定义控件内部 dispatchTouchEvent: ACTION_DOWN");
                break;
            }
            case MotionEvent.ACTION_UP:{
                Log.i(TAG, "自定义控件内部 dispatchTouchEvent: ACTION_UP");
                break;
            }
        }
        return super.dispatchTouchEvent(event);
    }


}
