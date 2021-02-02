package com.wings.conflict.example3;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.viewpager.widget.ViewPager;


public class ChildViewPager2 extends ViewPager {


    public ChildViewPager2(Context context) {
        super(context);
    }

    public ChildViewPager2(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        int curPosition;

        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                getParent().requestDisallowInterceptTouchEvent(true);
                break;
            case MotionEvent.ACTION_MOVE:
                curPosition = this.getCurrentItem();
                int count = this.getAdapter().getCount();
//                全部由孩子拦截触摸事件
                /*                getParent().requestDisallowInterceptTouchEvent(true);*/
                // 当当前页面在最后一页和第0页的时候，由父亲拦截触摸事件
                if (curPosition == count - 1 || curPosition == 0) {
                    getParent().requestDisallowInterceptTouchEvent(false);
                } else {//其他情况，由孩子拦截触摸事件
                    getParent().requestDisallowInterceptTouchEvent(true);
                }

        }
        return super.dispatchTouchEvent(ev);
    }
}
