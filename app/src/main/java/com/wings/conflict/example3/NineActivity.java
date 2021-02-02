package com.wings.conflict.example3;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;
import com.wings.conflict.R;
import java.util.ArrayList;

/**
 * @author AI
 */
public class NineActivity extends AppCompatActivity {

    ViewPager mViewPager;
    TabLayout mTabLayout;

    private final String[] mTitles=new String[]{
            "首页","微博","相册","我的"
    };
    private ArrayList<Fragment> mFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nine);
        initView();
        initdata();
    }

    private void initdata() {
        mFragments = new ArrayList<>();
        for(int i=0;i<mTitles.length;i++){
            ListFragment listFragment = new ListFragment();
            mFragments.add(listFragment);

        }

        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return mFragments.get(position);
            }

            @Override
            public int getCount() {
                return mFragments.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return mTitles[position];
            }
        });
        mTabLayout.setupWithViewPager(mViewPager);

        mViewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
            }
        });
    }

    private void initView() {
        mViewPager=(ViewPager)findViewById(R.id.viewPager);
        mTabLayout=(TabLayout)findViewById(R.id.tabs);
    }
}