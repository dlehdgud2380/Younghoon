package com.scoutlee.yhhs;

import java.util.Locale;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.ShareActionProvider;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import toast.library.meal.MealLibrary;


public class MealActivity extends ActionBarActivity {

    String LOG_TAG = "MealActivity";
    NetworkChecker NetCheck;
    private SlidingTabLayout mSlidingTabLayout;
    private ViewPager mViewPager;
    ShareActionProvider mShareActionProvider;

    static String[] LunchArray;
    static String[] LunchKcalArray;
    static String[] DinnerArray;
    static String[] DinnerKcalArray;

    private final Handler handler = new Handler()
    {
        @Override
        public void handleMessage(Message msg)
        {
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.meal);

        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mSlidingTabLayout = (SlidingTabLayout) findViewById(R.id.sliding_tabs);
        mViewPager.setAdapter(new SamplePagerAdapter());
        mSlidingTabLayout.setViewPager(mViewPager);
        //SRL = (SwipeRefreshLayout)findViewById(R.id.swiperefresh);

        NetCheck = new NetworkChecker(MealActivity.this);

        loadMealTask();

      /*  SRL.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadMealTask();
            }
        });*/

    }

    class SamplePagerAdapter extends PagerAdapter {

        /**
         * @return the number of pages to display
         */
        @Override
        public int getCount() {
            return 5;
        }

        /**
         * @return true if the value returned from
         *         {@link #instantiateItem(ViewGroup, int)} is the same object
         *         as the {@link View} added to the {@link ViewPager}.
         */
        @Override
        public boolean isViewFromObject(View view, Object o) {
            return o == view;
        }

        // BEGIN_INCLUDE (pageradapter_getpagetitle)
        /**
         * Return the title of the item at {@code position}. This is important
         * as what this method returns is what is displayed in the
         * {@link SlidingTabLayout}.
         * <p>
         * Here we construct one using the position value, but for real
         * application the title should refer to the item's contents.
         */
        @Override
        public CharSequence getPageTitle(int position) {
            Locale l = Locale.getDefault();
            switch (position) {
                case 0:
                    return getString(R.string.monmeal).toUpperCase(l);
                case 1:
                    return getString(R.string.tuemeal).toUpperCase(l);
                case 2:
                    return getString(R.string.wedmeal).toUpperCase(l);
                case 3:
                    return getString(R.string.thumeal).toUpperCase(l);
                case 4:
                    return getString(R.string.frimeal).toUpperCase(l);
            }
            return null;
        }

        // END_INCLUDE (pageradapter_getpagetitle)



        /**
         * Instantiate the {@link View} which should be displayed at
         * {@code position}. Here we inflate a layout from the apps resources
         * and then change the text view to signify the position.
         */
        @Override
        public Object instantiateItem(ViewGroup container, int position) {

            try{
                if (mShareActionProvider != null ) {
                    mShareActionProvider.setShareIntent(createShareIntent(mViewPager.getCurrentItem()+1));
                } else {
                }
            }catch(Exception e){}
            // Inflate a new layout from our resources

            View view = getLayoutInflater().inflate(R.layout.fragment_meal,
                    container, false);
            TextView LunchTxt = (TextView)view.findViewById(R.id.lunchtxt);
            TextView DinnerTxt = (TextView)view.findViewById(R.id.dinnertxt);

            if(LunchArray==null){
                LunchTxt.setText(getResources().getString(R.string.not_loaded_yet));
            }else if(LunchArray[position+1]==null){
                LunchTxt.setText(getResources().getString(R.string.nodata));
            }else{
                String LunchData = LunchArray[position+1]+"\n\n"+LunchKcalArray[position+1]+" Kcal";
                LunchTxt.setText(LunchData);
            }

            if(DinnerArray==null){
                DinnerTxt.setText(getResources().getString(R.string.not_loaded_yet));
            }else if(DinnerArray[position+1]==null){
                DinnerTxt.setText(getResources().getString(R.string.nodata));
            }else{
                String DinnerData = DinnerArray[position+1]+"\n\n"+DinnerKcalArray[position+1]+" Kcal";
                DinnerTxt.setText(DinnerData);
            }
            container.addView(view);

            Log.i(LOG_TAG, "instantiateItem() [position: " + position + "]");

            // Return the View
            return view;
        }

