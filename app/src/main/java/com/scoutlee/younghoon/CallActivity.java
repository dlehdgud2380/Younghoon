package com.scoutlee.younghoon;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class CallActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.call);

        ImageView imageView2 = (ImageView) findViewById(R.id.imageView2);
        imageView2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:02-986-2500"));
                startActivity(intent);
            }
        });

        ImageView iamgeView1 = (ImageView) findViewById(R.id.imageView1);
        iamgeView1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:02-945-0266"));
                startActivity(intent);
            }
        });
    }
}

