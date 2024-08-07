package com.komputerkit.sqlitedatabase;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "dbtoko";
    private static final int VERSION = 1;
    private SQLiteDatabase db;

    public Database(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
        db = this.getWritableDatabase();
    }

    // Method to run SQL commands
    boolean runSQL(String sql) {
        try {
            db.execSQL(sql);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Method to run SELECT queries
    Cursor select(String sql) {
        try {
            return db.rawQuery(sql, null);
        } catch (Exception e) {
            return null;
        }
    }

    // Method to create tables
    public void buatTabel() {
        String tblBarang = "CREATE TABLE tblbarang (" +
                "idbarang INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "barang TEXT, " +
                "stok REAL, " +
                "harga REAL" +
                ")";
        runSQL(tblBarang);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // Create tables when the database is created
        buatTabel();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        // Handle database upgrades
        // For now, just drop the existing tables and recreate them
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS tblbarang");
        onCreate(sqLiteDatabase);
    }
}
