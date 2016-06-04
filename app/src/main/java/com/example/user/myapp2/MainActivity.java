package com.example.user.myapp2;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    EditText et_name, et_weight, et_height;
    TextView tv_output;
    Button bt_confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_name    = (EditText)this.findViewById(R.id.et_name);
        et_weight  = (EditText)this.findViewById(R.id.et_weight);
        et_height  = (EditText)this.findViewById(R.id.et_height);
        tv_output  = (TextView)this.findViewById(R.id.tv_output);
        bt_confirm = (Button)this.findViewById(R.id.bt_confirm);

        bt_confirm.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                String  name   = et_name.getText().toString();
                double weight = Double.parseDouble(et_weight.getText().toString());
                double height = Double.parseDouble(et_height.getText().toString());
                int    figure  = (int)((weight / (height * height))*10000);
                String result  = "";

                if(figure >= 24){
                    result = "과체중";
                }else if(figure<24 && figure >= 20){
                    result = "정상";
                }else if(figure<20 && figure >= 15){
                    result = "저체중";
                }else if(figure<15 && figure >= 13){
                    result = "마름";
                }else if(figure<13 && figure >= 10){
                    result = "영양실조";
                }else {
                    result = "소모증";
                }
                tv_output.setText(name + "님은 " + result + "(" + figure + ")입니다.");

                return false;
            }
        });

    }
}