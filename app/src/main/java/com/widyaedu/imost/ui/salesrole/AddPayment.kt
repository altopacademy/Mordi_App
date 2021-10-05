package com.widyaedu.imost.ui.salesrole

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.widyaedu.imost.databinding.ActivityAddPaymentBinding
import com.widyaedu.imost.model.Payment
import com.widyaedu.imost.model.PaymentMasterModel
import com.widyaedu.imost.preferences.PreferencesManager
import com.widyaedu.imost.viewmodel.ItemViewModel

class AddPayment : AppCompatActivity() {

    companion object{
        const val EDIT_PAYMENT_EXTRA = "EXTRA_PAYMENT"
    }
    private lateinit var binding: ActivityAddPaymentBinding
    private lateinit var itemViewModel: ItemViewModel
    private lateinit var pref: PreferencesManager
    private var namaBank = ""
    private var idBank = ""
    private var isEdit: Boolean? = null
    private var paymentId = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddPaymentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        isEdit = intent?.getBooleanExtra("edit", false)
        paymentId = intent?.getStringExtra("userid").toString()
        pref = PreferencesManager(this)
        itemViewModel = ViewModelProvider(this,
            ViewModelProvider.NewInstanceFactory()).get(ItemViewModel::class.java)
        itemViewModel.listPaymentMaster()
        itemViewModel.paymentbyId(paymentId)
        itemViewModel.paymentData.observe(this, {
            if (isEdit == true) {
                editRekening(it)
            } else {
                addRekening()
            }
        })
        itemViewModel.listPaymentMaster.observe(this, {
            showBanklist(it.data)
        })
    }

    private fun showBanklist(data: List<PaymentMasterModel>) {
        val banklist = mutableListOf<String>()
        for (i in data) {
            banklist.add(i.name)
            Log.e("fatal", i.name)
        }

        binding.spinnerBank.adapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, banklist)
        binding.spinnerBank.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                val pos = binding.spinnerBank.selectedItemPosition
                namaBank = banklist[pos]
                idBank = data[pos].payment_method_id
                //Log.d(getClassName(), "onItemSelectedBank: $namaBank")
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }
    }
    private fun addRekening(){
        binding.addRekening.setOnClickListener {
            val noRekening = binding.etNomorRekening.text.toString()
            val namaRekening = binding.etnamaRekening.text.toString()
            itemViewModel.addPayment(pref.getUser(), idBank, noRekening, namaRekening)
            val i = Intent(this, ListMyPayment::class.java).apply {
                Intent.FLAG_ACTIVITY_CLEAR_TASK
            }
            startActivity(i)
        }
    }

    private fun editRekening(payment: Payment){
        binding.spinnerBank.visibility = View.GONE
        binding.addRekening.text = "Edit"
        binding.etNomorRekening.setText(payment.account_number)
        binding.etnamaRekening.setText(payment.account_name)
        binding.addRekening.setOnClickListener {
            val i = Intent(this, ListMyPayment::class.java).apply {
                Intent.FLAG_ACTIVITY_CLEAR_TASK
            }
            startActivity(i)
            val noRekening = binding.etNomorRekening.text.toString()
            val namaRekening = binding.etnamaRekening.text.toString()
            /*i.putExtra(EDIT_PAYMENT_EXTRA, payment)
            setResult(Activity.RESULT_OK, i)*/
            itemViewModel.updatePayment(payment.payment_method_details_id.toString(),
                noRekening,
                namaRekening)
            finish()
        }
    }
}