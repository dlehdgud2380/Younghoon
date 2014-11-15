package com.scoutlee.younghoon;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;

public class SplashActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        android.app.ActionBar actionBar = getActionBar();
        actionBar.hide();

        Handler hdl = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                // TODO ��� �����硫�����ㅽ�
                finish(); // activity 醫��
            }

        };
        hdl.sendEmptyMessageDelayed(0, 3000); // 3珥�� 硫��吏�蹂대�湲�    }

    }
}