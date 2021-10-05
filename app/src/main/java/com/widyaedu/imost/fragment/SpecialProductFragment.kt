package com.widyaedu.imost.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.widyaedu.imost.adapter.SpecialProductAdapter
import com.widyaedu.imost.databinding.FragmentProductBinding
import com.widyaedu.imost.model.ProductMaster

class SpecialProductFragment : Fragment() {

    private lateinit var binding: FragmentProductBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentProductBinding.inflate(inflater)

        val myType = object : TypeToken<List<ProductMaster>>() {}.type
        val data: List<ProductMaster> = Gson().fromJson(arguments?.getString("data"), myType)
        binding.rvProduct.adapter = SpecialProductAdapter(requireActivity(), data)

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
        fun newInstance(param1: String) = SpecialProductFragment().apply {
            arguments = Bundle().apply {
                putString("data", param1)
            }
        }
    }
}