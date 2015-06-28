package com.maxiee.attitude.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.maxiee.attitude.database.tables.EventImageRelationTable;
import com.maxiee.attitude.database.tables.EventLabelRelationTable;
import com.maxiee.attitude.database.tables.EventThoughtRelationTable;
import com.maxiee.attitude.database.tables.EventsTable;
import com.maxiee.attitude.database.tables.ImageTable;
import com.maxiee.attitude.database.tables.LabelsTable;
import com.maxiee.attitude.database.tables.ThoughtsTable;

/**
 * Created by maxiee on 15-6-11.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    private final static String DB_NAME = "attitude";
    private final static int DB_VER = 1;

    private static DatabaseHelper instance;

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VER);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(EventsTable.CREATE);
        db.execSQL(LabelsTable.CREATE);
        db.execSQL(EventLabelRelationTable.CREATE);
        db.execSQL(ThoughtsTable.CREATE);
        db.execSQL(EventThoughtRelationTable.CREATE);
        db.execSQL(ImageTable.CREATE);
        db.execSQL(EventImageRelationTable.CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}

    public static synchronized DatabaseHelper instance(Context context) {
        if (instance == null) {
            instance = new DatabaseHelper(context);
        }

        return instance;
    }
}
