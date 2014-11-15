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

public class November extends Fragment {

    DataAdapter adapter;
    ArrayList<ScheduleListViewData> alist;
    private ListView listview;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.november, container, false);
        listview = (ListView) v.findViewById(R.id.listView1);
        alist = new ArrayList<ScheduleListViewData>();
        adapter = new DataAdapter(getActivity(), alist);
        listview.setAdapter(adapter);

        adapter.add(new ScheduleListViewData(getActivity(), "안전점검의날",
                "11/4"));
        adapter.add(new ScheduleListViewData(getActivity(), "제13차 동아리활동",
                "11/5"));
        adapter.add(new ScheduleListViewData(getActivity(), "비만 예방 교육",
                "11/7"));
        adapter.add(new ScheduleListViewData(getActivity(), "정수기 수질검사",
                "11/12"));
        adapter.add(new ScheduleListViewData(getActivity(), "수학능력시험",
                "11/13"));
        adapter.add(new ScheduleListViewData(getActivity(), "감염병 예방 교육",
                "11/14"));
        adapter.add(new ScheduleListViewData(getActivity(), "기말고사(3)",
                "11/17~11/25"));
        adapter.add(new ScheduleListViewData(getActivity(), "전국학력평가(1,2)",
                "11/18"));
        adapter.add(new ScheduleListViewData(getActivity(), "제14차 동아리활동",
                "11/26"));
        adapter.add(new ScheduleListViewData(getActivity(), "사이버보안진단의 날",
                "11/26"));
        adapter.add(new ScheduleListViewData(getActivity(), "서버 네트워크 점검",
                "11/26"));
        adapter.add(new ScheduleListViewData(getActivity(), "정보통신 윤리 교육",
                "11/28"));
        adapter.add(new ScheduleListViewData(getActivity(), "학교폭력 예방 교육",
                "11/28"));


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

