package com.example.ddh;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

public class CheckListActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    SectionPageAdapter adapter = new SectionPageAdapter(getSupportFragmentManager());
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.check_list_activity);
        mViewPager = (ViewPager) findViewById(R.id.container);
        setupViewPager(mViewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
    }
    public void setupViewPager(ViewPager viewPager) {
        adapter.addFragment(new Fragment_First(), "환경");
        adapter.addFragment(new Fragment_Second(), "음식");
        adapter.addFragment(new Fragment_Third(), "APP");
        viewPager.setAdapter(adapter);
    }
}