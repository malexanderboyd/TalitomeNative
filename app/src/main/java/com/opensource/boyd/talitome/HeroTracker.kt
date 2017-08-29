package com.opensource.boyd.talitome

import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.opensource.boyd.talitome.database.data.data_characters
import kotlinx.android.synthetic.main.activity_hero_tracker.*
/**
 * Created by Boyd on 8/29/2017.
 */
class HeroTracker : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hero_tracker)
        val character = intent?.getParcelableExtra<data_characters.character>("character")
        character?.let {
            char_name.text = character.Name
            char_align.text = character.alignment
            char_craft.text = character.craft.toString()
            char_str.text = character.strength.toString()
            char_life.text = character.life.toString()
            char_fate.text = character.life.toString()
            char_gold.text = character.gold.toString()
        }
    }


}