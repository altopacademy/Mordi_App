package com.widyaedu.imost.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.widyaedu.imost.R
import com.widyaedu.imost.databinding.ActivityUpdateProfileBinding
import com.widyaedu.imost.model.User
import com.widyaedu.imost.viewmodel.ItemViewModel

class UpdateProfile : AppCompatActivity() {
    companion object{
        const val ID_USER = "extra_id"
    }
    private lateinit var binding: ActivityUpdateProfileBinding
    private lateinit var itemViewModel: ItemViewModel
    private var userId = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        itemViewModel =  ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(ItemViewModel::class.java)
        userId = intent.getStringExtra(ID_USER).toString()
        itemViewModel.getUserById(userId)
        itemViewModel.user.observe(this, {
            showProfile(it.data)
        })
    }

    private fun showProfile(user: User){
        binding.etNameUser.setText(user.name)
        binding.etDescUser.setText(user.description)
        binding.etEmailUser.setText(user.email)
        binding.etUserPhone.setText(user.phone_number)
    }
}