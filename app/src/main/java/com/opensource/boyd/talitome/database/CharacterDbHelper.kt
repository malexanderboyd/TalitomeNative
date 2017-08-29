package com.opensource.boyd.talitome.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.opensource.boyd.talitome.database.CharacterDatabaseContract.*
/**
 * Created by Boyd on 8/25/2017.
 */
class CharacterDbHelper : SQLiteOpenHelper {

    constructor(context : Context) : super(context, DB_NAME, null, DB_VERSION)

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(SQL_CREATE_CHARACTER_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.let {
            db.execSQL(SQL_DELETE_CHARACTER_TABLE)
            onCreate(db)
        }
    }



    companion object {
        val DB_VERSION: Int = 1
        val DB_NAME: String = "Characters.db"
        val SQL_CREATE_CHARACTER_TABLE : String =
                "CREATE TABLE " + CharacterEntry.TABLE_NAME + " (" +
                        CharacterEntry.COLUMN_NAME_KEY + " TEXT PRIMARY KEY," +
                        CharacterEntry.COLUMN_NAME_NAME + " TEXT," +
                        CharacterEntry.COLUMN_NAME_STRENGTH + " INTEGER," +
                        CharacterEntry.COLUMN_NAME_CRAFT + " INTEGER," +
                        CharacterEntry.COLUMN_NAME_LIFE + " INTEGER," +
                        CharacterEntry.COLUMN_NAME_FATE + " INTEGER," +
                        CharacterEntry.COLUMN_NAME_GOLD + " INTEGER," +
                        CharacterEntry.COLUMN_NAME_ALIGNMENT + " TEXT," +
                        ")"

        val SQL_DELETE_CHARACTER_TABLE : String = "DROP TABLE IF EXISTS " +
                CharacterEntry.TABLE_NAME

    }
}