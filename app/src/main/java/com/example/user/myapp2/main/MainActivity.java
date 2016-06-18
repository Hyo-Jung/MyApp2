package com.example.user.myapp2.main;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.myapp2.R;
import com.example.user.myapp2.calc.CalcActivity;
import com.example.user.myapp2.extra.WidgetActivity;
import com.example.user.myapp2.group.GroupActivity;
import com.example.user.myapp2.kaup.KaupActivity;
import com.example.user.myapp2.login.Login2Activity;
import com.example.user.myapp2.signup.SignupActivity;

import java.io.File;

public class MainActivity extends Activity implements View.OnClickListener {

    EditText et_name, et_weight, et_height;
    TextView tv_output;
    //Button btKaup, btCalc, btDial, btLogin, btnWeb, btnGoogle, btnSearch, btmSms, btnPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("암시적 인텐트 예제");

        ((Button)findViewById(R.id.btKaup)).setOnClickListener(this);
        ((Button)findViewById(R.id.btCalc)).setOnClickListener(this);
        ((Button)findViewById(R.id.btDial)).setOnClickListener(this);
        ((Button)findViewById(R.id.btLogin)).setOnClickListener(this);
        ((Button)findViewById(R.id.btnWeb)).setOnClickListener(this);
        ((Button)findViewById(R.id.btnGoogle)).setOnClickListener(this);
        ((Button)findViewById(R.id.btnSearch)).setOnClickListener(this);
        ((Button)findViewById(R.id.btmSms)).setOnClickListener(this);
        ((Button)findViewById(R.id.btnPhoto)).setOnClickListener(this);
        ((Button)findViewById(R.id.btmWidget)).setOnClickListener(this);
        ((Button)findViewById(R.id.btSignup)).setOnClickListener(this);
        ((Button)findViewById(R.id.btGroup)).setOnClickListener(this);
        ((Button)findViewById(R.id.btList)).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Uri uri;
        Intent intent;
        Toast tMsg = Toast.makeText(MainActivity.this, "인텐트 연습", Toast.LENGTH_LONG);
        tMsg.show();

        switch(v.getId()) {
            case R.id.btKaup :
                startActivity(new Intent(this, KaupActivity.class));
                break;
            case R.id.btCalc :
                startActivity(new Intent(this, CalcActivity.class));
                break;
            case R.id.btDial :
                uri = Uri.parse("tel:01012345678");
                startActivity(new Intent(Intent.ACTION_DIAL, uri));
                break;
            case R.id.btLogin :
                startActivity(new Intent(this, Login2Activity.class));
                break;
            case R.id.btnWeb :
                uri = Uri.parse("http://www.naver.com");
                startActivity(new Intent(Intent.ACTION_VIEW, uri));
                break;
            case R.id.btnGoogle :
                uri = Uri.parse("https://www.google.co.kr/maps/place/%EC%9D%B8%EC%B2%9C%EA%B5%AD%EC%A0%9C%EA%B3%B5%ED%95%AD/@37.4601908,126.4406957,14z/data=!4m5!3m4!1s0x0:0x8d4ba096cb5cbed4!8m2!3d37.4601908!4d126.4406957");
                intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                break;
            case R.id.btnSearch :
                intent = new Intent(Intent.ACTION_SEARCH);
                intent.putExtra(SearchManager.QUERY, "여름휴가");
                startActivity(intent);
                break;
            case R.id.btmSms :
                intent = new Intent(Intent.ACTION_VIEW);
                intent.putExtra("sms_body", "Hello");
                intent.setType("vnd.android-dir/mms-sms");
                startActivity(intent);
                break;
            case R.id.btnPhoto :
                intent = new Intent(Intent.ACTION_VIEW);
                uri = Uri.fromFile(new File("/sdcard/image1.jpg"));
                intent.setDataAndType(uri, "image/j[peg");
                startActivity(intent);
                break;
            case R.id.btmWidget :
                startActivity(new Intent(this, WidgetActivity.class));
                break;
            case R.id.btSignup :
                startActivity(new Intent(this, SignupActivity.class));
                break;
            case R.id.btGroup :
                startActivity(new Intent(this, GroupActivity.class));
                break;
            case R.id.btList:
                //startActivity(new Intent(this, GroupActivity.class));
                break;

        }

    }
}