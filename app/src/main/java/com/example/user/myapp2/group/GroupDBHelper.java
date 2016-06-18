package com.example.user.myapp2.group;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by USER on 2016-06-18.
 */
public class GroupDBHelper extends SQLiteOpenHelper {
    public GroupDBHelper(Context context) {
        super(context, "hanbitDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE group(" +
                "_id INTEGER PRIMARY KEY," +
                "name TEXT," +
                "num INTEGER" +
                ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE  IF EXISTS group;");
        this.onCreate(db);
    }
}
