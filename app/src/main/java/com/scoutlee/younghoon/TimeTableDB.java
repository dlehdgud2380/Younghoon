package com.scoutlee.younghoon;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.io.File;

public class TimeTableDB {

    public static final String TAG = "TimetableTag";
    public static final String TABLE_NAME = "timetable";
    public static final String timetableDatabaseFile = "/sdcard/YoungHoon_TimeTableDB.db";
    public static boolean tableMaked = false;
    SQLiteDatabase db;

    //시간표 이름을 문자열로받아서 디비 테이블에 저장
    public void inputTable(String timetableName) {
        openDatabase(timetableDatabaseFile);
        createTimetableTable();
        insertTimetableData(timetableName);
        tableMaked = true;
        closeDatabase();
    }

    // 디비 테이블에서 id가 1인 열을 하나 쿼리
    public String outputTable() {
        openDatabase(timetableDatabaseFile);
        String queriedTimetableName = queryTimetableTable();
        closeDatabase();
        return queriedTimetableName;
    }


    //데이터베이스 생성 or 열기
    public void openDatabase(String databaseFile) {

        try {

            db = SQLiteDatabase.openDatabase(
                    databaseFile, null, SQLiteDatabase.OPEN_READWRITE + SQLiteDatabase.CREATE_IF_NECESSARY);
        } catch (Exception e) {
            Log.d(TAG, e.toString());
            //println(e.toString());
        }
    }


    public void closeDatabase() {
        try {
            db.close();
        } catch (Exception e) {

        }
    }


    public void createTimetableTable() {
        db.execSQL("drop table if exists " + TABLE_NAME);
        String sql = "";
        sql += "create table " + TABLE_NAME + "( ";
        sql += " timetable_id text, ";
        sql += " timetable_name text) ";

        db.execSQL(sql);
    }


    public void insertTimetableData(String timetableName) {

        String[] tokens = {"1", timetableName};


        String sql = "insert into " + TABLE_NAME + " (timetable_id, timetable_name) ";
        sql += " values (?, ?)";

        if (tokens != null) {
            db.execSQL(sql, tokens);
        } else {
            Log.d(TAG, "the input Line is invalid");
        }
    }


    public void insertTimetableDataInit() {

        String[] tokens = {"1", ""};


        String sql = "insert into " + TABLE_NAME + " (timetable_id, timetable_name) ";
        sql += " values (?, ?)";

        if (tokens != null) {
            db.execSQL(sql, tokens);
        } else {
            Log.d(TAG, "the input Line is invalid");
        }
    }
//
//	public void updateTimetableDataInit()
//	{
//
//		String[] tokens = { ""};
//
//
//		String sql = "update "+TABLE_NAME+" set timetable_name ";
//		sql +="= (?) ";
//		sql +=" where timetable_id = '1' ";
//
//
//
//		if(tokens != null)
//		{
//			db.execSQL(sql, tokens);
//		}
//		else
//		{
//			Log.d(TAG, "the input Line is invalid");
//		}	
//	}


    public void deleteTimetableDatabase() {

//		String[] whereArgs = {"1"};

        SQLiteDatabase.deleteDatabase(new File(timetableDatabaseFile));


//		db.delete(TABLE_NAME, "timetable_id = ?", whereArgs);
//
//		String[] whereArgs = {"Rice"};
//
//		int rowAffected = db.delete(name,
//				"name = ?",
//				whereArgs);
//
//		return rowAffected;
    }

    public String queryTimetableTable() {

        String sql = "select timetable_name ";
        sql += " from timetable ";
        sql += " where timetable_id = ?";

        String[] args = {"1"};

        //		if(tableMaked)
        //		{
        //
        //		}
        //		else
        //		{
        //			return "";
        //		}


        Cursor result;


        try {
            result = db.rawQuery(sql, args);
        } catch (Exception e) {
            return "";
        }


        int count = result.getCount();
        String timetable_name = "";
        for (int i = 0; i < count; i++) {
            result.moveToNext();
            timetable_name = result.getString(0);
        }

        result.close();
        return timetable_name;
    }


}
