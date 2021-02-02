package com.wings.conflict.example3;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.wings.conflict.R;
import com.wings.conflict.example1.adapter.MyAdapter;

import java.util.ArrayList;
import java.util.List;

public class ListFragment2 extends Fragment {

    ChildViewPager childViewPager;
    List<View> viewList;
    MyAdapter adapter;
    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_list2,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        childViewPager = view.findViewById(R.id.view_pager);
        viewList = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            TextView tv = new TextView(getActivity());
            tv.setText("666666666");
            tv.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            tv.setTextSize(24);
            tv.setGravity(Gravity.CENTER);
            tv.setBackgroundColor(R.color.colorAccent);
            viewList.add(tv);
        }
        adapter = new MyAdapter(viewList);
        childViewPager.setAdapter(adapter);
    }
}