        /**
         * Destroy the item from the {@link ViewPager}. In our case this is
         * simply removing the {@link View}.
         */
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
            Log.i(LOG_TAG, "destroyItem() [position: " + position + "]");
        }

    }

    private void loadMealTask(){
        if(NetCheck.isNetworkConnected()){
            final Handler mHandler = new Handler();
            new Thread()
            {

                public void run()
                {
                    mHandler.post(new Runnable(){

                        public void run()
                        {
                            // SRL.setRefreshing(true);
                        }
                    });
                    try{
                        LunchArray = MealLibrary.getMealNew("sen.go.kr", "B100000505", "4", "04", "2"); //Get Lunch Menu Date
                        LunchKcalArray = MealLibrary.getKcalNew("sen.go.kr", "B100000505", "4", "04", "2"); //Get Lunch Menu Kcal Value
                        DinnerArray = MealLibrary.getMealNew("sen.go.kr", "B100000505", "4", "04", "3"); //Get Dinner Menu Date
                        DinnerKcalArray = MealLibrary.getKcalNew("sen.go.kr", "B100000505", "4", "04", "3"); //Get Dinner Menu Kcal Value
                    }catch (Exception e){}

                    mHandler.post(new Runnable()
                    {
                        public void run()
                        {
                            mViewPager.setAdapter(new SamplePagerAdapter());
                            mSlidingTabLayout.setViewPager(mViewPager);
                            Log.d("MealLoadTadk","Data Loading Done");
                            if (mShareActionProvider != null ) {
                                mShareActionProvider.setShareIntent(createShareIntent(1));
                            } else {
                            }
                            //SRL.setRefreshing(false);
                            handler.sendEmptyMessage(0);
                        }
                    });

                }
            }.start();

        }else{
            Toast.makeText(MealActivity.this,
                    "급식정보를 불러오지 못하였습니다. WIFI또는 3G, LTE에 연결해주세요.", Toast.LENGTH_LONG).show();
            mViewPager.setAdapter(new SamplePagerAdapter());
            mSlidingTabLayout.setViewPager(mViewPager);
            if (mShareActionProvider != null ) {
                mShareActionProvider.setShareIntent(createShareIntent(1));
            } else {
            }
            //SRL.setRefreshing(false);
        }
    }

    private Intent createShareIntent(int pos) {
        //액션은 ACTION_SEND 로 합니다.
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        //Flag 를 설정해 줍니다. 공유하기 위해 공유에 사용할 다른 앱의 하나의 Activity 만 열고,
        //다시 돌아오면 열었던 Activity 는 꺼야 하기 때문에
        //FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET 로 해줍니다.
        shareIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
        //공유할 것의 형태입니다. 우리는 텍스트를 공유합니다.
        shareIntent.setType("text/plain");
        String mealData;
        try {
            mealData =
                    getResources().getString(R.string.lunch) + "\n"
                            + LunchArray[mViewPager.getCurrentItem()+1] + "\n\n"
                            + getResources().getString(R.string.dinner) + "\n"
                            + DinnerArray[mViewPager.getCurrentItem()+1] + "\n\n";
        }catch (Exception e){
            mealData = getResources().getString(R.string.nodata);
        }
        //보낼 데이터를 Extra 로 넣어줍니다.
        shareIntent.putExtra(Intent.EXTRA_TEXT,mealData);
        Log.d(LOG_TAG,"Creating Share Intent:"+mealData);
        return shareIntent;
    }

}

