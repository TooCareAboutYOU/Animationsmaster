package com.animations.main;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;

import com.animations.main.fragments.AnimatorFragment;
import com.animations.main.fragments.TranslateRotateFragment;
import com.animations.main.fragments.ViewFragment;
import com.animations.main.fragments.ViewMotionEventFragment;
import com.animations.main.widgets.CustomButtonView;

public class FunctionActivity extends AppCompatActivity {

    public static final String TRANSLATE_ROTATE="Translate_Rotate";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_function);
        FragmentManager manager=getSupportFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();

        int type=getIntent().getIntExtra(TRANSLATE_ROTATE,0);
        switch (type) {
            case 0:{
                transaction.add(R.id.cl_container,new TranslateRotateFragment());
                break;
            }case 1:{
                transaction.add(R.id.cl_container,new AnimatorFragment());
                break;
            }case 2:{
                transaction.add(R.id.cl_container,new ViewFragment());
                break;
            }case 3:{
                transaction.add(R.id.cl_container,new ViewMotionEventFragment());
                break;
            }
        }
        transaction.commit();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:{
                Log.e(CustomButtonView.TAG, "父级 onTouchEvent: ACTION_DOWN");
                break;
            }
            case MotionEvent.ACTION_UP:{
                Log.e(CustomButtonView.TAG, "父级 onTouchEvent: ACTION_UP");
                break;
            }
        }
        return super.onTouchEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:{
                Log.e(CustomButtonView.TAG, "父级 dispatchTouchEvent: ACTION_DOWN");
                break;
            }
            case MotionEvent.ACTION_UP:{
                Log.e(CustomButtonView.TAG, "父级 dispatchTouchEvent: ACTION_UP");
                break;
            }
        }
        return super.dispatchTouchEvent(ev);
    }


}
