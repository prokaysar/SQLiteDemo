package com.prokaysar.sqlitedemo;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {
    EditText nameText,ageText,genderText,userId;
    Button applyChangeButton;
    MyDatabaseHelper myDatabaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        nameText = findViewById(R.id.cname_id);
        genderText = findViewById(R.id.cgender_id);
        ageText = findViewById(R.id.cage_id);
        userId = findViewById(R.id.user_id_id);
        applyChangeButton = findViewById(R.id.change_id);

        myDatabaseHelper = new MyDatabaseHelper(this);
        SQLiteDatabase database = myDatabaseHelper.getReadableDatabase();
        applyChangeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name  = nameText.getText().toString();
                String gender  = genderText.getText().toString();
                String age  = ageText.getText().toString();
                String id  = userId.getText().toString();

                Boolean isUpdated =  myDatabaseHelper.updateData(id,name,gender,age);
                if (isUpdated == true){
                    Toast.makeText(UpdateActivity.this, "Data successfully updated.", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(UpdateActivity.this, "Data successfully updated.", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

}
