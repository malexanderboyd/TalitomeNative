package com.opensource.boyd.talitome.database

import android.provider.BaseColumns

/**
 * Created by Boyd on 8/25/2017.
 */
class CharacterDatabaseContract private constructor() {

    // Inner classes define table contents
    class CharacterEntry : BaseColumns {
    companion object {
            val TABLE_NAME: String = "characters"
            val COLUMN_NAME_KEY: String = "id"
            val COLUMN_NAME_NAME: String = "name"
            val COLUMN_NAME_XPAC: String = "expansion"
            val COLUMN_NAME_STRENGTH: String = "strength"
            val COLUMN_NAME_CRAFT: String = "craft"
            val COLUMN_NAME_LIFE: String = "life"
            val COLUMN_NAME_FATE: String = "fate"
            val COLUMN_NAME_GOLD: String = "gold"
            val COLUMN_NAME_ALIGNMENT: String = "alignment"
            val COLUMN_NAME_SKILL_1: String = "skill_1"
            val COLUMN_NAME_SKILL_2: String = "skill_2"
            val COLUMN_NAME_SKILL_3: String = "skill_3"
            val COLUMN_NAME_SKILL_4: String = "skill_4"
    }
    }

}