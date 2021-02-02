package com.wings.conflict.example2.internal_intercept;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;

/**
 * @desc : 内部拦截法
 *
 * https://juejin.im/post/6844903806308712456
 */
public class MyListView extends ListView implements AbsListView.OnScrollListener {

    private boolean isScrollToTop;
    private boolean isScrollToBottom;

    private int mLastX;
    private int mLastY;

    public MyListView(Context context) {
        this(context, null);
    }

    public MyListView(Context context, AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public MyListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setOnScrollListener(this);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                getParent().requestDisallowInterceptTouchEvent(true);
                mLastX = (int) ev.getX();
                mLastY = (int) ev.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                if (superDispatchMoveEvent(ev)) {
                    getParent().requestDisallowInterceptTouchEvent(false);
                }
                break;
            case MotionEvent.ACTION_UP:
                break;
            default:
                break;
        }
        return super.dispatchTouchEvent(ev);
    }

    /**
     * 将事件交由父容器处理
     *
     * @param ev
     * @return
     */
    private boolean superDispatchMoveEvent(MotionEvent ev) {
        //手指下滑，滑动到顶部
        boolean canScrollBottom = isScrollToTop && (ev.getY() - mLastY) > 0;
        // 手指上滑，滑动到底部
        boolean canScrollTop = isScrollToBottom && (ev.getY() - mLastY) < 0;

        return canScrollBottom || canScrollTop;
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {

    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        isScrollToBottom = false;
        isScrollToTop = false;

        if (firstVisibleItem == 0) {
            android.view.View firstVisibleItemView = getChildAt(0);
            if (firstVisibleItemView != null && firstVisibleItemView.getTop() == 0) {
                isScrollToTop = true;
            }
        }


        if ((firstVisibleItem + visibleItemCount) == totalItemCount) {
            View lastVisibleItemView = getChildAt(getChildCount() - 1);
            if (lastVisibleItemView != null && lastVisibleItemView.getBottom() == getHeight()) {
                isScrollToBottom = true;
            }
        }
    }

}
