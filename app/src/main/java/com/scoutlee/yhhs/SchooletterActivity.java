package com.scoutlee.yhhs;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

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

    private NetworkChecker Networkcheck;
    private ProgressDialog progressDialog;
    private ArrayList<String> titlearray;
    private ArrayList<String> titleherfarray;
    private ArrayList<String> datearray;
    private ArrayList<String> datetdarray;
    private ArrayList<String> writerarray;
    private ArrayList<String> writertdarray;
    private SchooletterAdepter adepter;

    private AdapterView.OnItemClickListener GoToWebPage = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View clickedView, int pos, long id) {
            String herfitem = titleherfarray.get(pos);
            String titleITEM = titlearray.get(pos);
            String writerITEM = writerarray.get(pos);
            String dateITEM = datearray.get(pos);
            Intent intent = new Intent(SchooletterActivity.this, SchooletterView.class);
            intent.putExtra("URL", herfitem);
            intent.putExtra("title", titleITEM);
            intent.putExtra("writer", writerITEM);
            intent.putExtra("date", dateITEM);
            startActivity(intent);
            //Intent gotowebpage = new Intent(Intent.ACTION_VIEW);
            //gotowebpage.setData(Uri.parse(herfitem));
            //startActivity(gotowebpage);
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.schooletter);

        final ListView listview = (ListView) findViewById(R.id.listView);

        try {
            Networkcheck = new NetworkChecker(SchooletterActivity.this);
            if (Networkcheck.isNetworkConnected()) {


                final Handler mHandler = new Handler();
                new Thread() {

                    @Override
                    public void run() {
                        mHandler.post(new Runnable() {

                            @Override
                            public void run() {
                                String loading = getString(R.string.loading);
                                progressDialog = ProgressDialog.show(SchooletterActivity.this, "", loading, true);
                                Toast.makeText(getApplicationContext(), "최근으로 부터 15개의 정보", Toast.LENGTH_LONG).show();
                            }
                        });

                        try {
                            titlearray = new ArrayList<String>();
                            titleherfarray = new ArrayList<String>();
                            datearray = new ArrayList<String>();
                            datetdarray = new ArrayList<String>();
                            writerarray = new ArrayList<String>();
                            writertdarray = new ArrayList<String>();
                            Document doc = Jsoup.connect("http://www.younghoon.hs.kr/normal/board.do?bcfNo=515804").get();
                            Elements rawtitledata = doc.select(".title a");
                            Elements rawdatedata = doc.select("td:eq(3)");
                            Elements rawwriterdata = doc.select("td:eq(2)");
                            String titlestring = rawtitledata.toString();
                            String datestring = rawdatedata.toString();
                            String writerstring = rawwriterdata.toString();
                            Log.i("Notices", "Parsed Strings" + titlestring);

                            for (Element el : rawtitledata) {
                                String titlherfedata = el.attr("href");
                                //a 태그 안에서 링크거는건 href뽑게 한다.//
                                String titledata = el.text();
                                titleherfarray.add("http://www.younghoon.hs.kr/normal/" + titlherfedata);
                                titlearray.add(titledata);
                            }

                            for (Element el : rawdatedata) {
                                String datetddata = el.attr("td");
                                String datedata = el.text();
                                datearray.add(datedata);
                            }

                            for (Element el : rawwriterdata) {
                                String writertddata = el.attr("td");
                                String writerdata = el.text();
                                writerarray.add(writerdata);
                            }

                        } catch (IOException e) {
                            e.printStackTrace();
                            Toast.makeText(getApplicationContext(), "가정통신문을 불러오지 못하였습니다. \n해결방법1: 위 아래로 댕겨서 새로고침\n해결방법2: wifi또는 모바일네트워크에 연결", Toast.LENGTH_LONG).show();

                        }


                        mHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                progressDialog.dismiss();

                                adepter = new SchooletterAdepter(SchooletterActivity.this, titlearray, datearray, writerarray);
                                listview.setAdapter(adepter);

                                listview.setOnItemClickListener(GoToWebPage);
                                handler.sendEmptyMessage(0);
                            }
                        });

                    }
                }.start();

            } else {
                Toast.makeText(getApplicationContext(), "가정통신문을 불러오지 못하였습니다. \n wifi 또는 데이터네트워크를 켜신후 \n새로고침버튼을 눌러주세요.", Toast.LENGTH_LONG).show();
            }
        }catch (Exception e){
        }
    }


}
