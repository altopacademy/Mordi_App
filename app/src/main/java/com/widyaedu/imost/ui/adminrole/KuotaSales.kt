package com.widyaedu.imost.ui.adminrole

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.widyaedu.imost.adapter.ProductAdapter
import com.widyaedu.imost.adapter.ProductAdminAdapter
import com.widyaedu.imost.databinding.FragmentKuotaSalesBinding
import com.widyaedu.imost.model.ProductItem
import com.widyaedu.imost.preferences.PreferencesManager
import com.widyaedu.imost.viewmodel.ItemViewModel


class KuotaSales(var salesId: String? = null, val starts: String? = null, val ends: String? = null) : Fragment(){
    private lateinit var binding: FragmentKuotaSalesBinding
    private lateinit var itemViewModel: ItemViewModel
    private lateinit var pref: PreferencesManager
    private lateinit var detailSales: DetailSales
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentKuotaSalesBinding.inflate(layoutInflater)
        pref = PreferencesManager(this.requireContext())
        itemViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(
            ItemViewModel::class.java
        )
        itemViewModel.getMyproduct("kuota", salesId.toString(), pref.getRole())
        itemViewModel.productItem.observe(viewLifecycleOwner, {
            showKuota(it)
        })
        return binding.root
    }

    private fun showKuota(list: List<ProductItem>?) {
        binding.rvKuotaSales.adapter = ProductAdminAdapter(list!!)
        binding.rvKuotaSales.layoutManager = LinearLayoutManager(this.requireContext())
    }




}