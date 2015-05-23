package com.example.sv11130072.mto;



import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import android.os.Bundle;



public class home extends FragmentActivity implements ActionBar.TabListener {

    ViewPager viewPager ;
    ActionBar actionBar;
    @Override
    public void onCreate(Bundle b){
        super.onCreate(b);
        setContentView(R.layout.activity_home);
        actionBar =  getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        viewPager = (ViewPager) findViewById(R.id.paper);
        FragmentManager fragmentPagerAdapter = getSupportFragmentManager();
        viewPager.setAdapter(new MyAdapter(fragmentPagerAdapter));
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener(){

            @Override
            public void onPageScrolled(int i, float v, int i2) {

            }

            @Override
            public void onPageSelected(int i) {
                actionBar.setSelectedNavigationItem(i);

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        ActionBar.Tab tab1 = actionBar.newTab();
        tab1.setText("Trang chu");
        tab1.setTabListener(this);
        ActionBar.Tab tab2 = actionBar.newTab();
        tab1.setText("Messenger");
        tab1.setTabListener(this);
        ActionBar.Tab tab3 = actionBar.newTab();
        tab1.setText("List Friends");
        tab1.setTabListener(this);
        ActionBar.Tab tab4 = actionBar.newTab();
        tab1.setText("Trang ca nhan");
        tab1.setTabListener(this);
        ActionBar.Tab tab5 = actionBar.newTab();
        tab1.setText("Cai dat");
        tab1.setTabListener(this);
        actionBar.addTab(tab1);
        actionBar.addTab(tab2);
        actionBar.addTab(tab3);
        actionBar.addTab(tab4);
        actionBar.addTab(tab5);


    }


    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        viewPager.setCurrentItem(tab.getPosition());

    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }
}
class MyAdapter extends FragmentPagerAdapter{

    public MyAdapter(android.support.v4.app.FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        Fragment fragment = null;
        if(i==0){
            fragment = new HomeMain();
        }
        if(i==1) fragment = new Messenger();
        if(i==2) fragment = new ListFriends();
        if(i==3) fragment = new personal();
        if(i==4) fragment = new Setting();
        return fragment;
    }

    @Override
    public int getCount() {
        return 5;
    }
}
