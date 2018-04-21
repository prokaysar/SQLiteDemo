package com.prokaysar.sqlitedemo;


import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText nameText,ageText,genderText;
    Button insertBtn,selectBtn,updateBtn,deleteBtn;

    MyDatabaseHelper myDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameText = findViewById(R.id.name_id);
        genderText = findViewById(R.id.gender_id);
        ageText = findViewById(R.id.age_id);
        insertBtn = findViewById(R.id.insert_id);
        selectBtn = findViewById(R.id.read_id);
        updateBtn = findViewById(R.id.update_id);
        deleteBtn = findViewById(R.id.delete_id);

        insertBtn.setOnClickListener(this);
        selectBtn.setOnClickListener(this);
        updateBtn.setOnClickListener(this);
        deleteBtn.setOnClickListener(this);

        myDatabaseHelper = new MyDatabaseHelper(this);
        SQLiteDatabase database = myDatabaseHelper.getReadableDatabase();
    }

    @Override
    public void onClick(View v) {
        String name  = nameText.getText().toString();
        String gender  = genderText.getText().toString();
        String age  = ageText.getText().toString();
        switch (v.getId()){
            case R.id.insert_id:
                //insertData long id return kore
                long rowId = myDatabaseHelper.insertData(name,age,gender);
                if (rowId == -1){
                    Toast.makeText(this, "Data not inserted", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(this, "Data row : "+rowId+" inserted", Toast.LENGTH_SHORT).show();

                }
                break;
                case R.id.read_id:

                break;
                case R.id.update_id:

                break;
                case R.id.delete_id:

                break;

        }
    }

}
