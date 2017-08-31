package com.opensource.boyd.talitome.viewmodels

import android.content.Context
import android.databinding.BaseObservable
import android.graphics.drawable.Drawable
import android.support.v4.content.ContextCompat
import android.view.View
import com.bumptech.glide.Glide
import com.opensource.boyd.talitome.R
import com.opensource.boyd.talitome.database.data.data_characters
/**
 * Created by Boyd on 8/29/2017.
 */
class HeroTrackerViewModel(val context : Context, val character : data_characters.character) : BaseObservable() {


    fun onModifyStrBtn(type: Int) : View.OnClickListener = View.OnClickListener { item ->
        item?.let {
            var currentStat : Int = character.strength ?: 0
            currentStat += type
            if(currentStat < 0) {
                currentStat = 0
            }
            setCurrentStr(currentStat.toString())
        }
    }

    fun currentStr() : String {
        return character.strength.toString()
    }


    fun setCurrentStr(str : String) {
        character.strength = Integer.parseInt(str)
        notifyChange()
    }

    fun currentCraft() : String {
        return character.craft.toString()
    }


    fun setCurrentCraft(stat : String) {
        character.craft = Integer.parseInt(stat)
        notifyChange()
    }

    fun currentLife() : String {
        return character.life.toString()
    }

    fun setCurrentLife(stat : String) {
        character.life = Integer.parseInt(stat)
        notifyChange()
    }

    fun currentFate() : String {
        return character.fate.toString()
    }

    fun setCurrentFate(stat : String) {
        character.fate = Integer.parseInt(stat)
        notifyChange()
    }

    fun currentGold() : String {
        return character.gold.toString()
    }

    fun setCurrentGold(stat : String) {
        character.gold = Integer.parseInt(stat)
        notifyChange()
    }

    fun currAlign() : String {
        return character.alignment ?: ""
    }

    fun formattedName() : String {
        return character.name.replace("_", " ")
    }

    fun onModifyCraftBtn(type: Int) : View.OnClickListener = View.OnClickListener { item ->
        item?.let {
            var currentStat : Int = character.craft ?: 0
            currentStat += type
            if(currentStat < 0) {
                currentStat = 0
            }
            setCurrentCraft(currentStat.toString())
        }
    }

    fun onModifyFateBtn(type: Int) : View.OnClickListener = View.OnClickListener { item ->
        item?.let {
            var currentStat : Int = character.fate ?: 0
            currentStat += type
            if(currentStat < 0) {
                currentStat = 0
            }
            setCurrentFate(currentStat.toString())
        }
    }

    fun onModifyGoldBtn(type: Int) : View.OnClickListener = View.OnClickListener { item ->
        item?.let {
            var currentStat : Int = character.gold ?: 0
            currentStat += type
            if(currentStat < 0) {
                currentStat = 0
            }
            setCurrentGold(currentStat.toString())
        }
    }

    fun onModifyLifeBtn(type: Int) : View.OnClickListener = View.OnClickListener { item ->
        item?.let {
            var currentStat : Int = character.life ?: 0
            currentStat += type
            if(currentStat < 0) {
                currentStat = 0
            }
            setCurrentLife(currentStat.toString())
        }
    }

    fun getHeroImage() : Drawable {
        val Name = character.name.toLowerCase()
        val id = R.drawable::class.java.getField(Name).getInt(null)
        return ContextCompat.getDrawable(context, id)
    }

}