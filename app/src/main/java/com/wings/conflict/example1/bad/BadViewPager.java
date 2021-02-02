package com.wings.conflict.example1.bad;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.viewpager.widget.ViewPager;

/**
 *
 * //博客 https://www.jianshu.com/p/982a83271327
 */
public class BadViewPager extends ViewPager {
    public BadViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return false;
    }
}