package com.opensource.boyd.talitome.viewmodels

import android.content.Context
import android.view.View
import com.opensource.boyd.talitome.database.data.data_characters
import java.util.*

/**
 * Created by Boyd on 8/29/2017.
 */
class HeroTrackerViewModel(val context : Context, val character : data_characters.character) : Observable() {

    fun onClickStrUpBtn() : View.OnClickListener = View.OnClickListener { item ->
        item?.let {
            TODO("Increase stat by 1")
        }
    }
}