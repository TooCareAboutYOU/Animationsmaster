package com.animations.main.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by zs on 2018/3/19.
 */

public class CustomViewgroup extends LinearLayout {

    public CustomViewgroup(Context context) {
        super(context);
        init(context);
    }

    public CustomViewgroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);

    }

    public CustomViewgroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);

    }

    private void init(Context context){
        setOrientation(VERTICAL);
        CustomButtonView customButtonView=new CustomButtonView(context);
        customButtonView.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:{
                        Log.w(CustomButtonView.TAG, "ViewGroup view setOnTouchListener: ACTION_DOWN");
                        break;
                    }
                    case MotionEvent.ACTION_UP:{
                        Log.w(CustomButtonView.TAG, "ViewGroup view setOnTouchListener: ACTION_UP");
                        break;
                    }
                }
                return false;
            }
        });
        addView(customButtonView);



    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:{
                Log.w(CustomButtonView.TAG, "ViewGroup onTouchEvent: ACTION_DOWN");
                break;
            }
            case MotionEvent.ACTION_UP:{
                Log.w(CustomButtonView.TAG, "ViewGroup onTouchEvent: ACTION_UP");
                break;
            }
        }
        return super.onTouchEvent(event);
    }

    //事件拦截
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:{
                Log.w(CustomButtonView.TAG, "ViewGroup onInterceptTouchEvent: ACTION_DOWN");
                break;
            }
            case MotionEvent.ACTION_UP:{
                Log.w(CustomButtonView.TAG, "ViewGroup onInterceptTouchEvent: ACTION_UP");
                break;
            }
        }
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:{
                Log.w(CustomButtonView.TAG, "ViewGroup dispatchTouchEvent: ACTION_DOWN");
                break;
            }
            case MotionEvent.ACTION_UP:{
                Log.w(CustomButtonView.TAG, "ViewGroup dispatchTouchEvent: ACTION_UP");
                break;
            }
        }
        return super.dispatchTouchEvent(ev);
    }
}
