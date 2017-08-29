package com.opensource.boyd.talitome

import android.content.ContentValues
import android.content.Context
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.LinearLayout
import com.opensource.boyd.talitome.Adapters.MainActivityAdapter
import com.opensource.boyd.talitome.database.CharacterDatabaseContract.CharacterEntry
import com.opensource.boyd.talitome.database.CharacterDbHelper
import com.opensource.boyd.talitome.database.data.data_characters
import com.opensource.boyd.talitome.database.data.data_characters.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainActivityAdapter.heroOnClickListener {
    override fun onClick(item: character, view: View, position: Int) {
            selected_hero_text.text = item.Name
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                title_text1.setText(R.string.title_home)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                title_text1.setText(R.string.title_dashboard)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                title_text1.setText(R.string.title_notifications)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private var allCharacters : List<character>? = null
    private var adapter : MainActivityAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        getCharacters(baseContext)

        adapter = MainActivityAdapter(allCharacters, this )

        heroes_recycler.layoutManager = GridLayoutManager(this, 3)
        heroes_recycler.adapter = adapter


        adapter?.notifyDataSetChanged()
    }

    fun getCharacters(context: Context) {
        var charCreator = data_characters(context)
        allCharacters = charCreator.createStandardCharacters()
    }


}
