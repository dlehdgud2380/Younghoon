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

public class October extends Fragment {

    DataAdapter adapter;
    ArrayList<ScheduleListViewData> alist;
    private ListView listview;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.october, container, false);
        listview = (ListView) v.findViewById(R.id.listView1);
        alist = new ArrayList<ScheduleListViewData>();
        adapter = new DataAdapter(getActivity(), alist);
        listview.setAdapter(adapter);

        adapter.add(new ScheduleListViewData(getActivity(), "충격과 공포의 중간고사(1,2,3)",
                "9/29~10/2"));
        adapter.add(new ScheduleListViewData(getActivity(), "개천절 개꿀",
                "10/3"));
        adapter.add(new ScheduleListViewData(getActivity(), "학력평가(3)",
                "10/7"));
        adapter.add(new ScheduleListViewData(getActivity(), "영훈독서의 밤",
                "10/8~10/9"));
        adapter.add(new ScheduleListViewData(getActivity(), "인문학특강",
                "10/8"));
        adapter.add(new ScheduleListViewData(getActivity(), "제11차 동아리활동",
                "10/8"));
        adapter.add(new ScheduleListViewData(getActivity(), "사이버독후감대회",
                "10/13~11/7"));
        adapter.add(new ScheduleListViewData(getActivity(), "제2회영어경시대회",
                "10/15"));
        adapter.add(new ScheduleListViewData(getActivity(), "환경 생명 생태 체험 활동",
                "10/18"));
        adapter.add(new ScheduleListViewData(getActivity(), "학부모 상담 주간",
                "10/20~10/24"));
        adapter.add(new ScheduleListViewData(getActivity(), "제12차 동아리활동",
                "10/22"));
        adapter.add(new ScheduleListViewData(getActivity(), "사이버보안진단의 날",
                "10/22"));
        adapter.add(new ScheduleListViewData(getActivity(), "서버 네트워크 점검",
                "10/22"));
        adapter.add(new ScheduleListViewData(getActivity(), "학부모 수업 공개",
                "10/24"));
        adapter.add(new ScheduleListViewData(getActivity(), "학부모 정보통신윤리교육",
                "10/24"));
        adapter.add(new ScheduleListViewData(getActivity(), "1교사1학생상담록제출",
                "10/24"));
        adapter.add(new ScheduleListViewData(getActivity(), "정보통신 윤리 교육",
                "10/31"));
        adapter.add(new ScheduleListViewData(getActivity(), "학교폭력 예방 교육",
                "10/31"));


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
