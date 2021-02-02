package com.wings.conflict.example3;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;

/**
 * https://www.jianshu.com/p/9d4f52e85152
 * 内部拦截法
 */
public class ChildViewPager extends ViewPager {

    private int mStartX;

    public ChildViewPager(Context context) {
        super(context);
    }

    public ChildViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mStartX = (int) ev.getX();
                getParent().requestDisallowInterceptTouchEvent(true);
                break;
            case MotionEvent.ACTION_MOVE:
                int dx = (int) getX() - mStartX;
                int position = getCurrentItem();
                int allCount = getAdapter().getCount();
                boolean isInterceptByParent = (position == 0 && dx > 0) || ((position == allCount - 1) && dx < 0);
                if (isInterceptByParent) {
                    getParent().getParent().requestDisallowInterceptTouchEvent(!isInterceptByParent);
                } else {
                    getParent().getParent().requestDisallowInterceptTouchEvent(true);
                }
                break;
            default:
                break;
        }
        return super.dispatchTouchEvent(ev);
    }
}
