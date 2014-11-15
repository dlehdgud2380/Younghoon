package com.scoutlee.younghoon;

import android.content.Context;

public class ScheduleListViewData {

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
