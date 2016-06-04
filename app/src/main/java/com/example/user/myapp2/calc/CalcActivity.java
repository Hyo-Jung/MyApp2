package com.example.user.myapp2.calc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.user.myapp2.R;
import com.example.user.myapp2.main.MainActivity;

/**
 * Created by USER on 2016-06-04.
 */
public class CalcActivity  extends Activity implements View.OnClickListener{

    //1.속성 설정 - 변수 명 정의
    //입력 필드 선언
    EditText et_first, et_second;
    //계산 액션 버튼 선언
    //Button   bt_plus, bt_subs, bt_mult, bt_divd, bt_mod;
    //결과 필드 선언
    TextView tv_ruslt;
    public int firstInput = 0;
    public int secondInput = 0;
    CalcService calcService;

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        //2.속성별 객체 연동
        et_first = (EditText)this.findViewById(R.id.et_first);
        et_second= (EditText)this.findViewById(R.id.et_second);
        tv_ruslt = (TextView)this.findViewById(R.id.tv_ruslt);
        calcService = new CalcServiceImpl();

        ((Button)this.findViewById(R.id.bt_plus)).setOnClickListener(this);
        ((Button)this.findViewById(R.id.bt_subs)).setOnClickListener(this);
        ((Button)this.findViewById(R.id.bt_mult)).setOnClickListener(this);
        ((Button)this.findViewById(R.id.bt_divd)).setOnClickListener(this);
        ((Button)this.findViewById(R.id.bt_mod)).setOnClickListener(this);
        ((Button)this.findViewById(R.id.btMain)).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int result = 0;
        firstInput = Integer.parseInt(et_first.getText().toString());
        secondInput = Integer.parseInt(et_second.getText().toString());

        switch (v.getId()) {
            case R.id.bt_plus :
                result = calcService.getPlusResult(firstInput, secondInput);
                tv_ruslt.setText(result + "입니다.");
                break;
            case R.id.bt_subs :
                result = calcService.getSubsResult(firstInput, secondInput);
                tv_ruslt.setText(result + "입니다.");
                break;
            case R.id.bt_mult :
                result = calcService.getMultResult(firstInput, secondInput);
                tv_ruslt.setText(result + "입니다.");
                break;
            case R.id.bt_divd :
                result = calcService.getDivdResult(firstInput, secondInput);
                tv_ruslt.setText(result + "입니다.");
                break;
            case R.id.bt_mod  :
                result = calcService.getModResult(firstInput, secondInput);
                tv_ruslt.setText(result + "입니다.");
                break;
            case R.id.btMain:
                startActivity(new Intent(this, MainActivity.class));
                break;
        }


        //tMsg.show();
        //tv_ruslt.setText(result);
    }
}