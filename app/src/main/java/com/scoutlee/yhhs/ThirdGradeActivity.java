package com.scoutlee.yhhs;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ThirdGradeActivity extends ActionBarActivity {

    DataAdapter adapter;
    ArrayList<ListViewData> alist;
    private ListView list;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.thirdgrade);


        list = (ListView) findViewById(R.id.listView1);
        alist = new ArrayList<ListViewData>();
        adapter = new DataAdapter(this, alist);
        list.setAdapter(adapter);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Intent layoutTimetableImage = new Intent(getBaseContext(), TimeTableImage.class);
                        layoutTimetableImage.putExtra("name", "t1");
                        startActivity(layoutTimetableImage);
                        break;
                    case 1:
                        Intent layoutTimetableImage1 = new Intent(getBaseContext(), TimeTableImage.class);
                        layoutTimetableImage1.putExtra("name", "t2");
                        startActivity(layoutTimetableImage1);
                        break;
                    case 2:
                        Intent layoutTimetableImage2 = new Intent(getBaseContext(), TimeTableImage.class);
                        layoutTimetableImage2.putExtra("name", "t3");
                        startActivity(layoutTimetableImage2);
                        break;
                    case 3:
                        Intent layoutTimetableImage3 = new Intent(getBaseContext(), TimeTableImage.class);
                        layoutTimetableImage3.putExtra("name", "t4");
                        startActivity(layoutTimetableImage3);
                        break;
                    case 4:
                        Intent layoutTimetableImage4 = new Intent(getBaseContext(), TimeTableImage.class);
                        layoutTimetableImage4.putExtra("name", "t5");
                        startActivity(layoutTimetableImage4);
                        break;
                    case 5:
                        Intent layoutTimetableImage5 = new Intent(getBaseContext(), TimeTableImage.class);
                        layoutTimetableImage5.putExtra("name", "t6");
                        startActivity(layoutTimetableImage5);
                        break;
                    case 6:
                        Intent layoutTimetableImage6 = new Intent(getBaseContext(), TimeTableImage.class);
                        layoutTimetableImage6.putExtra("name", "t7");
                        startActivity(layoutTimetableImage6);
                        break;
                    case 7:
                        Intent layoutTimetableImage7 = new Intent(getBaseContext(), TimeTableImage.class);
                        layoutTimetableImage7.putExtra("name", "t8");
                        startActivity(layoutTimetableImage7);
                        break;
                    case 8:
                        Intent layoutTimetableImage8 = new Intent(getBaseContext(), TimeTableImage.class);
                        layoutTimetableImage8.putExtra("name", "t9");
                        startActivity(layoutTimetableImage8);
                        break;
                    case 9:
                        Intent layoutTimetableImage9 = new Intent(getBaseContext(), TimeTableImage.class);
                        layoutTimetableImage9.putExtra("name", "t10");
                        startActivity(layoutTimetableImage9);
                        break;
                    case 10:
                        Intent layoutTimetableImage10 = new Intent(getBaseContext(), TimeTableImage.class);
                        layoutTimetableImage10.putExtra("name", "t11");
                        startActivity(layoutTimetableImage10);
                        break;
                    case 11:
                        Intent layoutTimetableImage11 = new Intent(getBaseContext(), TimeTableImage.class);
                        layoutTimetableImage11.putExtra("name", "t12");
                        startActivity(layoutTimetableImage11);
                        break;
                    case 12:
                        Intent layoutTimetableImage12 = new Intent(getBaseContext(), TimeTableImage.class);
                        layoutTimetableImage12.putExtra("name", "t13");
                        startActivity(layoutTimetableImage12);
                        break;
                    case 13:
                        Intent layoutTimetableImage13 = new Intent(getBaseContext(), TimeTableImage.class);
                        layoutTimetableImage13.putExtra("name", "t14");
                        startActivity(layoutTimetableImage13);
                        break;

                }
            }
        });


        adapter.add(new ListViewData(getApplicationContext(), "학년 1반",
                R.drawable.thirdgrade));
        adapter.add(new ListViewData(getApplicationContext(), "학년 2반",
                R.drawable.thirdgrade));
        adapter.add(new ListViewData(getApplicationContext(), "학년 3반",
                R.drawable.thirdgrade));
        adapter.add(new ListViewData(getApplicationContext(), "학년 4반",
                R.drawable.thirdgrade));
        adapter.add(new ListViewData(getApplicationContext(), "학년 5반",
                R.drawable.thirdgrade));
        adapter.add(new ListViewData(getApplicationContext(), "학년 6반",
                R.drawable.thirdgrade));
        adapter.add(new ListViewData(getApplicationContext(), "학년 7반",
                R.drawable.thirdgrade));
        adapter.add(new ListViewData(getApplicationContext(), "학년 8반",
                R.drawable.thirdgrade));
        adapter.add(new ListViewData(getApplicationContext(), "학년 9반",
                R.drawable.thirdgrade));
        adapter.add(new ListViewData(getApplicationContext(), "학년 10반",
                R.drawable.thirdgrade));
        adapter.add(new ListViewData(getApplicationContext(), "학년 11반",
                R.drawable.thirdgrade));
        adapter.add(new ListViewData(getApplicationContext(), "학년 12반",
                R.drawable.thirdgrade));
        adapter.add(new ListViewData(getApplicationContext(), "학년 13반",
                R.drawable.thirdgrade));
        adapter.add(new ListViewData(getApplicationContext(), "학년 14반",
                R.drawable.thirdgrade));

    }


    private class DataAdapter extends ArrayAdapter<ListViewData> {

        private LayoutInflater mInflater;

        public DataAdapter(Context context, ArrayList<ListViewData> object) {

            super(context, 0, object);
            mInflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        }

        @Override
        public View getView(int position, View v, ViewGroup parent) {
            View view = null;

            if (v == null) {

                view = mInflater.inflate(R.layout.listviewitem, null);
            } else {
                view = v;
            }

            final ListViewData data = this.getItem(position);

            if (data != null) {

                TextView tv = (TextView) view.findViewById(R.id.textView1);
                tv.setText(data.getLabel());

                ImageView iv = (ImageView) view.findViewById(R.id.imageView1);

                iv.setImageResource(data.getData2());
            }
            return view;
        }

    }


    class ListViewData {

        private String m_szLabel;
        private int m_szData2;

        public ListViewData(Context context, String p_szLabel, int p_szData2) {

            m_szLabel = p_szLabel;
            m_szData2 = p_szData2;
        }

        public String getLabel() {
            return m_szLabel;
        }


        public int getData2() {
            return m_szData2;
        }
    }
}
