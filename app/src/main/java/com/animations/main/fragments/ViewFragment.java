package com.animations.main.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.animations.main.R;

/**
 * View 初步认识
 */

public class ViewFragment extends Fragment{

    private static final String TAG = "ViewFragment";

    private View view;
    private Button button;
    private GestureDetector mGestureDetector;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_translate_rotate, container, false);
        button=view.findViewById(R.id.btn_translate_rotate);
        mGestureDetector=new GestureDetector(new MyGestureDetector());
        button.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return mGestureDetector.onTouchEvent(motionEvent);
            }
        });

        return view;
    }



    /**
     * 接管button的MotionEvent方法
     */
    private class MyGestureDetector implements GestureDetector.OnGestureListener,GestureDetector.OnDoubleTapListener{

        @Override
        public boolean onDown(MotionEvent motionEvent) {
            Log.i(TAG, "onDown: ");
            return false;
        }

        // 手指轻轻的触摸屏幕，强调尚未松开或者拖动
        @Override
        public void onShowPress(MotionEvent motionEvent) {
            Log.i(TAG, "onShowPress: ");
        }

        //单击行为
        @Override
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            Log.i(TAG, "onSingleTapUp: MotionEvent.ACTION_UP");
            return false;
        }

        //拖动行为
        @Override
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
            Log.i(TAG, "onScroll: ");
            return false;
        }

        //长按行为
        @Override
        public void onLongPress(MotionEvent motionEvent) {
            Log.i(TAG, "onLongPress: ");

        }

        //快速滑动
        @Override
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
            Log.i(TAG, "onFling: ");
            return false;
        }



        //严格的单击行为
        // 若触发此行为，则其不会再紧跟一个单击行为，即这只可能是单击行为
        @Override
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            Log.i(TAG, "onSingleTapConfirmed: ");
            return false;
        }

        //双击，有两次连续的单击组成，它不可能和onSingleTapConfirmed共存
        @Override
        public boolean onDoubleTap(MotionEvent motionEvent) {
            Log.i(TAG, "onDoubleTap: ");
            return false;
        }

        //双击行为
        @Override
        public boolean onDoubleTapEvent(MotionEvent motionEvent) {
            Log.i(TAG, "onDoubleTapEvent: ");
            return false;
        }
    }



}
