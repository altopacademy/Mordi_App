package com.widyaedu.imost.ui.salesrole

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.widyaedu.imost.R
import com.widyaedu.imost.databinding.ActivityDetailProductKnowledgeBinding

class DetailProductKnowledge : AppCompatActivity() {
    companion object{
        const val KEY_DETAIL = "extra"
    }
    private lateinit var binding: ActivityDetailProductKnowledgeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailProductKnowledgeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val type = intent.getStringExtra(KEY_DETAIL)
        showDetail(type.toString())
    }

    private fun showDetail(type: String){
        if (type == "nomor") {
            binding.layoutKuota.visibility = View.GONE
            binding.layoutNomor.visibility = View.VISIBLE
            binding.kuota.visibility = View.GONE
            binding.nomorCant.visibility = View.VISIBLE
        }
    }
}