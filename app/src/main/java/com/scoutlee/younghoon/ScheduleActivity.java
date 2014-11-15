package com.scoutlee.younghoon;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ScheduleActivity extends ActionBarActivity {

    /*
     * PagerAdapter을 생성합니다.
     * PagerAdapter는 android.support.v4.app.FragmentPagerAdapter
     * 를 상속받습니다. FragmentPagerAdapter는 v4 libs에 추가된 내용입니다.
     */
    SectionsPagerAdapter mSectionsPagerAdapter;

    //android.support.v4.view.ViewPager의 Custom Layout
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scheduleactivity);

        mSectionsPagerAdapter = new SectionsPagerAdapter(
                getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);

    }

    //각각의 Fragment를 만들게 된다.
    public static class DummySectionFragment extends Fragment {
        public static final String ARG_SECTION_NUMBER = "section_number";

        public DummySectionFragment() {
        }

        /* onCreateView를 통해 화면에 보여질 내용을 정리하게 된다.
         * XML을 통해서 직접 작성할 수도 있다.
         * 그리고 각각 페이지의 내용이 다르다면 각각의 Fragment와 별도의 XML을 가지면 된다.
         */
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            TextView textView = new TextView(getActivity());
            textView.setGravity(Gravity.CENTER);
            textView.setText(Integer.toString(getArguments().getInt(
                    ARG_SECTION_NUMBER)));
            return textView;
        }
    }

    //PagerAdapter는 Fragment를 통해 각각의 페이지의 이름과 Fragment를 정의
    //이 페이지는 xml의 android.support.v4.view.ViewPager에 보여지게 된다.
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        //각 position의 값에 따라서 각 화면을 정의한다.
        //여기서는 Bundle를 이용하여 position + 1한 값을 전송
        //Fragment의 View에서 1,2,3을 표시하게 된다.

        @Override
        public Fragment getItem(int arg0) {
            Bundle data = new Bundle();
            switch (arg0) {

                /** tab1 is selected */
                case 0:
                    March march = new March();
                    return march;
                case 1:
                    April april = new April();
                    return april;
                case 2:
                    May may = new May();
                    return may;
                case 3:
                    June june = new June();
                    return june;
                case 4:
                    July july = new July();
                    return july;
                case 5:
                    August agust = new August();
                    return agust;
                case 6:
                    Setember setember = new Setember();
                    return setember;
                case 7:
                    October october = new October();
                    return october;
                case 8:
                    November november = new November();
                    return november;
                case 9:
                    December December = new December();
                    return December;
                case 10:
                    January january = new January();
                    return january;
                case 11:
                    Febrary febrary = new Febrary();
                    return febrary;
            }
            return null;
        }

        //Fragment에 사용될 전체 페이지 수를 정의한다. 여기서는 3페이지
        @Override
        public int getCount() {
            return 12;
        }

        /*
         * getPageTitle을 정의한다. 이 부분은 XML의
         * android.support.v4.view.PagerTitleStrip에 뿌려진다.
         * 제목은 모두 대문자로 변형되어 출력되고, String에 저장되어 있다.
         */
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return getString(R.string.title_section3).toUpperCase();
                case 1:
                    return getString(R.string.title_section4).toUpperCase();
                case 2:
                    return getString(R.string.title_section5).toUpperCase();
                case 3:
                    return getString(R.string.title_section6).toUpperCase();
                case 4:
                    return getString(R.string.title_section7).toUpperCase();
                case 5:
                    return getString(R.string.title_section8).toUpperCase();
                case 6:
                    return getString(R.string.title_section9).toUpperCase();
                case 7:
                    return getString(R.string.title_section10).toUpperCase();
                case 8:
                    return getString(R.string.title_section11).toUpperCase();
                case 9:
                    return getString(R.string.title_section12).toUpperCase();
                case 10:
                    return getString(R.string.title_section1).toUpperCase();
                case 11:
                    return getString(R.string.title_section2).toUpperCase();

            }
            return null;
        }
    }
}

