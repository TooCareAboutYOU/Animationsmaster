package com.animations.main.anims;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * Created by admin on 2018/3/19.
 */

public class Rotate3dAnimation extends Animation {


    private float mFromDgrees=0f;
    private float mToDgrees=0f;
    private float mCenterX=0f;
    private float mCenterY=0f;
    private float mDepthz=0f;
    private boolean mReverse=false;
    private Camera mCamera;

    public Rotate3dAnimation(float fromDgrees,float toDgrees,float centerX,float centerY,float depthz,boolean reverse) {
        mFromDgrees=fromDgrees;
        mToDgrees=toDgrees;
        mCenterX=centerX;
        mCenterY=centerY;
        mDepthz=depthz;
        mReverse=reverse;
    }


    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
        mCamera=new Camera();
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        final float fromDgrees=mFromDgrees;
        float degrees=fromDgrees+((mToDgrees-fromDgrees) * interpolatedTime);
        final float centerX=mCenterX;
        final float centerY=mCenterY;
        final Camera camera=mCamera;
        final Matrix matrix=t.getMatrix();
        camera.save();
        if (mReverse) {
            camera.translate(0.0f,0.0f,mDepthz * interpolatedTime);
        }else {
            camera.translate(0.0f,0.0f,mDepthz * (1.0f-interpolatedTime));
        }
        camera.rotateX(degrees);
        camera.getMatrix(matrix);
        camera.restore();
        matrix.preTranslate(-centerX,-centerY);
        matrix.postTranslate(centerX,centerY);
    }
}
