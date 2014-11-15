package com.scoutlee.younghoon;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

public class Appinfo1 extends Fragment implements OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.appinfo1, container, false);

        //ImageView imageview2 = (ImageView) v.findViewById(R.id.imageView2);
        //ImageView imageview3 = (ImageView) v.findViewById(R.id.imageView3);
        //ImageView imageview4 = (ImageView) v.findViewById(R.id.imageView4);

        //imageview2.setOnClickListener(this);
        //imageview3.setOnClickListener(this);
        //imageview4.setOnClickListener(this);


        return v;

    }

    @Override
    public void onClick(View v) {
    }

}