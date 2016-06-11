package com.example.user.myapp2.member;

import android.app.Activity;

import java.util.ArrayList;

/**
 * Created by USER on 2016-06-11.
 */
public class MemberServiceImpl extends Activity implements MemberService {
    MemberDAO dao = new MemberDAO(this.getApplicationContext());

    @Override
    //insert DB for input values
    public String signup(MemberBean member) {
        return dao.signup(member);
    }

    @Override
    public MemberBean login(MemberBean member) {
        return dao.login(member);
    }

    @Override
    public MemberBean update(MemberBean member) {
        return dao.update(member);
    }

    @Override
    public String delete(MemberBean member) {
        return dao.delete(member);
    }
}
