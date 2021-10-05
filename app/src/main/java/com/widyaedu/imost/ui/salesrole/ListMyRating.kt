package com.widyaedu.imost.ui.salesrole

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.widyaedu.imost.R
import com.widyaedu.imost.adapter.RatingAdapter
import com.widyaedu.imost.databinding.ActivityListMyRatingBinding
import com.widyaedu.imost.model.RatingModel
import com.widyaedu.imost.preferences.PreferencesManager
import com.widyaedu.imost.ui.HomeActivity
import com.widyaedu.imost.viewmodel.ItemViewModel

class ListMyRating : AppCompatActivity() {
    private lateinit var binding: ActivityListMyRatingBinding
    private lateinit var itemViewModel: ItemViewModel
    private lateinit var pref: PreferencesManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListMyRatingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        pref = PreferencesManager(this)
        itemViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(ItemViewModel::class.java)
        itemViewModel.listRating(pref.getUser())
        itemViewModel.listrating.observe(this, {
            showRating(it)
        })
        binding.back.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }
    }

    private fun showRating(rating: List<RatingModel>?) {
        binding.rvMyRating.apply {
            adapter = RatingAdapter(rating!!)
            layoutManager = LinearLayoutManager(this@ListMyRating)
        }
    }
}