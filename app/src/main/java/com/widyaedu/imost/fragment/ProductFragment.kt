package com.widyaedu.imost.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.widyaedu.imost.adapter.ProductAdapter
import com.widyaedu.imost.adapter.ProductAdminAdapter
import com.widyaedu.imost.adapter.PromoAdapter
import com.widyaedu.imost.adapter.SalesAdapter
import com.widyaedu.imost.databinding.FragmentProductBinding
import com.widyaedu.imost.model.ProductItem
import com.widyaedu.imost.model.Sales

class ProductFragment : Fragment() {

    private lateinit var binding: FragmentProductBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentProductBinding.inflate(inflater)

        when {
            requireArguments().getBoolean("admin") -> {
                val myType = object : TypeToken<List<ProductItem>>() {}.type
                val data: List<ProductItem> = Gson().fromJson(arguments?.getString("data"), myType)
                binding.rvProduct.adapter = ProductAdminAdapter(data)
            }
            requireArguments().getBoolean("sales") -> {
                val myType = object : TypeToken<List<Sales>>() {}.type
                val data: List<Sales> = Gson().fromJson(arguments?.getString("data"), myType)

                binding.rvProduct.adapter = SalesAdapter(requireContext(), data, "")
            }
            requireArguments().getBoolean("promo") -> {
                val myType = object : TypeToken<List<ProductItem>>() {}.type
                val data: List<ProductItem> = Gson().fromJson(arguments?.getString("data"), myType)
                binding.rvProduct.adapter = PromoAdapter(requireActivity(), data)
            }
            else -> {
                val myType = object : TypeToken<List<ProductItem>>() {}.type
                val data: List<ProductItem> = Gson().fromJson(arguments?.getString("data"), myType)
                binding.rvProduct.adapter = ProductAdapter(data)
            }
        }

        if (binding.rvProduct.adapter!!.itemCount == 0) {
            binding.rvProduct.visibility = View.GONE
            binding.tvNotfound.visibility = View.VISIBLE
        } else {
            binding.rvProduct.visibility = View.VISIBLE
            binding.tvNotfound.visibility = View.GONE
        }

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(
            param1: String,
            param2: Boolean,
            param3: Boolean = false,
            param4: Boolean = false,
        ) =
            ProductFragment().apply {
                arguments = Bundle().apply {
                    putString("data", param1)
                    putBoolean("admin", param2)
                    putBoolean("sales", param3)
                    putBoolean("promo", param4)
                }
            }
    }
}