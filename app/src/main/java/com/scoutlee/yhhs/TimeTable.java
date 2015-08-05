package com.scoutlee.yhhs;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import java.util.ArrayList;

public class TimeTable extends ActionBarActivity {

    DataAdapter adapter;
    ArrayList<ListViewData> alist;
    private ListView list;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.timetable);


        list = (ListView) findViewById(R.id.listView1);
        alist = new ArrayList<ListViewData>();
        adapter = new DataAdapter(this, alist);
        list.setAdapter(adapter);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Intent intent0 = new Intent(TimeTable.this, FirstGradeActivity.class);
                        startActivity(intent0);
                        break;
                    case 1:
                        Intent intent1 = new Intent(TimeTable.this, SecondGradeActivity.class);
                        startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2 = new Intent(TimeTable.this, ThirdGradeActivity.class);
                        startActivity(intent2);
                        break;
                    case 3:
                        TimeTableDB db = new TimeTableDB();
                        db.deleteTimetableDatabase();
                        Toast.makeText(getBaseContext(), "대표 시간표 설정이 초기화 되었습니다", Toast.LENGTH_LONG).show();
                }
            }
        });


        adapter.add(new ListViewData(getApplicationContext(), "학년",
                R.drawable.firstgrade));
        adapter.add(new ListViewData(getApplicationContext(), "학년",
                R.drawable.secondgrade));
        adapter.add(new ListViewData(getApplicationContext(), "학년",
                R.drawable.thirdgrade));
        adapter.add(new ListViewData(getApplicationContext(), "    시간표 초기화",
                R.drawable.undo));

    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
            //Intent refresh = new Intent(this, MainActivity.class);
            //startActivity(refresh);
            this.finish();
        }
        return super.dispatchKeyEvent(event);
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

	    







