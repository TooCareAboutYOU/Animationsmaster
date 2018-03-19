package com.animations.main.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import com.animations.main.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TranslateRotateFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_translate_rotate, container, false);
        Button button=view.findViewById(R.id.btn_translate_rotate);
        Animation animation= AnimationUtils.loadAnimation(getContext(),R.anim.animation_translate_rotate);
        button.setAnimation(animation);
        return view;
    }

}
