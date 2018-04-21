package com.prokaysar.sqlitedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class MyDatabaseHelper extends SQLiteOpenHelper {
    private Context context;
    private static final String DATABASE_NAME = "Student.db";
    private static final int VERSION = 1;

    private static final String TABLE_NAME = "Student_details";

    private static final String ID     = "_id";
    private static final String NAME   = "Name";
    private static final String AGE    = "Age";
    private static final String GENDER = "Gender";

    //table create query
     private static final String CREATE_TABLE = "create table "+TABLE_NAME+"("+ID+" integer primary key autoincrement," +
            ""+NAME+" varchar(20)," +
            ""+AGE+" integer,"+GENDER+" varchar(20));";
    //Drop table
    private static final String DROP_TABLE = "drop table if exists "+TABLE_NAME+"";

    //select data
    private static final String READ_DATA = "select * from "+TABLE_NAME+"";



    public MyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try{
            db.execSQL(CREATE_TABLE);

            Toast.makeText(context, "OnCreate Method is Called", Toast.LENGTH_SHORT).show();
        }catch (Exception e){
//         Toast.makeText(context, "Error !:"+e, Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       try{
           db.execSQL(DROP_TABLE);
           onCreate(db);

           Toast.makeText(context, "Upgrade method is called", Toast.LENGTH_SHORT).show();
       }catch (Exception e){

           Toast.makeText(context, ""+e, Toast.LENGTH_SHORT).show();
       }
    }
    public long insertData(String name,String age,String gender){

        // getWritableDatabase method data base return kore thake
        SQLiteDatabase database = this.getWritableDatabase();

        // contentValue class all value ke eksathe joma rakhe
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME,name);
        contentValues.put(AGE,age);
        contentValues.put(GENDER,gender);

        // insert method return kore  row er id ja long type er
        // insert method row number return kore
        // insert method successfully data insert korte na parle -1 return kore
        long rowId =  database.insert(TABLE_NAME,null,contentValues);
        return rowId;
    }
    public Cursor selectData(){
        SQLiteDatabase database = this.getWritableDatabase();

        // rawQuery ekoti result set return kore
        //result set ke cursor interface er maje store korte hobe
        // cursor ke read or write korar jonno use kora hoy
        Cursor cursor = database.rawQuery(READ_DATA,null);
        return cursor;

    }
}
