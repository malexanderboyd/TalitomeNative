package com.opensource.boyd.talitome

import android.content.ContentValues
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import com.opensource.boyd.talitome.database.CharacterDatabaseContract.CharacterEntry
import com.opensource.boyd.talitome.database.CharacterDbHelper
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                message.setText(R.string.title_home)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                message.setText(R.string.title_dashboard)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                message.setText(R.string.title_notifications)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)




    }


    fun initDb() {
        var dbHelper = CharacterDbHelper(baseContext)

        var activeDb = dbHelper.writableDatabase

        var currentCharacter: ContentValues = ContentValues()
        currentCharacter.put(CharacterEntry.COLUMN_NAME_KEY, characterName + "-" + expansion)
        currentCharacter.put(CharacterEntry.COLUMN_NAME_NAME, characterName)
        currentCharacter.put(CharacterEntry.COLUMN_NAME_XPAC, expansion)
        currentCharacter.put(CharacterEntry.COLUMN_NAME_ALIGNMENT, alignment)
        currentCharacter.put(CharacterEntry.COLUMN_NAME_STRENGTH, strength)
        currentCharacter.put(CharacterEntry.COLUMN_NAME_CRAFT, craft)
        currentCharacter.put(CharacterEntry.COLUMN_NAME_LIFE, life)
        currentCharacter.put(CharacterEntry.COLUMN_NAME_FATE, fate)
        currentCharacter.put(CharacterEntry.COLUMN_NAME_GOLD, gold)
        currentCharacter.put(CharacterEntry.COLUMN_NAME_SKILL_1, skill_1)
        currentCharacter.put(CharacterEntry.COLUMN_NAME_SKILL_2, skill_2)
        currentCharacter.put(CharacterEntry.COLUMN_NAME_SKILL_3, skill_3)
        currentCharacter.put(CharacterEntry.COLUMN_NAME_SKILL_4, skill_4)

        activeDb.insert(CharacterEntry.TABLE_NAME, null, currentCharacter)


    }
}
