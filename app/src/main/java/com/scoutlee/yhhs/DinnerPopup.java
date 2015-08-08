package com.scoutlee.yhhs;

import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

import toast.library.meal.MealLibrary;


public class DinnerPopup extends ActionBarActivity {


    private final Handler handler = new Handler() {
    };

    TextView dinner;
    String[] dinnerstring = new String[7];
    ConnectivityManager cManager;
    NetworkInfo wifi;
    NetworkInfo mobile;

    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dinnerpopup);

        ActionBar actionBar = getSupportActionBar();

        cManager = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        mobile = cManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        wifi = cManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);

        dinner = (TextView) findViewById(R.id.dinnerinfo);

        final Calendar c = Calendar.getInstance();
        final int DayOfWeek = c.get(Calendar.DAY_OF_WEEK); // 일요일(1), 월요일(2), ..., 토요일(7)

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
                        dinnerstring = MealLibrary.getMealNew("sen.go.kr", "B100000505", "4", "04", "3"); //Get Dinner Menu Date

                        mHandler.post(new Runnable() {
                            @Override
                            public void run() {

                                switch(DayOfWeek) {

                                    case 0 : dinner.setText("오늘은 급식이 없습니다");
                                        break;
                                    case 1 : dinner.setText("오늘은 급식이 없습니다");
                                        break;
                                    case 2 :
                                        if(dinnerstring[1] == null){
                                            dinner.setText("오늘은 급식이 없습니다.");
                                        }else {
                                            dinner.setText("\n" + dinnerstring[1]);
                                        }
                                        break;
                                    case 3 :
                                        if(dinnerstring[2] == null){
                                            dinner.setText("오늘은 급식이 없습니다.");
                                        }else {
                                            dinner.setText("\n" + dinnerstring[2]);
                                        }
                                        break;
                                    case 4 :
                                        if(dinnerstring[3] == null){
                                            dinner.setText("오늘은 급식이 없습니다.");
                                        }else {
                                            dinner.setText("\n" + dinnerstring[3]);
                                        }
                                        break;
                                    case 5 :
                                        if(dinnerstring[4] == null){
                                            dinner.setText("오늘은 급식이 없습니다.");
                                        }else {
                                            dinner.setText("\n" + dinnerstring[4]);
                                        }
                                        break;
                                    case 6 :
                                        if(dinnerstring[5] == null){
                                            dinner.setText("오늘은 급식이 없습니다.");
                                        }else {
                                            dinner.setText("\n" + dinnerstring[5]);
                                        }
                                        break;
                                    case 7 : dinner.setText("오늘은 급식이 없습니다");
                                        break;
                                }
                            }

                        });

                    } catch (Exception e) {
                        Toast.makeText(getApplicationContext(), "급식을 불러오는 데 문제가 발생하였습니다. 뒤로가기 버튼을 눌러주세요.", Toast.LENGTH_LONG).show();
                    }

                }
            }.start();

        } else {
            Toast.makeText(getApplicationContext(), "급식정보를 불러오지 못하였습니다. WIFI또는 3G, LTE에 연결해주세요.", Toast.LENGTH_LONG).show();
        }

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }


}
