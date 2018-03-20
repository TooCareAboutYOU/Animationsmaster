package com.animations.main.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.animations.main.R;
import com.animations.main.widgets.CustomButtonView;
import com.animations.main.widgets.CustomViewgroup;


public class ViewMotionEventFragment extends Fragment {

    private static final String TAG = "ViewMotionEventFragment";
    
    private View view;
    private Button button;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.layout_motionevent, container, false);
        CustomButtonView customButton=view.findViewById(R.id.btn_custom);
        customButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:{
                        Log.d(CustomButtonView.TAG, "自定义控件监听 OnTouchListener: ACTION_DOWN");
                        break;
                    }
                    case MotionEvent.ACTION_UP:{
                        Log.d(CustomButtonView.TAG, "自定义控件监听 OnTouchListener: ACTION_UP");
                        break;
                    }

                }
                return false;
            }
        });
        customButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(CustomButtonView.TAG, "自定义控件 onClick: ");
            }
        });

//        CustomViewgroup viewGroup=view.findViewById(R.id.vg_custom);
//        viewGroup.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                switch (event.getAction()) {
//                    case MotionEvent.ACTION_DOWN:{
//                        Log.v(CustomButtonView.TAG, "自定义控件组监听 OnTouchListener: ACTION_DOWN");
//                        break;
//                    }
//                    case MotionEvent.ACTION_UP:{
//                        Log.v(CustomButtonView.TAG, "自定义控件组监听 OnTouchListener: ACTION_UP");
//                        break;
//                    }
//
//                }
//                return false;
//            }
//        });

        return view;
    }

    


}
