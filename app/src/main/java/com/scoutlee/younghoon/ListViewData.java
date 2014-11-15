package com.scoutlee.younghoon;

import android.content.Context;

public class ListViewData {

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
