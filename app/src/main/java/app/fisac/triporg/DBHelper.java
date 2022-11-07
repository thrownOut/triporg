package app.fisac.triporg;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DBHelper extends SQLiteOpenHelper{

    public static final String DBNAME = "register.db";

    public DBHelper(Context context){
        super(context, "register.db",  null, 1);


    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table person(email TEXT primary key, password TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1 ) {

        MyDB.execSQL("drop Table if exists person");

    }

    public Boolean insertData(String email, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email",email);
        contentValues.put("password",password);
        long result = MyDB.insert("person",null,contentValues);
        if(result == -1){
            return false;
        }
        else{
            return true;
        }
    }

    public Boolean checkemail(String email){

        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("select * from person where email = ?",new String[]{email});
        if(cursor.getCount()>0)
        {
            return true;
        }
        else{
            return false;
        }
    }


}
