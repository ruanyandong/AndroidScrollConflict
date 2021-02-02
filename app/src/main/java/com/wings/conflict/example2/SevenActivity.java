package com.wings.conflict.example2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.wings.conflict.R;
import com.wings.conflict.example2.internal_intercept.MyListView;

import java.util.ArrayList;

public class SevenActivity extends AppCompatActivity {

    MyListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seven);
        //初始化ListView
        listView = findViewById(R.id.mlv);
        final ArrayList<String> datas = new ArrayList<>();
        //初始化数据，datas ,data0 ...data49
        for (int j = 0; j < 100; j++) {
            datas.add("data "+j);
        }
        //初始化adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>
                (this, android.R.layout.simple_list_item_1, datas);
        //设置adapter
        listView.setAdapter(adapter);
    }
}