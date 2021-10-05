package com.widyaedu.imost.ui.salesrole

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.widyaedu.imost.R
import com.widyaedu.imost.databinding.ActivityProductKnowledgeBinding
import com.widyaedu.imost.ui.salesrole.DetailProductKnowledge.Companion.KEY_DETAIL

class ProductKnowledge : AppCompatActivity() {
    private lateinit var binding: ActivityProductKnowledgeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductKnowledgeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        gotoKuota()
        gotoNomor()
    }

    private fun gotoKuota(){
        binding.cardKuota.setOnClickListener {
            val i  = Intent(this, DetailProductKnowledge::class.java).apply {
                putExtra(KEY_DETAIL, "kuota")
            }
            startActivity(i)
        }
    }

    private fun gotoNomor(){
        binding.cardNomor.setOnClickListener {
            val i  = Intent(this, DetailProductKnowledge::class.java).apply {
                putExtra(KEY_DETAIL, "nomor")
            }
            startActivity(i)
        }
    }
}