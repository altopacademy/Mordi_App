package com.widyaedu.imost.ui

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.widyaedu.imost.Input2Activity
import com.widyaedu.imost.InputActivity
import com.widyaedu.imost.R
import com.widyaedu.imost.adapter.BannerAdapter
import com.widyaedu.imost.databinding.FragmentHomeBinding
import com.widyaedu.imost.databinding.PopupCityBinding
import com.widyaedu.imost.listener.ClickHelper
import com.widyaedu.imost.model.BannerModel
import com.widyaedu.imost.model.User
import com.widyaedu.imost.preferences.PreferencesManager
import com.widyaedu.imost.ui.product.ListProductActivity
import com.widyaedu.imost.ui.product.ListProductActivity.Companion.PRODUCT_TYPE
import com.widyaedu.imost.ui.salesrole.ListMyProduct.Companion.PRODUCT_TYPE_ADD
import com.widyaedu.imost.utils.Tools
import com.widyaedu.imost.viewmodel.ItemViewModel
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.coroutines.*
import kotlin.math.abs

class HomeFragment : Fragment() {

    private lateinit var itemViewModel: ItemViewModel
    private lateinit var binding: FragmentHomeBinding
    private lateinit var pref: PreferencesManager
    private lateinit var click: ClickHelper
    private var city = ""
    lateinit var bitmap : Bitmap
    lateinit var imgview: ImageView

