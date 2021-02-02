package com.wings.conflict.example2.internal_intercept;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

/**
 * @desc : 内部拦截法
 *
 * https://juejin.im/post/6844903806308712456
 */
public class MyScrollView extends ScrollView {
    public MyScrollView(Context context) {
        super(context);
    }

    public MyScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        // 写法1
//        boolean intercepted  = super.onInterceptTouchEvent(ev);
//        if (ev.getAction() == MotionEvent.ACTION_UP) {
//            intercepted = true;
//        }
//        return intercepted;

        // 写法2
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            onTouchEvent(ev);//或者super.onInterceptTouchEvent(ev);
            return false;
        }
        return true;
    }



}
