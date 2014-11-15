package com.scoutlee.younghoon;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class TimeTableImage extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.timetableimage);


        ImageView imageView01 = (ImageView) findViewById(R.id.timetableImageChangeable);
        LinearLayout linearLayout01 = (LinearLayout) findViewById(R.id.selectTimetableLayout);


        Bundle bundle = getIntent().getExtras();
        String resName = bundle.getString("name");
        String name = "@drawable/" + resName;
        String defPackage = this.getPackageName();
        int id = getResources().getIdentifier(name, "drawable", defPackage);
        Drawable drawable = this.getResources().getDrawable(id);

        imageView01.setImageDrawable(drawable);

        final String finalResName = resName;


        linearLayout01.setOnClickListener(
                new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        TimeTableDB db = new TimeTableDB();
                        db.inputTable(finalResName);
                        Toast.makeText(getBaseContext(), "대표 시간표로 지정되었습니다 \n\n" +
                                "2번째 메인화면 시간표탭에서 확인하실 수 있습니다", Toast.LENGTH_LONG).show();
                    }
                });

    }

}

