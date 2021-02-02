package com.wings.conflict.example1.internal_intercept;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.viewpager.widget.ViewPager;

/**
 * @desc :  内部拦截法
 *
 * 博客 https://www.jianshu.com/p/982a83271327
 */
public class FixViewPager2 extends ViewPager {

    public FixViewPager2(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        final int action = ev.getAction() & MotionEvent.ACTION_MASK;
        if (action == MotionEvent.ACTION_DOWN){
            super.onInterceptTouchEvent(ev);
            return false;
        }
        return true;
    }
}
