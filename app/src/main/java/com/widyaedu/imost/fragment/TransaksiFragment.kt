package com.widyaedu.imost.fragment

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.widyaedu.imost.adapter.TransactionAdapter
import com.widyaedu.imost.databinding.FragmentTrxBinding
import com.widyaedu.imost.listener.SendStatus
import com.widyaedu.imost.model.RatingModel
import com.widyaedu.imost.model.Transaction
import com.widyaedu.imost.preferences.PreferencesManager
import com.widyaedu.imost.viewmodel.ItemViewModel

class TransaksiFragment : Fragment(), SendStatus {

    private lateinit var binding: FragmentTrxBinding
    private lateinit var itemViewModel: ItemViewModel
    private lateinit var pref: PreferencesManager
    private var listTransaction = mutableListOf<Transaction>()
    companion object {
        fun newInstance(data: String): TransaksiFragment {
            val args = Bundle()
            args.putString("data", data)
            val f = TransaksiFragment()
            f.arguments = args
            return f
        }
    }


    @SuppressLint("ResourceAsColor")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTrxBinding.inflate(inflater)
        pref = PreferencesManager(this.requireContext())
        itemViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(ItemViewModel::class.java)
        itemViewModel.listHistoryTransact(pref.getUser(), pref.getRole())
        itemViewModel.listTransaction.observe(viewLifecycleOwner, { data ->
            binding.tvBerhasil.setOnClickListener {
                val filter = data.filter {
                    it.status == "Berhasil"
                }
                getlistTransaction(filter)
                binding.tvBerhasil.setTextColor(Color.parseColor("#FDC800"))
                binding.tvPending.setTextColor(Color.parseColor("#ACACAC"))
                binding.tvAll.setTextColor(Color.parseColor("#ACACAC"))
                Toast.makeText(this.requireContext(), "Sukses Status", Toast.LENGTH_SHORT).show()
            }

            binding.tvPending.setOnClickListener {
                val filter = data.filter {
                    it.status == "Pending"
                }
                getlistTransaction(filter)
                binding.tvBerhasil.setTextColor(Color.parseColor("#ACACAC"))
                binding.tvPending.setTextColor(Color.parseColor("#FDC800"))
                binding.tvAll.setTextColor(Color.parseColor("#ACACAC"))
                Toast.makeText(this.requireContext(), "Pending Status", Toast.LENGTH_SHORT).show()
            }

            binding.tvAll.setOnClickListener {
                getlistTransaction(data)
                binding.tvBerhasil.setTextColor(Color.parseColor("#ACACAC"))
                binding.tvPending.setTextColor(Color.parseColor("#ACACAC"))
                binding.tvAll.setTextColor(Color.parseColor("#FDC800"))
            }
            getlistTransaction(data)
        })
        return binding.root
    }

    private fun getlistTransaction(item: List<Transaction>){
        binding.rvHistoryTransaction.adapter = TransactionAdapter(this, item, pref.getRole())
        binding.rvHistoryTransaction.layoutManager = LinearLayoutManager(context)
    }

    override fun setStatus(transaction: Transaction) {
        transaction.status = "Berhasil"
        itemViewModel.updateStatus(transaction.transaction_id.toString(), pref.getUser(), "1")
    }

    override fun setData(rating: RatingModel) {
        itemViewModel.addRating(rating.transaction_id.toString(), pref.getUser(), rating.rating.toString(), rating.notes.toString())
    }


}