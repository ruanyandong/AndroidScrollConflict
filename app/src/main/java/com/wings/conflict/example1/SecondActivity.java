package com.wings.conflict.example1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.wings.conflict.R;
import com.wings.conflict.example1.adapter.MyAdapter;
import com.wings.conflict.example1.bad.BadViewPager;
import java.util.ArrayList;
import java.util.List;

/**
 * View 的onTouchEvent 方法默认都会消费掉事件（返回true），除非它是不可点击的（clickable和longClickable同时为false），View的longClickable默认为false，clickable需要区分情况，如Button的clickable默认为true，而TextView的clickable默认为false。
 *
 * 所以TextView默认并没有消费事件，因为他是不可点击的。事件会交由父View即BadViewPager的onTouchEvent方法去处理。所以它自然是可以滑动的。
 *
 * 我们将textview的Clickable设置成true，即让它来消费事件
 *
 * 所以我们不难推测如果将TextView换成Button，将是一样的无法滑动的效果。虽然这并不是常规的滑动冲突（子View不是滑动的），但是造成的原因其实是一样的，没有做滑动判断导致父View不能正确响应滑动事件。
 *
 * =================如果使用系统的ViewPager在这种情况下则不会冲突，BadViewPager才会=================
 */
public class SecondActivity extends AppCompatActivity {

    BadViewPager viewPager;
    List<View> viewList;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        viewPager = findViewById(R.id.second_vp);
        viewList = new ArrayList<>();
        viewList.add(getLayoutInflater().inflate(R.layout.items1,null));
        viewList.add(getLayoutInflater().inflate(R.layout.items2,null));
        adapter = new MyAdapter(viewList);
        viewPager.setAdapter(adapter);
    }

}