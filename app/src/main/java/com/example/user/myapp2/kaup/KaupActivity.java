package com.example.user.myapp2.kaup;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.myapp2.R;
import com.example.user.myapp2.main.MainActivity;

public class KaupActivity extends Activity implements View.OnClickListener{

    EditText et_name, et_weight, et_height;
    TextView tv_output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kaup);

        et_name    = (EditText)this.findViewById(R.id.et_name);
        et_weight  = (EditText)this.findViewById(R.id.et_weight);
        et_height  = (EditText)this.findViewById(R.id.et_height);
        tv_output  = (TextView)this.findViewById(R.id.tv_output);

        ((Button)this.findViewById(R.id.bt_confirm)).setOnClickListener(this);
        ((Button)this.findViewById(R.id.btMain)).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.bt_confirm:
                Toast tMsg = Toast.makeText(KaupActivity.this, "토스트연습", Toast.LENGTH_LONG);

                String  name   = et_name.getText().toString();
                double weight = Double.parseDouble(et_weight.getText().toString());
                double height = Double.parseDouble(et_height.getText().toString());
                String result  = "";

                KaupService service = new KaupServiceImpl();
                result  = service.getKaup(weight, height);
                Log.d(result,"카우프지수");

                tv_output.setText(name + "님은 " + result + "입니다.");
                tMsg.show();
                break;
            case R.id.btMain:
                startActivity(new Intent(this, MainActivity.class));
                break;
        }

    }
}
