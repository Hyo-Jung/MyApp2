package com.example.user.myapp2.member;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by USER on 2016-06-11.
 */
public class MemberDAO extends SQLiteOpenHelper {
    public MemberDAO(Context context) {
        super(context, "member", null, 1);
        //DB_NAME, null, DB_VERSION
    }

    @Override
    //creat DB Table
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table member2(" +
                "id    text, " +
                "pw    text, " +
                "name  text, " +
                "email text" +
                ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS member2");
        onCreate(db);
    }

    //insert DB for input values
    public String signup(MemberBean member) {
        String name = member.getName();
        String id = member.getId();
        String pw = member.getPw();
        String email = member.getEmail();

        Log.i("name", name);
        Log.i("id", id);
        Log.i("pw", pw);
        Log.i("email", email);

        return "회원 가입 성공";
    }

    public MemberBean login(MemberBean member) {
        String id = member.getId();
        String pw = member.getPw();
        MemberBean inMember = new MemberBean();
        SQLiteDatabase db = this.getReadableDatabase();
        Log.i("id", id);
        Log.i("pw", pw);

        Cursor cursor = db.rawQuery("SELECT ID, PW, NAME, EMAIL " +
                "                   FROM MEMBER " +
                "                  WHERE ID = '" + id + "' " +
                "                    AND PW = '" + pw + "' "
                , null);

        while(cursor.moveToNext()) {
            inMember.setId(cursor.getString(0)); //ID
            inMember.setPw(cursor.getString(1)); //PW
            inMember.setName(cursor.getString(2)); //Name
            inMember.setEmail(cursor.getString(3)); //Email
        }

        cursor.close();
        db.close();

        //inMember.setId(member.getId());
        return inMember;
    }

    public MemberBean update(MemberBean member) {
        MemberBean upMember = new MemberBean();

        String name = member.getName();
        String id = member.getId();
        String pw = member.getPw();
        String email = member.getEmail();

        Log.i("name", name);
        Log.i("id", id);
        Log.i("pw", pw);
        Log.i("email", email);

        return upMember;
    }

    public String delete(MemberBean member) {
        String name = member.getName();
        String id = member.getId();
        String pw = member.getPw();
        String email = member.getEmail();

        Log.i("name", name);
        Log.i("id", id);
        Log.i("pw", pw);
        Log.i("email", email);
        return "삭제 완료";
    }
}
