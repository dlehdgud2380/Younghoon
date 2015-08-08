package com.scoutlee.yhhs;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import toast.library.meal.MealLibrary;

import java.util.Calendar;


@SuppressLint("ValidFragment")
public class MainTab1 extends Fragment implements OnClickListener {

    private final Handler handler = new Handler() {
    };

    TextView lunch;
    String[] lunchstring = new String[7];
    String[] dinnerstring = new String[7];
    ConnectivityManager cManager;
    NetworkInfo wifi;
    NetworkInfo mobile;


    Context mContext;

    public MainTab1(Context context) {
        mContext = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.maintab1, container, false);

        cManager = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        mobile = cManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        wifi = cManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);


        ImageView imageview1 = (ImageView) v.findViewById(R.id.imageView1);
        ImageView imageview2 = (ImageView) v.findViewById(R.id.imageView2);
        ImageView imageview3 = (ImageView) v.findViewById(R.id.imageView3);
        ImageView imageview4 = (ImageView) v.findViewById(R.id.imageView4);
        ImageView imageview5 = (ImageView) v.findViewById(R.id.imageView5);
        LinearLayout linearLayout = (LinearLayout) v.findViewById(R.id.container);

        lunch = (TextView) v.findViewById(R.id.lunchinfo);

        /*lunchmon = (TextView) v.findViewById(R.id.lunchmon);
        lunchtue = (TextView) v.findViewById(R.id.lunchtue);
        lunchwed = (TextView) v.findViewById(R.id.lunchwed);
        lunchthu = (TextView) v.findViewById(R.id.lunchthu);
        lunchfri = (TextView) v.findViewById(R.id.lunchfri);
        dinnermon = (TextView) v.findViewById(R.id.dinnermon);
        dinnertue = (TextView) v.findViewById(R.id.dinnertue);
        dinnerwed = (TextView) v.findViewById(R.id.dinnerwed);
        dinnerthu = (TextView) v.findViewById(R.id.dinnerthu);
        dinnerfri = (TextView) v.findViewById(R.id.dinnerfri);*/

        imageview1.setOnClickListener(this);
        imageview2.setOnClickListener(this);
        imageview3.setOnClickListener(this);
        imageview4.setOnClickListener(this);
        imageview5.setOnClickListener(this);
        linearLayout.setOnClickListener(this);

        final TextView textView2 = (TextView) v.findViewById(R.id.textView2);
        final Calendar c = Calendar.getInstance();
        int Year = c.get(Calendar.YEAR);
        int Month = c.get(Calendar.MONTH) + 1; // 1월(0), 2월(1), ..., 12월(11)
        final int Day = c.get(Calendar.DAY_OF_MONTH);
        final int DayOfWeek = c.get(Calendar.DAY_OF_WEEK); // 일요일(1), 월요일(2), ..., 토요일(7)

        String stringDayOfWeek[] = {"", "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};// 일요일이 1이고 stringDayOfWeek[0]은 없으니 비워둡니다.

        String stringDayAndTimeFormat = String.format("%d.%d.%d " + stringDayOfWeek[DayOfWeek] + "", Year, Month, Day);
        textView2.setText(stringDayAndTimeFormat);


        if (mobile.isConnected() || wifi.isConnected()) {
            final Handler mHandler = new Handler();
            new Thread() {

                @Override
                public void run() {
                    mHandler.post(new Runnable() {

                        @Override
                        public void run() {
                        }
                    });

                    try {
                        lunchstring = MealLibrary.getMealNew("sen.go.kr", "B100000505", "4", "04", "2"); //Get Lunch Menu Date
                        dinnerstring = MealLibrary.getMealNew("sen.go.kr", "B100000505", "4", "04", "3"); //Get Dinner Menu Date

                        mHandler.post(new Runnable() {
                            @Override
                            public void run() {

                                switch(DayOfWeek) {

                                    case 0 : lunch.setText("오늘은 급식이 없습니다");
                                        break;
                                    case 1 : lunch.setText("오늘은 급식이 없습니다");
                                        break;
                                    case 2 :
                                        if(lunchstring[1] == null) {
                                            lunch.setText("오늘은 급식이 없습니다.");
                                        } else {
                                            lunch.setText("\n" + lunchstring[1]);
                                        }
                                        break;
                                    case 3 :
                                        if(lunchstring[2] == null) {
                                            lunch.setText("오늘은 급식이 없습니다.");
                                        } else {
                                            lunch.setText("\n" + lunchstring[2]);
                                        }
                                        break;
                                    case 4 :
                                        if(lunchstring[3] == null) {
                                            lunch.setText("오늘은 급식이 없습니다.");
                                        } else {
                                            lunch.setText("\n" + lunchstring[3]);
                                        }
                                        break;
                                    case 5 :
                                        if(lunchstring[4] == null) {
                                            lunch.setText("오늘은 급식이 없습니다.");
                                        } else {
                                            lunch.setText("\n" + lunchstring[4]);
                                        }
                                        break;
                                    case 6 :
                                        if(lunchstring[5] == null) {
                                            lunch.setText("오늘은 급식이 없습니다.");
                                        } else {
                                            lunch.setText("\n" + lunchstring[5]);
                                        }
                                        break;
                                    case 7 : lunch.setText("오늘은 급식이 없습니다");
                                        break;

                                    /*dinnermon.setText(getString(R.string.monday) + ":\n\n" + dinnerstring[1]);
                                    dinnertue.setText(getString(R.string.tuesday) + ":\n\n" + dinnerstring[2]);
                                    dinnerwed.setText(getString(R.string.wednsday) + ":\n\n" + dinnerstring[3]);
                                    dinnerthu.setText(getString(R.string.thursday) + ":\n\n" + dinnerstring[4]);
                                    dinnerfri.setText(geif(lunchstring == null)tString(R.string.friday) + ":\n\n" + dinnerstring[5]);*/
                                }
                            }

                        });

                    } catch (Exception e) {
                        Toast.makeText(getActivity(), "급식을 불러오는 데 문제가 발생하였습니다. 뒤로가기 버튼을 눌러주세요.", Toast.LENGTH_LONG).show();

                    }

                }
            }.start();

        } else {
            Toast.makeText(getActivity(), "급식정보를 불러오지 못하였습니다. WIFI또는 3G, LTE에 연결해주세요.", Toast.LENGTH_LONG).show();
            lunch.setText("급식불러오기 오류!");
        }

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

            case R.id.imageView5:
                Intent intent4 = new Intent(getActivity(), DinnerPopup.class);
                startActivity(intent4);
                break;

            case R.id.container:
                Intent intent5 = new Intent(getActivity(), MealActivity.class);
                startActivity(intent5);
                break;

        }

    }


}