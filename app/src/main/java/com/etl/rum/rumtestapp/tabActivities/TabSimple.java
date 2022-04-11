package com.etl.rum.rumtestapp.tabActivities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import com.etl.rum.rumtestapp.R;
import com.etl.rum.rumtestapp.adapters.ViewPagerAdapter;
import com.etl.rum.rumtestapp.tabFragments.FragmentOne;
import com.etl.rum.rumtestapp.tabFragments.FragmentThree;
import com.etl.rum.rumtestapp.tabFragments.FragmentTwo;

public class TabSimple extends AppCompatActivity {
    private TabLayout tabLayout;
    private Toolbar toolbar;
    private ViewPager viewPager;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_simple);
        this.toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(this.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.viewPager = findViewById(R.id.viewpager);
        setupViewPager(this.viewPager);
        this.tabLayout = findViewById(R.id.tabs);
        this.tabLayout.setupWithViewPager(this.viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new FragmentOne(), "ONE");
        adapter.addFragment(new FragmentTwo(), "TWO");
        adapter.addFragment(new FragmentThree(), "THREE");
        viewPager.setAdapter(adapter);
    }
}
