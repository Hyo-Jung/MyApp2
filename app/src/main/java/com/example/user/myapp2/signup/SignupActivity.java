package com.example.user.myapp2.signup;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.user.myapp2.R;
import com.example.user.myapp2.member.MemberBean;
import com.example.user.myapp2.member.MemberDAO;
import com.example.user.myapp2.member.MemberService;
import com.example.user.myapp2.member.MemberServiceImpl;

public class SignupActivity extends Activity implements View.OnClickListener{

    //Instance
    EditText etId, etPw, etName, etEmail;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        etId     = (EditText)this.findViewById(R.id.etId);
        etPw     = (EditText)this.findViewById(R.id.etPw);
        etName   = (EditText)this.findViewById(R.id.etName);
        etEmail  = (EditText)this.findViewById(R.id.etEmail);
        tvResult  = (TextView)this.findViewById(R.id.tvResult);
        ((Button)this.findViewById(R.id.btSignup)).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String id    = etId.getText().toString();
        String pw    = etPw.getText().toString();
        String name  = etName.getText().toString();
        String email = etEmail.getText().toString();

        //은닉화
        MemberBean member = new MemberBean();
        member.setId(id);
        member.setPw(pw);
        member.setName(name);
        member.setEmail(email);

        //MemberService service = new MemberServiceImpl();
        //String msg = service.signup(member);

        MemberDAO dao = new MemberDAO(this.getApplicationContext());
        String msg = dao.signup(member);

        tvResult.setText(msg + "입니다.");

    }
}
