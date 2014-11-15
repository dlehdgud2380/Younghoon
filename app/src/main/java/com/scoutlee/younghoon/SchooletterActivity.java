package com.scoutlee.younghoon;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class SchooletterActivity extends ActionBarActivity {
    private final Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {

        }
    };
    private ProgressDialog progressDialog;
    private ArrayList<String> titlearray;
    private ArrayList<String> titleherfarray;
    private ArrayAdapter<String> adapter;
    private AdapterView.OnItemClickListener GoToWebPage = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View clickedView, int pos, long id) {
            String herfitem = titleherfarray.get(pos);
            Intent gotowebpage = new Intent(Intent.ACTION_VIEW);
            gotowebpage.setData(Uri.parse(herfitem));
            startActivity(gotowebpage);
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.schooletter);

        final ListView listview = (ListView) findViewById(R.id.listView);

        final Handler mHandler = new Handler();
        new Thread() {

            @Override
            public void run() {
                mHandler.post(new Runnable() {

                    @Override
                    public void run() {
                        String loading = getString(R.string.loading);
                        progressDialog = ProgressDialog.show(SchooletterActivity.this, "", loading, true);
                    }
                });

                try {
                    titlearray = new ArrayList<String>();
                    titleherfarray = new ArrayList<String>();
                    Document doc = Jsoup.connect("http://www.younghoon.hs.kr/normal/board.do?bcfNo=515804").get();
                    Elements rawdata = doc.select(".title a");
                    String titlestring = rawdata.toString();
                    Log.i("Notices", "Parsed Strings" + titlestring);

                    for (Element el : rawdata) {
                        String titlherfedata = el.attr("href");
                        //a 태그 안에서 링크거는건 href뽑게 한다.//
                        String titledata = el.text();
                        titleherfarray.add("http://www.younghoon.hs.kr/normal/" + titlherfedata);
                        titlearray.add(titledata);
                    }
                    Log.i("Notices", "Parsed Link Array Strings" + titleherfarray);
                    Log.i("Notices", "Parsed Array Strings" + titlearray);


                } catch (IOException e) {
                    e.printStackTrace();

                }


                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        progressDialog.dismiss();

                        adapter = new ArrayAdapter<String>(SchooletterActivity.this,
                                R.layout.simplelistitem, titlearray);
                        listview.setAdapter(adapter);
                        listview.setOnItemClickListener(GoToWebPage);
                        handler.sendEmptyMessage(0);
                    }
                });

            }
        }.start();

    }


}
