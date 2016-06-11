package com.example.user.myapp2.login;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import com.example.user.myapp2.R;
import com.example.user.myapp2.kaup.KaupService;
import com.example.user.myapp2.kaup.KaupServiceImpl;
import com.example.user.myapp2.main.MainActivity;
import com.example.user.myapp2.member.MemberBean;
import com.example.user.myapp2.member.MemberDAO;

import static android.Manifest.permission.READ_CONTACTS;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends Activity implements View.OnClickListener {
    EditText etId, etPw;
    TextView tvResult;
    //Button btSignin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etId     = (EditText)this.findViewById(R.id.etId);
        etPw     = (EditText)this.findViewById(R.id.etPw);
        tvResult  = (TextView)this.findViewById(R.id.tvResult);
        ((Button)this.findViewById(R.id.btSignin)).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        String id    = etId.getText().toString();
        String pw    = etPw.getText().toString();

        //은닉화
        MemberBean memberIn = new MemberBean();
        MemberBean memberOut = new MemberBean();
        memberIn.setId(id);
        memberIn.setPw(pw);

        //MemberService service = new MemberServiceImpl();
        //String msg = service.signup(member);

        MemberDAO dao = new MemberDAO(this.getApplicationContext());
        memberOut = dao.login(memberIn);

        tvResult.setText("로그인 된 ID는 [" + memberOut.getId() + "] 입니다.");
    }
}

