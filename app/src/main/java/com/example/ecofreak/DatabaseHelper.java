package com.example.ecofreak;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="register.db";
    public static final String TABLE_NAME="register.db";
    public static final String COL_1="ID";
    public static final String COL_2="Username";
    public static final String COL_3="Password";

    public DatabaseHelper(Context context){
        super(context,DATABASE_NAME, null,1);

    }







    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE registeruser(ID INTEGER PRIMARY KEY AUTOINCREMENT,Username TEXT,Password TEXT)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS '" + TABLE_NAME + "'");
        onCreate(sqLiteDatabase);

    }
    public long add_user(String user,String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("username",user);
        contentValues.put("password",password);
        long res = db.insert("registeruser",null,contentValues);
        db.close();
        return res;
    }

    public boolean CheckUser(String Username,String Password){
        String[] columns={COL_1};
        SQLiteDatabase db = getReadableDatabase();
        String selection= COL_2 +"=?" + "and" + COL_3 + "=?";
        String[] selection_arguments={Username,Password};
        Cursor cursor=db.query(TABLE_NAME,columns,selection,selection_arguments, null,null,null);


        int count=cursor.getCount();

        db.close();
        cursor.close();
        return count > 0;

    }
}

