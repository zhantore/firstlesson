package com.example.firstlesson;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.firstlesson.db_helper.DBHelper;

public class DBActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnAdd;
    Button btnRead;
    Button btnClear;
    EditText etName;
    EditText etEmail;
    DBHelper dbHelper;
    Integer DATABASE_VERSION = 1;
    String DATABASE_NAME = "contactDb";

    @RequiresApi(api = Build.VERSION_CODES.O_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d_b);

        btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);

        btnRead =  findViewById(R.id.btnRead);
        btnRead.setOnClickListener(this);

        btnClear =  findViewById(R.id.btnClear);
        btnClear.setOnClickListener(this);

        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);

        SQLiteDatabase.OpenParams.Builder options = new SQLiteDatabase.OpenParams.Builder();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            dbHelper = new DBHelper(this, DATABASE_NAME, DATABASE_VERSION, options.build());
        }
    }

    @Override
    public void onClick(View v) {
        String name = etName.getText().toString();
        String email = etEmail.getText().toString();
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        int vID = v.getId();
        switch (vID) {
            case R.id.btnAdd:
                contentValues.put(dbHelper.KEY_NAME, name);
                contentValues.put(dbHelper.KEY_MAIL, email);
                database.insert(dbHelper.TABLE_CONTACTS, null, contentValues);
                Toast.makeText(this, "Successfully added!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnRead:
                getDataFromDB(database);
                break;
            case R.id.btnClear:
                database.delete(dbHelper.TABLE_CONTACTS, "", null);
                ((TextView) findViewById(R.id.tvResult)).setText("");
                break;
        }
    }

    private void getDataFromDB(SQLiteDatabase database) {
        Cursor cursor  = database.query(dbHelper.TABLE_CONTACTS, null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            int idIndex = cursor.getColumnIndex(dbHelper.KEY_ID);
            int nameIndex = cursor.getColumnIndex(dbHelper.KEY_NAME);
            int emailIndex = cursor.getColumnIndex(dbHelper.KEY_MAIL);
            do {
                String result = "ID = " + cursor.getInt(idIndex) +
                        ", name = " + cursor.getString(nameIndex) +
                        ", email = " + cursor.getString(emailIndex);
                Log.d("mLog", result);
                ((TextView) findViewById(R.id.tvResult)).setText(result);
            } while (cursor.moveToNext());
        } else
            Log.d("mLog", "0 rows");
        cursor.close();
    }
}