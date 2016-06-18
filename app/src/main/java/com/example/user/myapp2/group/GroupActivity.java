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

 /*       EditText etName = (EditText)findViewById(R.id.et_name);
        EditText etNum = (EditText)findViewById(R.id.etNum);
        EditText etResult = (EditText)findViewById(R.id.etResult);*/

        ((Button)findViewById(R.id.btInit)).setOnClickListener(this);
        ((Button)findViewById(R.id.btInsert)).setOnClickListener(this);
        ((Button)findViewById(R.id.btFind)).setOnClickListener(this);
        ((Button)findViewById(R.id.btUpdate)).setOnClickListener(this);
        ((Button)findViewById(R.id.btDelete)).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Cursor cursor;
        String id;
        String name;
        String num;
        switch(v.getId()) {
            case R.id.btInit :
                db = groupDBHelper.getWritableDatabase();
                groupDBHelper.onUpgrade(db, 1, 2);
                db.close();
                break;
            case R.id.btInsert:
                db = groupDBHelper.getWritableDatabase();
                db.execSQL("INSERT INTO greoup(_id, name, num) VALUES('IOI', 30);");
                db.close();
                Toast.makeText(getApplicationContext(), "입력 성공", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btFind:
                db = groupDBHelper.getReadableDatabase();
                cursor = db.rawQuery("SELECT * FROM group WHERE +id = 1;", null);
                id = cursor.getString(0);
                name = cursor.getString(1);
                num = String.valueOf(cursor.getString(2));
                db.close();
                break;
            case R.id.btUpdate:
                db = groupDBHelper.getWritableDatabase();
                db.execSQL("UPDATE greoup SET num=30 WHERE _id = 1");
                db.close();
                break;
            case R.id.btDelete:
                db = groupDBHelper.getWritableDatabase();
                db.execSQL("DELETE FROM greoup WHERE _id = 1");
                db.close();
                break;
            case R.id.btList:
                db = groupDBHelper.getReadableDatabase();
                cursor = db.rawQuery("SELECT * FROM group;", null);
                name = "그룹이름\r\n";
                num = "멤버수\r\n";
                db.close();
                break;
        } //end switch
    }
}
