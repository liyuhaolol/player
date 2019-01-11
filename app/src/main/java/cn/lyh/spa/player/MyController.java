package cn.lyh.spa.player;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.dueeeke.videoplayer.controller.GestureVideoController;

public class MyController extends GestureVideoController {
    private LinearLayout top_container;



    public MyController(@NonNull Context context) {
        this(context,null);
    }

    public MyController(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyController(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.controller;
    }

    @Override
    protected void initView() {
        super.initView();
        top_container = mControllerView.findViewById(R.id.top_container);
    }

    @Override
    public void show() {
        show(mDefaultTimeout);
    }


    private void show(int timeout){
        Log.e("liyuhao","show");
        top_container.setVisibility(VISIBLE);
        mShowing = true;
        //不自动消失
        /*removeCallbacks(mFadeOut);
        if (timeout != 0) {
            postDelayed(mFadeOut, timeout);
        }*/
    }

    @Override
    public void hide() {
        super.hide();
        Log.e("liyuhao","hide");
        top_container.setVisibility(GONE);
        mShowing = false;
    }
}
