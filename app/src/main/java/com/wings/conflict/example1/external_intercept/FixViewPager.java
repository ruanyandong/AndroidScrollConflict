package com.wings.conflict.example1.external_intercept;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.viewpager.widget.ViewPager;

/**
 * @desc : 外部拦截法
 *
 * //博客 https://www.jianshu.com/p/982a83271327
 */
public class FixViewPager extends ViewPager {

        private int mLastXIntercept;
        private int mLastYIntercept;

        public FixViewPager(Context context, AttributeSet attrs) {
            super(context, attrs);
        }

        @Override
        public boolean onInterceptTouchEvent(MotionEvent ev) {
            boolean intercepted = false;
            int x = (int) ev.getX();
            int y = (int) ev.getY();
            // 掩码和action进行&操作，得到的还是action
            final int action = ev.getAction() & MotionEvent.ACTION_MASK;
            switch (action) {
                case MotionEvent.ACTION_DOWN:
                    intercepted = false;
                    //调用ViewPager的onInterceptTouchEvent方法初始化mActivePointerId
                    //这里我们在ACTION_DOWN 当中还调用了super.onInterceptTouchEvent(ev);即ViewPager的onInterceptTouchEvent方法。主要是为了初始化ViewPager的成员变量mActivePointerId。mActivePointerId默认值为-1，在ViewPager的onTouchEvent方法的ACTION_MOVE中有这么一段：
                    //class ViewPager
                    //    @Override
                    //    public boolean onTouchEvent(MotionEvent ev) {
                    //        ...
                    //        switch (action & MotionEventCompat.ACTION_MASK) {
                    //            case MotionEvent.ACTION_MOVE:
                    //                if (!mIsBeingDragged) {
                    //                    final int pointerIndex = ev.findPointerIndex(mActivePointerId);
                    //                    if (pointerIndex == -1) {
                    //                        // A child has consumed some touch events and put us into an inconsistent
                    //                        // state.
                    //                        needsInvalidate = resetTouch();
                    //                        break;
                    //                    }
                    //                    //具体的滑动操作...
                    //                }
                    //                ...
                    //                break;
                    //                ...
                    //        }
                    //        ...
                    //    }
                    //假如mActivePointerId不进行初始化，ViewPager会认为这个事件已经被子View给消费了，然后break掉，接下来的滑动操作也就不执行了。

                    super.onInterceptTouchEvent(ev);
                    break;
                case MotionEvent.ACTION_MOVE:
                    //横坐标位移增量
                    int deltaX = x - mLastXIntercept;
                    //纵坐标位移增量
                    int deltaY = y - mLastYIntercept;
                    if (Math.abs(deltaX)>Math.abs(deltaY)){
                        intercepted = true;
                    }else{
                        intercepted = false;
                    }
                    break;
                case MotionEvent.ACTION_UP:
                    intercepted = false;
                    break;
                default:
                    break;
            }

            mLastXIntercept = x;
            mLastYIntercept = y;

            return intercepted;
        }

}
