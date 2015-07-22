package com.example.katerina.mapsex;

import android.content.Context;
import android.database.Cursor;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by Katerina on 21.07.2015.
 */
public class LocalBackUp {

    public static void CopyDB(InputStream inputStream, OutputStream outputStream)  throws IOException{
        byte[]buffer = new byte[1024];
        int length;
        while((length = inputStream.read(buffer))>0){
            outputStream.write(buffer, 0, length);
        }
        inputStream.close();
        outputStream.close();
    }
    public static void add_Assignments(DBAdapter db, int userId, String token){
        db.open();
        long id = db.insertRecord("UserId", Integer.toString(userId));
        id = db.insertRecord("Token", token);
        db.close();
    }

    public static void get_all_records(DBAdapter db, Context context){
        db.open();
        Cursor c = db.getAllRecords();
        if(c.moveToFirst()){
            do{
                DisplayRecord(c,context);
            }while(c.moveToNext());
        }
        db.close();
    }
    public static void DisplayRecord(Cursor c, Context context){
        Toast.makeText(context,"id" + c.getString(0) + "\n"
            +"name" + c.getString(1) + "\n"
            +"value" + c.getString(2) ,Toast.LENGTH_SHORT).show();
    }

    public static void get_record(DBAdapter db, long id, Context context ) {
        db.open();
        Cursor c = db.getRecord(id);
        if(c.moveToFirst()){
                DisplayRecord(c,context);
        }else{
            Toast.makeText(context, "No Assignment found", Toast.LENGTH_LONG).show();
        }
        db.close();
    }
}
