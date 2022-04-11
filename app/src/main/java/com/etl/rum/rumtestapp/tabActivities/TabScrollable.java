package com.etl.rum.rumtestapp.tabActivities;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.etl.rum.rumtestapp.R;
import com.etl.rum.rumtestapp.adapters.ViewPagerAdapter;
import com.etl.rum.rumtestapp.tabFragments.FragmentFive;
import com.etl.rum.rumtestapp.tabFragments.FragmentFour;
import com.etl.rum.rumtestapp.tabFragments.FragmentOne;
import com.etl.rum.rumtestapp.tabFragments.FragmentThree;
import com.etl.rum.rumtestapp.tabFragments.FragmentTwo;

public class TabScrollable extends AppCompatActivity {
    private Context mContext;
    private TabLayout tabLayout;
    private Toolbar toolbar;
    private ViewPager viewPager;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_scrollable);
        this.mContext = this;
        this.toolbar = findViewById(R.id.toolbar);
        this.tabLayout = findViewById(R.id.tabs);
        this.viewPager = findViewById(R.id.viewpager);
        setSupportActionBar(this.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setViewPager(this.viewPager);
        this.tabLayout.setupWithViewPager(this.viewPager);
    }

    private void setViewPager(ViewPager viewPager) {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new FragmentOne(), "Fragment 1");
        viewPagerAdapter.addFragment(new FragmentTwo(), "Fragment 2");
        viewPagerAdapter.addFragment(new FragmentThree(), "Fragment 3");
        viewPagerAdapter.addFragment(new FragmentFour(), "Fragment 4");
        viewPagerAdapter.addFragment(new FragmentFive(), "5");
        viewPager.setAdapter(viewPagerAdapter);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 16908332:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
