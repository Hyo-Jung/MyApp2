package com.example.user.myapp2.group;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.user.myapp2.R;

public class GroupActivity extends Activity implements View.OnClickListener {
    GroupDBHelper  groupDBHelper;
    SQLiteDatabase db;
    EditText etName, etNum, etResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);

        EditText etName = (EditText)findViewById(R.id.et_name);
        EditText etNum = (EditText)findViewById(R.id.etNum);
        EditText etResult = (EditText)findViewById(R.id.etResult);

        ((Button)findViewById(R.id.btInit)).setOnClickListener(this);
        ((Button)findViewById(R.id.btInsert)).setOnClickListener(this);
        ((Button)findViewById(R.id.btFind)).setOnClickListener(this);
        ((Button)findViewById(R.id.btUpdate)).setOnClickListener(this);
        ((Button)findViewById(R.id.btDelete)).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btInit :
                db = groupDBHelper.getWritableDatabase();
                groupDBHelper.onUpgrade(db, 1, 2);
                db.close();
                break;
            case R.id.btInsert:
                db = groupDBHelper.getWritableDatabase();
                db.execSQL("INSERT INTO greoup(_id, name, num) VALUES('IOI', 20);");
                db.close();
                Toast.makeText(getApplicationContext(), "입력 성공", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btFind:
                break;
            case R.id.btUpdate:
                break;
            case R.id.btDelete:
                break;
            case R.id.btList:
                db = groupDBHelper.getReadableDatabase();
                Cursor cursor = db.rawQuery("SELECT * FROM group;", null);
                String name = "그룹이름\r\n";
                String num = "멤버수\r\n";
                break;
        } //end switch
    }
}
