package com.etl.rum.rumtestapp.tabActivities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.etl.rum.rumtestapp.R;
import com.etl.rum.rumtestapp.tabFragments.FragmentOne;
import com.etl.rum.rumtestapp.tabFragments.FragmentThree;
import com.etl.rum.rumtestapp.tabFragments.FragmentTwo;

import java.util.ArrayList;
import java.util.List;

public class IconTextTabsActivity extends AppCompatActivity {
    private int[] tabIcons = new int[]{R.drawable.ic_tab_favourite, R.drawable.ic_tab_call, R.drawable.ic_tab_contacts};
    private TabLayout tabLayout;
    private Toolbar toolbar;
    private ViewPager viewPager;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_icon_text_tabs);
        this.toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(this.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.viewPager = findViewById(R.id.viewpager);
        setupViewPager(this.viewPager);
        this.tabLayout = findViewById(R.id.tabs);
        this.tabLayout.setupWithViewPager(this.viewPager);
        setupTabIcons();
    }

    private void setupTabIcons() {
        this.tabLayout.getTabAt(0).setIcon(this.tabIcons[0]);
        this.tabLayout.getTabAt(1).setIcon(this.tabIcons[1]);
        this.tabLayout.getTabAt(2).setIcon(this.tabIcons[2]);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new FragmentOne(), "ONE");
        adapter.addFrag(new FragmentTwo(), "TWO");
        adapter.addFrag(new FragmentThree(), "THREE");
        viewPager.setAdapter(adapter);
    }

    private class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList();
        private final List<String> mFragmentTitleList = new ArrayList();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        public Fragment getItem(int position) {
            return this.mFragmentList.get(position);
        }

        public int getCount() {
            return this.mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            this.mFragmentList.add(fragment);
            this.mFragmentTitleList.add(title);
        }

        public CharSequence getPageTitle(int position) {
            return this.mFragmentTitleList.get(position);
        }
    }
}
