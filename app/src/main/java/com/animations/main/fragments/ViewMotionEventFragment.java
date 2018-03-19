package com.animations.main.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.animations.main.R;

/**
 * Created by admin on 2018/3/19.
 */

public class ViewMotionEventFragment extends Fragment{

    private View view;
    private Button button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_translate_rotate, container, false);
        button=view.findViewById(R.id.btn_translate_rotate);

        return view;
    }
}
