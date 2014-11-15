package com.scoutlee.younghoon;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class December extends Fragment {

    DataAdapter adapter;
    ArrayList<ScheduleListViewData> alist;
    private ListView listview;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.december, container, false);
        listview = (ListView) v.findViewById(R.id.listView1);
        alist = new ArrayList<ScheduleListViewData>();
        adapter = new DataAdapter(getActivity(), alist);
        listview.setAdapter(adapter);

        adapter.add(new ScheduleListViewData(getActivity(), "2학기 인성실천 우수학생 추천",
                "12/1~12/5"));
        adapter.add(new ScheduleListViewData(getActivity(), "제5회영훈진로진학아카데미",
                "12/2~12/3"));
        adapter.add(new ScheduleListViewData(getActivity(), "수능성적발표일",
                "12/3"));
        adapter.add(new ScheduleListViewData(getActivity(), "안전점검의날",
                "12/4"));
        adapter.add(new ScheduleListViewData(getActivity(), "충격과 공포의 기말고사(1,2)",
                "12/16~12/19"));
        adapter.add(new ScheduleListViewData(getActivity(), "겨울방학 방과후 온라인신청",
                "12/20"));
        adapter.add(new ScheduleListViewData(getActivity(), "인문학특강",
                "12/23"));
        adapter.add(new ScheduleListViewData(getActivity(), "사이버보안진단의 날",
                "12/24"));
        adapter.add(new ScheduleListViewData(getActivity(), "서버 네트워크 점검",
                "12/24"));
        adapter.add(new ScheduleListViewData(getActivity(), "성탄절",
                "12/25"));
        adapter.add(new ScheduleListViewData(getActivity(), "영훈토론대회",
                "12/29"));
        adapter.add(new ScheduleListViewData(getActivity(), "겨울방학식 올ㅋ",
                "12/31"));


        return v;
    }

    private class DataAdapter extends ArrayAdapter<ScheduleListViewData> {

        private LayoutInflater mInflater;

        public DataAdapter(Context context, ArrayList<ScheduleListViewData> object) {

            super(context, 0, object);
            mInflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        }

        @Override
        public View getView(int position, View v, ViewGroup parent) {
            View view = null;

            if (v == null) {

                view = mInflater.inflate(R.layout.schedulelistviewitem, null);
            } else {
                view = v;
            }

            final ScheduleListViewData data = this.getItem(position);

            if (data != null) {

                TextView tv = (TextView) view.findViewById(R.id.textView1);
                tv.setText(data.getLabel());

                TextView tv1 = (TextView) view.findViewById(R.id.textView2);
                tv1.setText(data.getData());
            }
            return view;
        }

    }


    class ScheduleListViewData {

        private String m_szLabel;
        private String m_szData;

        public ScheduleListViewData(Context context, String p_szLabel, String p_szDataFile) {

            m_szLabel = p_szLabel;
            m_szData = p_szDataFile;

        }

        public String getLabel() {
            return m_szLabel;
        }

        public String getData() {
            return m_szData;
        }

    }

}
