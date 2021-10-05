package com.widyaedu.imost.ui.adminrole

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.widyaedu.imost.R
import com.widyaedu.imost.adapter.ProductAdapter
import com.widyaedu.imost.adapter.ProductAdminAdapter
import com.widyaedu.imost.adapter.PromoAdapter
import com.widyaedu.imost.databinding.FragmentNomorCantikBinding
import com.widyaedu.imost.model.ProductItem
import com.widyaedu.imost.preferences.PreferencesManager
import com.widyaedu.imost.viewmodel.ItemViewModel

class NomorCantik(var salesId: String? = null) : Fragment() {

    private lateinit var binding: FragmentNomorCantikBinding
    private lateinit var itemViewModel: ItemViewModel
    private lateinit var pref: PreferencesManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNomorCantikBinding.inflate(layoutInflater)
        pref = PreferencesManager(this.requireContext())
        itemViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(
            ItemViewModel::class.java
        )
        itemViewModel.getMyproduct("program", salesId.toString(), pref.getRole())
        itemViewModel.productItem.observe(viewLifecycleOwner,{
            showNomor(it)
        })
        return binding.root
    }

    private fun showNomor(nomorCantik: List<ProductItem>?) {
        binding.rvNomorSales.adapter = ProductAdminAdapter(nomorCantik!!)
        binding.rvNomorSales.layoutManager = LinearLayoutManager(this.requireContext())
    }




}