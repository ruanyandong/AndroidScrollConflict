package com.wings.conflict.example1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.wings.conflict.R;
import com.wings.conflict.example1.adapter.MyAdapter;
import com.wings.conflict.example1.bad.BadViewPager;
import java.util.ArrayList;
import java.util.List;

//博客 https://www.jianshu.com/p/982a83271327
public class ThreeActivity extends AppCompatActivity {

    BadViewPager viewPager;
    List<View> viewList;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);

        viewPager = findViewById(R.id.three_vp);
        viewList = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            //初始化ListView
            ListView listView = new ListView(this);
            final ArrayList<String> datas = new ArrayList<>();
            //初始化数据，datas ,data0 ...data49
            for (int j = 0; j < 50; j++) {
                datas.add("data "+j);
            }
            //初始化adapter
            ArrayAdapter<String> adapter = new ArrayAdapter<>
                    (this, android.R.layout.simple_list_item_1, datas);
            //设置adapter
            listView.setAdapter(adapter);
            //将ListView赋值给当前View
            viewList.add(listView);
        }

        adapter = new MyAdapter(viewList);
        viewPager.setAdapter(adapter);
    }
}