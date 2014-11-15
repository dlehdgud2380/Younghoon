package com.scoutlee.younghoon;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MainTabAdapter extends FragmentPagerAdapter {

    final int PAGE_COUNT = 2;

    /**
     * Constructor of the class
     */
    public MainTabAdapter(FragmentManager fm) {
        super(fm);
    }

    /**
     * This method will be invoked when a page is requested to create
     */

    @Override
    public Fragment getItem(int arg0) {
        Bundle data = new Bundle();
        switch (arg0) {

            /** tab1 is selected */
            case 0:
                MainTab1 maintab1 = new MainTab1();
                return maintab1;

            /** tab2 is selected */
            case 1:
                MainTab2 maintab2 = new MainTab2();
                return maintab2;
        }
        return null;
    }

    /**
     * Returns the number of pages
     */

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }
}

