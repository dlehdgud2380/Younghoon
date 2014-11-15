package com.scoutlee.younghoon;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ActionBarActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;

    private CharSequence mDrawerTitle;
    private CharSequence mTitle;
    private String[] mDrawerItmes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);


        mTitle = mDrawerTitle = getTitle();


        mDrawerItmes = getResources().getStringArray(R.array.drawer_titles);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        // set a custom shadow that overlays the main content when the drawer oepns
        mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);

        // Add items to the ListView
        mDrawerList.setAdapter(new ArrayAdapter<String>(this, R.layout.drawer_list_item, mDrawerItmes));
        // Set the OnItemClickListener so something happens when a
        // user clicks on an item.


        // Enable ActionBar app icon to behave as action to toggle nav drawer

        mDrawerToggle = new ActionBarDrawerToggle(
                this,
                mDrawerLayout,
                R.drawable.ic_drawer,
                R.string.drawer_open,
                R.string.drawer_close
        ) {
            @Override
            public void onDrawerClosed(View view) {
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu
            }
        };

        mDrawerLayout.setDrawerListener(mDrawerToggle);

        // Set the default content area to item 0
        // when the app opens for the first time
        if (savedInstanceState == null) {
            navigateTo(0);
        }

    }

    /*
     * If you do not have any menus, you still need this function
     * in order to open or close the NavigationDrawer when the user
     * clicking the ActionBar app icon.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

	/*
     * When using the ActionBarDrawerToggle, you must call it during onPostCreate()
	 * and onConfigurationChanged()
	 */

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    private void navigateTo(int position) {
        Log.v(TAG, "List View Item: " + position);

        switch (position) {
            case 0:
            /*getSupportFragmentManager()
                .beginTransaction()
				.add(R.id.content_frame,
						ItemOne.newInstance(),
						ItemOne.TAG).commit();*/
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.content_frame, MainTabFragment.newInstance(), MainTabFragment.TAG).commit();
                break;
        }
    }

    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        getActionBar().setTitle(mTitle);
    }


}