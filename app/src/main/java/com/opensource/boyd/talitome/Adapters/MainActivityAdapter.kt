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



/**
 * Created by Boyd on 8/28/2017.
 */
internal class MainActivityAdapter(val characters : List<character>?, clickListener: heroOnClickListener) : RecyclerView.Adapter<MainActivityAdapter.ViewHolder>() {

    interface heroOnClickListener {
        fun onClick(item: character, view: View, position: Int)
    }

    private var clickListener : heroOnClickListener? = clickListener


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainActivityAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.character_portrait, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: MainActivityAdapter.ViewHolder, position: Int) {
        characters?.let {
            holder.bindItems(characters[position])
        }
    }

    override fun getItemCount(): Int {
       return characters?.size ?: 0
    }

    internal inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {


        override fun onClick(view: View?) {
            view?.let {
                var pos = layoutPosition
                var item = characters?.get(pos)
                item?.let {
                    clickListener?.onClick(item, view, pos)
                }
            }
        }


        fun bindItems(char: character) {
            itemView.char_name.text = char.Name
            itemView.card_view.setOnClickListener(this)
        }
    }
}
