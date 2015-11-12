package com.venom.bestreviewapp.ReviewApp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by vernon on 9/28/15.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "ReviewAndInfo";
    public static final String TABLE_NAME = "Review";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "Views";
    private static final String COL_3 = "Views1";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,Views TEXT, Views1 Text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

        public boolean insertData(String Views, String Views1){
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(COL_2,Views);
            contentValues.put(COL_3,Views1);
            long result = db.insert(TABLE_NAME, null, contentValues);
            if(result == -1)
                return false;
            else
                return true;
    }


    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from" +TABLE_NAME,null);
        return res;
    }
}
