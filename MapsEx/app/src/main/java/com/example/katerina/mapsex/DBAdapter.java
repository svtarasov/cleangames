package com.example.katerina.mapsex;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.sql.DatabaseMetaData;

/**
 * Created by Katerina on 21.07.2015.
 */
public class DBAdapter {
    public final static String KEY_ROWID = "id";
    public final static String KEY_NAME = "name";
    public final static String KEY_VALUE = "value";
    public final static String TAG = "DBAdapter";

    public final static String DB_NAME = "CleanGamesDB";
    public final static String DB_TABLE = "Settings";
    public final static int DB_VERSION = 1; //?????????????????????

    public final static String DB_CREATE = "create table if not exists " + DB_TABLE +
             " (id integer primary key autoincrement," + "name VARCHAR not null, value VARCHAR);";

    private final Context context;

    private DatabaseHelper DBHelper;
    private SQLiteDatabase db;

    public DBAdapter(Context ctx){
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);
    }

    private static class DatabaseHelper extends SQLiteOpenHelper {
        DatabaseHelper(Context context) {
            super(context, DB_NAME, null, DB_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            try {
                db.execSQL(DB_CREATE);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.w(TAG, "Upgrading database from version " + oldVersion + " to" +
                    newVersion + ", which will destroy all old data");
            db.execSQL("DROP TABLE IF EXISTS " + DB_TABLE);
            onCreate(db);
        }
    }
    //--- opens DB ---
        public  DBAdapter open() throws SQLException{
            db = DBHelper.getWritableDatabase();
            return this;
        }

    //--- closes DB ---
    public void close(){
        DBHelper.close();
    }

    //--- insert a record into DB ---
    public long insertRecord(String name, String value){
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_NAME,name);
        initialValues.put(KEY_VALUE, value);
        return db.insert(DB_TABLE,null,initialValues);
    }

    //--- delete a certain record ---
    public boolean deleteRecord(long rowId){
        return db.delete(DB_TABLE, KEY_ROWID + "=" + rowId,null) > 0;
    }

    //--- retrieves all the records ---
    public Cursor getAllRecords(){
        return db.query(DB_TABLE, new String[]{KEY_ROWID,KEY_NAME,KEY_VALUE}, null, null, null, null, null);
    }

    //--- retrieves a particular record ---
    public Cursor getRecord(long rowId) throws SQLException{
        Cursor mCursor =
                db.query(true, DB_TABLE, new String[]{KEY_ROWID,KEY_NAME,KEY_VALUE},KEY_ROWID + "=" + rowId,
                        null,null,null,null,null);
        if(mCursor != null){
            mCursor.moveToFirst();
        }
        return mCursor;
    }

    //--- updates a record ---
    public  boolean  updateRecord(long rowId, String name, String value){
        ContentValues args = new ContentValues();
        args.put(KEY_NAME,name);
        args.put(KEY_VALUE, value);
        return db.update(DB_TABLE,args,KEY_ROWID + "=" + rowId, null)>0;
    }

}
