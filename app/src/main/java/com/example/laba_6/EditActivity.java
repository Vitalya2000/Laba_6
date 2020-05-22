package com.example.laba_6;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditActivity extends Activity implements View.OnClickListener {
    Button btn_save;
    EditText et_ID,etName2,etPrice2,etQuant2;
    MyDBHelper dbHelper;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_activity);

        btn_save = (Button) findViewById(R.id.button_ed);
        btn_save.setOnClickListener(this);

        et_ID = (EditText) findViewById(R.id.etID);
        etName2 = (EditText) findViewById(R.id.etName2);
        etPrice2 = (EditText) findViewById(R.id.etPrice2);
        etQuant2 = (EditText) findViewById(R.id.etQuant2);

        dbHelper = new MyDBHelper(this);
    }
    @Override
    public void onClick(View v) {
        String id2 = et_ID.getText().toString();
        String name2 = etName2.getText().toString();
        String price2 = etPrice2.getText().toString();
        String quant2 = etQuant2.getText().toString();


        SQLiteDatabase database4 = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

            contentValues.put(MyDBHelper.KEY_ID, id2);
            contentValues.put(MyDBHelper.KEY_NAME, name2);
            contentValues.put(MyDBHelper.KEY_PRICE, price2);
            contentValues.put(MyDBHelper.KEY_QUANTITY, quant2);
            database4.update(MyDBHelper.TABLE_GOODS, contentValues, MyDBHelper.KEY_ID + "=" + id2, null);


        dbHelper.close();
    }
}
