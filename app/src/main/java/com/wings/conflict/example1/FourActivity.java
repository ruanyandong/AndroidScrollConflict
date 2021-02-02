package com.wings.conflict.example1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.wings.conflict.R;
import com.wings.conflict.example1.adapter.MyAdapter;
import com.wings.conflict.example1.external_intercept.FixViewPager;
import java.util.ArrayList;
import java.util.List;

public class FourActivity extends AppCompatActivity {

    FixViewPager viewPager;
    List<View> viewList;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four);

        viewPager = findViewById(R.id.four_vp);
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