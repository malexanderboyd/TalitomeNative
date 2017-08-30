package com.opensource.boyd.talitome

import android.app.Activity
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.opensource.boyd.talitome.Adapters.HeroTrackerAdapter
import com.opensource.boyd.talitome.database.data.data_characters
import com.opensource.boyd.talitome.databinding.ActivityHeroTrackerBinding
import com.opensource.boyd.talitome.viewmodels.HeroTrackerViewModel
import kotlinx.android.synthetic.main.activity_hero_tracker.*
/**
 * Created by Boyd on 8/29/2017.
 */
class HeroTracker : Activity(), HeroTrackerAdapter.heroOnClickListener {
    override fun onClick(item: data_characters.character, view: View, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hero_tracker)
        val character = intent?.getParcelableExtra<data_characters.character>("character")
        character?.let {
            val binding: ActivityHeroTrackerBinding = DataBindingUtil.setContentView(this, R.layout.activity_hero_tracker)
            binding.viewModel = HeroTrackerViewModel(this, character)
        }
    }


}