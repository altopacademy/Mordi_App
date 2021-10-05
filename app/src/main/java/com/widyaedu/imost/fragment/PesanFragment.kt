package com.widyaedu.imost.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.widyaedu.imost.adapter.HistoryChatAdapter
import com.widyaedu.imost.databinding.FragmentPesanBinding
import com.widyaedu.imost.model.ChatData
import com.widyaedu.imost.preferences.PreferencesManager
import com.widyaedu.imost.viewmodel.ItemViewModel

class PesanFragment : Fragment() {

    private lateinit var binding: FragmentPesanBinding
    private lateinit var itemViewModel: ItemViewModel
    private lateinit var pref: PreferencesManager

    companion object {
        fun newInstance(data: String): PesanFragment {
            val args = Bundle()
            args.putString("data", data)
            val f = PesanFragment()
            f.arguments = args
            return f
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPesanBinding.inflate(inflater)
        itemViewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(ItemViewModel::class.java)
        pref = PreferencesManager(this.requireContext())
        itemViewModel.listHistoryChat(pref.getUser())
        itemViewModel.listChat.observe(viewLifecycleOwner, {
            showHistory(it)
        })
        return binding.root
    }

    private fun showHistory(data: List<ChatData>) {
        binding.rvHistoryChat.adapter = HistoryChatAdapter(this.requireContext(), data)
        binding.rvHistoryChat.layoutManager = LinearLayoutManager(this.requireContext())
    }
}