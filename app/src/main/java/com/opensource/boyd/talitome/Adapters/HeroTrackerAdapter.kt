package com.opensource.boyd.talitome.Adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.opensource.boyd.talitome.R
import com.opensource.boyd.talitome.database.data.data_characters.*
import kotlinx.android.synthetic.main.character_portrait.view.*
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.util.SparseArray
import kotlinx.android.synthetic.main.character_skills.view.*


internal class HeroTrackerAdapter(val skills : List<String>?) : RecyclerView.Adapter<HeroTrackerAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroTrackerAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.character_skills, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: HeroTrackerAdapter.ViewHolder, position: Int) {
        skills?.let {
            holder.bindItems(skills[position], position)
        }
    }

    override fun getItemCount(): Int {
        return skills?.size ?: 0
    }

    internal inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(skill : String, position: Int) {
            itemView.skill.text = String.format(itemView.resources.getString(R.string.char_numbered_skill), skill)
        }
    }
}
