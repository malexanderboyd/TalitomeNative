package com.opensource.boyd.talitome.database

import android.content.ContentValues
import android.content.Context
import com.opensource.boyd.talitome.database.CharacterDatabaseContract.CharacterEntry
import com.opensource.boyd.talitome.database.data.data_characters

/**
 *  TODO - Create saving system that stores current characters progression within db
 * Created by Boyd on 8/28/2017.
 */
class DatabaseCreator(var context: Context) {

    private var characters : ArrayList<ContentValues>? = null
    fun createStandardCharacters() {
        characters?.let {

        }
    }

    fun initDb() {
        val dbHelper = CharacterDbHelper(context)
        val activeDb = dbHelper.writableDatabase
    /*
        val currentCharacter: ContentValues = ContentValues()
        currentCharacter.put(CharacterEntry.COLUMN_NAME_KEY, characterName + "-" + expansion)
        currentCharacter.put(CharacterEntry.COLUMN_NAME_NAME, characterName)
        currentCharacter.put(CharacterEntry.COLUMN_NAME_ALIGNMENT, alignment)
        currentCharacter.put(CharacterEntry.COLUMN_NAME_STRENGTH, strength)
        currentCharacter.put(CharacterEntry.COLUMN_NAME_CRAFT, craft)
        currentCharacter.put(CharacterEntry.COLUMN_NAME_LIFE, life)
        currentCharacter.put(CharacterEntry.COLUMN_NAME_FATE, fate)
        currentCharacter.put(CharacterEntry.COLUMN_NAME_GOLD, gold)

        activeDb.insert(CharacterEntry.TABLE_NAME, null, currentCharacter)
    */

    }
}