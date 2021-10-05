package com.widyaedu.imost.ui.adminrole

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.widyaedu.imost.adapter.PromoAdapter
import com.widyaedu.imost.databinding.FragmentPromoSalesBinding
import com.widyaedu.imost.model.ProductItem
import com.widyaedu.imost.preferences.PreferencesManager
import com.widyaedu.imost.viewmodel.ItemViewModel


class PromoSales(var salesId: String? = null) : Fragment() {

    private lateinit var binding: FragmentPromoSalesBinding
    private lateinit var pref: PreferencesManager
    private lateinit var itemViewModel: ItemViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentPromoSalesBinding.inflate(layoutInflater)
        pref = PreferencesManager(this.requireContext())
        itemViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(
            ItemViewModel::class.java
        )
        itemViewModel.getMyproduct("nomor_cantik", salesId.toString(), pref.getRole())
        itemViewModel.productItem.observe(viewLifecycleOwner, {
            showNomor(it)
        })
        return binding.root
    }

    private fun showNomor(program: List<ProductItem>?) {
        binding.rvPromoSales.adapter =
            PromoAdapter(this.requireActivity(), program!!, null, pref.getRole())
        binding.rvPromoSales.layoutManager = LinearLayoutManager(this.requireContext())
    }

}