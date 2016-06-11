package com.example.user.myapp2.member;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by USER on 2016-06-11.
 */
public class MemberDAO extends SQLiteOpenHelper {
    public MemberDAO(Context context) {
        super(context, null, null, 1);
        //DB_NAME, null, DB_VERSION
    }

    @Override
    //creat DB Table
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

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
        MemberBean inMember = new MemberBean();

        String name = member.getName();
        String id = member.getId();
        String pw = member.getPw();
        String email = member.getEmail();

        Log.i("name", name);
        Log.i("id", id);
        Log.i("pw", pw);
        Log.i("email", email);

        inMember.setId(member.getId());
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
