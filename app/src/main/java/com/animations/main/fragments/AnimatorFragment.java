package com.animations.main.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.animations.main.R;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorListenerAdapter;
import com.nineoldandroids.animation.IntEvaluator;
import com.nineoldandroids.animation.ValueAnimator;

/**
 * 属性动画
 */

public class AnimatorFragment extends Fragment {

    private static final String TAG = "AnimatorFragment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_translate_rotate, container, false);
        final Button button=view.findViewById(R.id.btn_translate_rotate);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                ViewWrapper wrapper=new ViewWrapper(button);
//                wrapper.setWidth(100);  //起始值
//                ObjectAnimator.ofInt(wrapper,"width",500).setDuration(5000).start();

                performAnimate(button, button.getWidth(),500);
            }
        });
        return view;
    }

    //  示例 对一属性做动画
    /**
     * 方式一
     * 用一个类来包装原始对象，间接提供get/set方法
     */
    private class ViewWrapper{
        private View mTargetView;

        public ViewWrapper(View targetView) {
            mTargetView = targetView;
        }
        private int getWidth(){ return mTargetView.getLayoutParams().width; }

        private void setWidth(int width){
            mTargetView.getLayoutParams().width=width;
            mTargetView.requestLayout();
        }

    }


    /**
     * 方式二
     * 采用ValueAnimator，监听动画过程，实现属性改变
     * @param targetView
     * @param start
     * @param end
     */
    private void performAnimate(final View targetView,final int start,final int end){
        //动画过程中建议开启硬件加速
        targetView.setLayerType(View.LAYER_TYPE_HARDWARE,null);
        //如果sdk版本在14以上你可以使用属性动画，可以更简洁的设置硬件加速，调用withLayer()
//        targetView.animate().translationX(150f).withLayer().start();
        ValueAnimator valueAnimator=ValueAnimator.ofInt(1,100);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            //持有一个IntEvaluator对象，方便下面估值的时候使用
            IntEvaluator mIntEvaluator=new IntEvaluator();
            @Override
            public void onAnimationUpdate(ValueAnimator animator) {
                //获取当前动画的进度值，整型1-100之间
                int currentValue= (int) animator.getAnimatedValue();
                Log.i(TAG, "onAnimationUpdate: "+currentValue);
                //获取当前进度占整个动画过程的比例，浮点型，0-1之间
                float fraction=animator.getAnimatedFraction();
                //直接调用整型估值器，通过比例计算出高度，然后再设给目标VIEW
                targetView.getLayoutParams().width=mIntEvaluator.evaluate(fraction,start,end);
                targetView.requestLayout();
            }
        });
        valueAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationCancel(Animator animation) {
                // 设置一个回调，在动画完成时取消硬件加速
                targetView.setLayerType(View.LAYER_TYPE_HARDWARE,null);
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                // 设置一个回调，在动画完成时取消硬件加速
                targetView.setLayerType(View.LAYER_TYPE_HARDWARE,null);
            }
        });
        valueAnimator.setDuration(5000).start();
    }
}