    companion object {
        fun newInstance(data: String): HomeFragment {
            val args = Bundle()
            args.putString("data", data)
            val f = HomeFragment()
            f.arguments = args
            return f
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        itemViewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(ItemViewModel::class.java)


    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentHomeBinding.inflate(inflater)
        pref = PreferencesManager(this.requireContext())

//Customer
        if ( pref.getRole() == "Customer") {
            binding.tvNomor.text = "Data Pasien"
        }
        click = requireActivity() as ClickHelper
//        binding.tvTrx.setOnClickListener {
//            click.click()
//        }

        binding.cvKuota.setOnClickListener {
            val i = if (pref.getRole() == "Sales" || pref.getRole() == "Customer") {
                Intent(requireActivity(), Input2Activity::class.java).apply {
                    putExtra(PRODUCT_TYPE_ADD, "pulsa")
                }
            } else {
                Intent(requireActivity(), ListProductActivity::class.java).apply {
                    putExtra(PRODUCT_TYPE, "kuota")
                }
            }
            startActivity(i)
        }
        binding.cvNomor.setOnClickListener {
            val i = if (pref.getRole() == "Sales") {

                Intent(requireActivity(), ListProductActivity::class.java).apply {
                    putExtra(PRODUCT_TYPE_ADD, "post_paid")
                }
            } else {
                Intent(requireActivity(), ListProductActivity::class.java).apply {
                    putExtra(PRODUCT_TYPE, "sales")
                }
            }
            startActivity(i)
        }
        binding.cvSales.setOnClickListener {
            startActivity(Intent(requireActivity(), ListProductActivity::class.java).apply {
                putExtra(PRODUCT_TYPE, "promo")
            })
        }

//        binding.cvPulsa.setOnClickListener {
//            val i = if (pref.getRole() == "Sales") {
//                Intent(requireActivity(), ListMyProduct::class.java).apply {
//                    putExtra(PRODUCT_TYPE_ADD, "pulsa")
//                }
//            } else {
//                Intent(requireActivity(), ListProductActivity::class.java).apply {
//                    putExtra(PRODUCT_TYPE, "pulsa")
//                }
//            }
//            startActivity(i)
//        }
//        binding.cvPost.setOnClickListener {
//            val i = Intent(requireActivity(), ListProductActivity::class.java).apply {
//                putExtra(PRODUCT_TYPE, "post_paid")
//            }
//            startActivity(i)
//        }
//        binding.cvBundling.setOnClickListener {
//            val i = Intent(requireActivity(), ListProductActivity::class.java).apply {
//                putExtra(PRODUCT_TYPE, "bundling")
//            }
//            startActivity(i)
//        }
//
//        binding.cvPromoSaya.setOnClickListener {
//            val i = Intent(requireActivity(), ListMyProduct::class.java).apply {
//                putExtra(PRODUCT_TYPE_ADD, "promo")
//            }
//            startActivity(i)
//        }
//
//        binding.cvProdukKnow.setOnClickListener {
//            startActivity(Intent(this.requireContext(), ProductKnowledge::class.java))
//        }
//        //admin
//        binding.cvManagementSales.setOnClickListener {
//            startActivity(Intent(this.requireActivity(), ManagementSales::class.java))
//        }
//
//        binding.cvKuotaAdmin.setOnClickListener {
//            val i = Intent(requireActivity(), ListProductActivity::class.java).apply {
//                putExtra(PRODUCT_TYPE, "kuota")
//            }
//            startActivity(i)
//        }
//
//        binding.cvNomorAdmin.setOnClickListener {
//            val i = Intent(requireActivity(), ListProductActivity::class.java).apply {
//                putExtra(PRODUCT_TYPE, "nomor_cantik")
//            }
//            startActivity(i)
//        }
//
//        binding.cvPromoAdmin.setOnClickListener {
//            val i = Intent(requireActivity(), ListProductActivity::class.java).apply {
//                putExtra(PRODUCT_TYPE, "kuota")
//            }
//            startActivity(i)
//        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val user = FirebaseAuth.getInstance().currentUser

        user?.let { user ->
            if (user.email?.isNotEmpty() == true && user.email != null){
                itemViewModel.getUserByEmail(user.email.toString())
                itemViewModel.user.observe(viewLifecycleOwner, {
                    when (it?.status) {
                        1 -> {
                            showUser(it.data)
                            saveUserid(it.data.user_id.toString(),
                                it.data.role.toString(),
                                it.data.photo.toString())
                            setupView(it.data.email.toString())
                        }
                        2, 3 -> {
                            Tools.showDialogCustom(requireActivity(),
                                View.OnClickListener { logout() },
                                it.message)
                        }
                        else -> {
                            addUser(
                                user.displayName.toString(),
                                user.photoUrl.toString(),
                                user.email.toString()
                            )
                        }
                    }
                })
            } else if (user.email.isNullOrEmpty()) {
                val numPhone = user.phoneNumber?.replace("+62", "0")
                itemViewModel.getUserByPhone(numPhone.toString())
                itemViewModel.user.observe(viewLifecycleOwner, {
                    when (it?.status) {
                        1 -> {
                            showUser(it.data)
                            saveUserid(it.data.user_id.toString(),
                                it.data.role.toString(),
                                it.data.photo.toString())
                            setupView(it.data.email)
                        }
                        2, 3 -> {
                            Tools.showDialogCustom(requireActivity(),
                                View.OnClickListener { logout() },
                                it.message)
                        }
                        else -> {
                            addUser(
                                name = numPhone.toString(),
                                phoneNumb = numPhone.toString(),
                                photo = "https://upload.wikimedia.org/wikipedia/commons/thumb/7/7e/Circle-icons-profile.svg/1024px-Circle-icons-profile.svg.png"
                            )
                        }
                    }
                })
            }
            if (pref.getCity().isBlank()) {
                itemViewModel.getCityList()
                itemViewModel.cityItem.observe(requireActivity(), { data ->
                    if (data != null) {
                        val dialog = Dialog(requireActivity(), R.style.FullScreenDialog)
                        val d = PopupCityBinding.inflate(layoutInflater)
                        dialog.setContentView(d.root)

                        val list = mutableListOf<String>()
                        for (s in data) {
                            list.add(s.name)
                        }

                        d.spinnerProduct.adapter =
                            ArrayAdapter(requireActivity(),
                                android.R.layout.simple_spinner_dropdown_item,
                                list)
                        d.spinnerProduct.onItemSelectedListener =
                            object : AdapterView.OnItemSelectedListener {
                                override fun onItemSelected(
                                    p0: AdapterView<*>?,
                                    p1: View?,
                                    p2: Int,
                                    p3: Long,
                                ) {
                                    city = data[p2].city_id
                                }

                                override fun onNothingSelected(p0: AdapterView<*>?) {}
                            }

                        d.btOK.setOnClickListener {
                            if (city.isNotBlank()) {
                                showProduct(city, pref.getRole())
                                pref.setCity(city)
                                dialog.dismiss()
                            } else {
                                Toast.makeText(requireContext(),
                                    "pilih kota Anda",
                                    Toast.LENGTH_SHORT).show()
                            }
                        }
                        dialog.show()
                    }
                })
            } else {
                showProduct(pref.getCity(), pref.getRole())
            }
        }

        itemViewModel.promoData.observe(viewLifecycleOwner, {
            showPromo(it)
        })
    }

    private fun logout() {
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        val mGoogleSignInClient = GoogleSignIn.getClient(this.requireContext(), gso)
        mGoogleSignInClient.signOut().addOnCompleteListener {
            val editor = activity?.getSharedPreferences("login", Context.MODE_PRIVATE)?.edit()
            editor?.clear()
            editor?.apply()
            val i = Intent(this.requireActivity(), LoginActivity::class.java)
            startActivity(i)
        }
    }

    private fun showPromo(banner: List<BannerModel>) {

        vpPromo.setPadding(60, 0, 60, 0)
        vpPromo.clipToPadding = false
        vpPromo.pageMargin = 25
        vpPromo.adapter = BannerAdapter(banner, this.requireContext())

        imgIndicator.setViewPager(vpPromo)

        coroutines = lifecycleScope.launch {
            delay(3500)
            withContext(Dispatchers.Main) {
                if (vpPromo.adapter != null) {
                    vpPromo.currentItem =
                        if (vpPromo.currentItem ==
                            vpPromo.adapter!!.count - 1
                        ) 0 else vpPromo.currentItem + 1
                }
            }
        }
        vpPromo.addOnPageChangeListener(viewPagerPageChangeListener)

        vpPromo.setPageTransformer(false) { page, position ->
            val normal = abs(abs(position) - 1)
            page.scaleY = normal / 2 + 0.5f
        }
    }

    private lateinit var coroutines: Job
    private var viewPagerPageChangeListener: ViewPager.OnPageChangeListener = object :
        ViewPager.OnPageChangeListener {
        override fun onPageSelected(position: Int) {
            coroutines.cancel()
            coroutines = lifecycleScope.launch {
                delay(3500)
                withContext(Dispatchers.Main) {
                    if (vpPromo.adapter != null) {
                        vpPromo.currentItem =
                            if (vpPromo.currentItem ==
                                vpPromo.adapter!!.count - 1
                            ) 0 else vpPromo.currentItem + 1
                    }
                }
            }
        }

        override fun onPageScrolled(arg0: Int, arg1: Float, arg2: Int) {}
        override fun onPageScrollStateChanged(arg0: Int) {}
    }

    private fun addUser(name: String, photo: String?=null, email: String?=null, phoneNumb: String? =null) {
        itemViewModel.setUser(name, photo, email, phoneNumb) {
            showUser(it)
        }
    }

    private fun showUser(data: User?) {
        binding.tvNama.text = data?.name
        Glide.with(this.requireContext()).load(data?.photo)
            .into(binding.ivProfile)
        if (data?.role == "Sales") {
            binding.roleId.text = "Pasien"
        }

        if (data?.role == "Customer") {
            binding.roleId.text = "Dokter"
        }
    }

    private fun showProduct(city: String, role: String) {
        itemViewModel.getPromo(city, role)
    }

    private fun saveUserid(userId: String, role: String, photo: String) {
        pref.setUserId(userId)
        pref.setRole(role)
        pref.setPhoto(photo)
    }

    private fun setupView(role: String?) {
        if (role =="helloaltop@gmail.com" || role =="sdylabsindonesia@gmail.com" || role == "muhammadalitopantf@gmail.com" || role == "daffaamanu661@gmail.com" ||  role == "daffaamanu661@mail.ugm.ac.id") {
            hideView()
        } else {
            Tools.showDialogCustom(requireActivity(),
                View.OnClickListener { logout() },
                "Maaf, akun anda belum terdaftar. Silahkan hubungi Admin Makula")
        }
    }

    private fun hideView() {
        binding.tvLayanan.visibility = View.VISIBLE
        binding.cvSales.visibility = View.VISIBLE
        binding.tvSales.visibility = View.VISIBLE
    }
}