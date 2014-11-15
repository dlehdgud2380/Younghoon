package com.scoutlee.younghoon;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;

import toast.library.meal.MealLibrary;


public class MainTab1 extends Fragment implements OnClickListener {


    private final Handler handler = new Handler() {
    };
    TextView lunchmon;
    TextView lunchtue;
    TextView lunchwed;
    TextView lunchthu;
    TextView lunchfri;
    TextView dinnermon;
    TextView dinnertue;
    TextView dinnerwed;
    TextView dinnerthu;
    TextView dinnerfri;
    String[] lunchstring = new String[7];
    String[] dinnerstring = new String[7];

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.maintab1, container, false);

        ImageView imageview1 = (ImageView) v.findViewById(R.id.imageView1);
        ImageView imageview2 = (ImageView) v.findViewById(R.id.imageView2);
        ImageView imageview3 = (ImageView) v.findViewById(R.id.imageView3);
        ImageView imageview4 = (ImageView) v.findViewById(R.id.imageView4);

        lunchmon = (TextView) v.findViewById(R.id.lunchmon);
        lunchtue = (TextView) v.findViewById(R.id.lunchtue);
        lunchwed = (TextView) v.findViewById(R.id.lunchwed);
        lunchthu = (TextView) v.findViewById(R.id.lunchthu);
        lunchfri = (TextView) v.findViewById(R.id.lunchfri);
        dinnermon = (TextView) v.findViewById(R.id.dinnermon);
        dinnertue = (TextView) v.findViewById(R.id.dinnertue);
        dinnerwed = (TextView) v.findViewById(R.id.dinnerwed);
        dinnerthu = (TextView) v.findViewById(R.id.dinnerthu);
        dinnerfri = (TextView) v.findViewById(R.id.dinnerfri);

        imageview1.setOnClickListener(this);
        imageview2.setOnClickListener(this);
        imageview3.setOnClickListener(this);
        imageview4.setOnClickListener(this);

        final TextView textView2 = (TextView) v.findViewById(R.id.textView2);
        final Calendar c = Calendar.getInstance();
        int Year = c.get(Calendar.YEAR);
        int Month = c.get(Calendar.MONTH) + 1; // 1월(0), 2월(1), ..., 12월(11)
        int Day = c.get(Calendar.DAY_OF_MONTH);
        int DayOfWeek = c.get(Calendar.DAY_OF_WEEK); // 일요일(1), 월요일(2), ..., 토요일(7)

        String stringDayOfWeek[] = {"", "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};// 일요일이 1이고 stringDayOfWeek[0]은 없으니 비워둡니다.

        String stringDayAndTimeFormat = String.format("%d.%d.%d." + stringDayOfWeek[DayOfWeek] + "", Year, Month, Day);
        textView2.setText(stringDayAndTimeFormat);


        final Handler mHandler = new Handler();
        new Thread() {

            @Override
            public void run() {
                mHandler.post(new Runnable() {

                    @Override
                    public void run() {
                    }
                });
                lunchstring = MealLibrary.getMealNew("sen.go.kr", "B100000505", "4", "04", "2"); //Get Lunch Menu Date
                dinnerstring = MealLibrary.getMealNew("sen.go.kr", "B100000505", "4", "04", "3"); //Get Dinner Menu Date

                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        lunchmon.setText(getString(R.string.monday) + ":\n\n" + lunchstring[1]);
                        lunchtue.setText(getString(R.string.tuesday) + ":\n\n" + lunchstring[2]);
                        lunchwed.setText(getString(R.string.wednsday) + ":\n\n" + lunchstring[3]);
                        lunchthu.setText(getString(R.string.thursday) + ":\n\n" + lunchstring[4]);
                        lunchfri.setText(getString(R.string.friday) + ":\n\n" + lunchstring[5]);

                        dinnermon.setText(getString(R.string.monday) + ":\n\n" + dinnerstring[1]);
                        dinnertue.setText(getString(R.string.tuesday) + ":\n\n" + dinnerstring[2]);
                        dinnerwed.setText(getString(R.string.wednsday) + ":\n\n" + dinnerstring[3]);
                        dinnerthu.setText(getString(R.string.thursday) + ":\n\n" + dinnerstring[4]);
                        dinnerfri.setText(getString(R.string.friday) + ":\n\n" + dinnerstring[5]);
                        handler.sendEmptyMessage(0);
                    }
                });

            }
        }.start();

        return v;
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.imageView1:
                Intent intent = new Intent(getActivity(), SchooletterActivity.class);
                startActivity(intent);
                break;

            case R.id.imageView2:
                Intent intent1 = new Intent(getActivity(), CallActivity.class);
                startActivity(intent1);
                break;

            case R.id.imageView3:
                Intent intent2 = new Intent(getActivity(), ScheduleActivity.class);
                startActivity(intent2);
                break;

            case R.id.imageView4:
                Intent intent3 = new Intent(getActivity(), TimeTable.class);
                startActivity(intent3);
                break;

        }
    }

}