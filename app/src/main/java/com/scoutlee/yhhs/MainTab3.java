package com.scoutlee.yhhs;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

@SuppressLint("ValidFragment")
public class MainTab3 extends Fragment implements OnClickListener {

    Context mContext;

    public MainTab3(Context context) {
        mContext = context;
    }

    public MainTab3() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.maintab3, null);

        ImageView imageview1 = (ImageView) v.findViewById(R.id.imageView1);
        ImageView imageview2 = (ImageView) v.findViewById(R.id.imageView2);
        ImageView imageview3 = (ImageView) v.findViewById(R.id.imageView3);
        ImageView imageview4 = (ImageView) v.findViewById(R.id.imageView4);
        ImageView imageview5 = (ImageView) v.findViewById(R.id.imageView5);
        ImageView imageview6 = (ImageView) v.findViewById(R.id.imageView6);
        ImageView imageView8 = (ImageView) v.findViewById(R.id.imageView8);

        TimeTableDB db = new TimeTableDB();

        String resName = db.outputTable();
        String name = null;
        Drawable drawable = null;
        int id = 0;

        try {
            if (resName.equals("")) {

            } else {
                name = "@drawable/" + resName;
                id = getResources().getIdentifier(name, "drawable", "com.scoutlee.yhhs");
                drawable = this.getResources().getDrawable(id);
                imageView8.setImageDrawable(drawable);
            }
        } catch (Exception e) {
            Toast.makeText(getActivity(), "시간표 이미지를 불러오는데 문제가 발생했습니다\n 재실행 해주세요", Toast.LENGTH_LONG).show();
        }

        imageview1.setOnClickListener(this);
        imageview2.setOnClickListener(this);
        imageview3.setOnClickListener(this);
        imageview4.setOnClickListener(this);
        imageview5.setOnClickListener(this);
        imageview6.setOnClickListener(this);
        imageView8.setOnClickListener(this);


        return v;

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.imageView1:
                Intent intent = new Intent(getActivity(), InfoActivity.class);
                startActivity(intent);
                break;

            case R.id.imageView2:
                Intent intent2 = new Intent(getActivity(), AppInfoActivity.class);
                startActivity(intent2);
                break;

            case R.id.imageView3:
                Intent intent3 = new Intent(getActivity(), SchoolTestActivity.class);
                startActivity(intent3);
                break;

            case R.id.imageView4:
                Intent intent4 = new Intent(getActivity(), WebActivity.class);
                startActivity(intent4);
                break;

            case R.id.imageView5:
                Intent intent5 = new Intent(getActivity(), CaculatorActivity.class);
                startActivity(intent5);
                break;

            case R.id.imageView6:
                Uri uri = Uri.parse("https://after.younghoon.hs.kr:50214/sugang/regi/login.php");
                Intent intent6 = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent6);
                break;

            case R.id.imageView8:
                Intent intent7 = new Intent(getActivity(), TimeTable.class);
                startActivity(intent7);
                break;


        }


    }

}