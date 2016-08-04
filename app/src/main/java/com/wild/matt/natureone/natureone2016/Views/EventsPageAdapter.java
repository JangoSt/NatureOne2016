package com.wild.matt.natureone.natureone2016.Views;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import com.wild.matt.natureone.natureone2016.Fragments.BlankFragment;
import com.wild.matt.natureone.natureone2016.Fragments.EventsList;
import com.wild.matt.natureone.natureone2016.Fragments.OverViewFragment;

/**
 * Created by Matze on 03.08.2016.
 */
public  class EventsPageAdapter extends FragmentPagerAdapter {
    private static int NUM_ITEMS = 3;
    String TAG = "EventsPageAdapter";

    public EventsPageAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    // Returns total number of pages
    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    // Returns the fragment to display for that page
    @Override
    public Fragment getItem(int position) {
        Log.d(TAG, "getItem");
        switch (position) {
            case 0: // Fragment # 0 - This will show FirstFragment
                return new BlankFragment();
            case 1: // Fragment # 0 - This will show FirstFragment different title
                return EventsList.newInstance("hello", "Page # 1");
            case 2: // Fragment # 1 - This will show SecondFragment
                return EventsList.newInstance("hello", "Page # 1");
            default:
                return null;
        }
    }

    // Returns the page title for the top indicator
    @Override
    public CharSequence getPageTitle(int position) {
        return "Page " + position;
    }

}

