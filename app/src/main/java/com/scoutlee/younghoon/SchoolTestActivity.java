package com.scoutlee.younghoon;

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

public class SchoolTestActivity extends ActionBarActivity {

    DataAdapter adapter;
    ArrayList<ListViewData> alist;
    private ListView list;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.schooltest);


        list = (ListView) findViewById(R.id.listView1);
        alist = new ArrayList<ListViewData>();
        adapter = new DataAdapter(this, alist);
        list.setAdapter(adapter);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Intent intent0 = new Intent(SchoolTestActivity.this, FirstGradeTestActivity.class);
                        startActivity(intent0);
                        break;
                    case 1:
                        Intent intent1 = new Intent(SchoolTestActivity.this, SecondGradeTestActivity.class);
                        startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2 = new Intent(SchoolTestActivity.this, ThirdGradeTestActivity.class);
                        startActivity(intent2);
                        break;
                }
            }
        });


        adapter.add(new ListViewData(getApplicationContext(), "학년",
                R.drawable.firstgrade));
        adapter.add(new ListViewData(getApplicationContext(), "학년",
                R.drawable.secondgrade));
        adapter.add(new ListViewData(getApplicationContext(), "학년",
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
