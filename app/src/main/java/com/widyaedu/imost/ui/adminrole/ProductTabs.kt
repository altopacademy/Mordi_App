package com.widyaedu.imost.ui.adminrole

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ProductTabs(fm: FragmentManager, var salesId: String?=null,
                  val start: String?=null, val end: String?=null) : FragmentPagerAdapter(fm){
    override fun getCount(): Int = 3

    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> {
                KuotaSales(salesId)
            }
            1 -> {
                NomorCantik(salesId)
            }

            else -> PromoSales()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0-> {
                "Kuota"
            }
            1-> {
                "Nomor Cantik"
            } else -> {
                return "Promo"
            }
        }
    }
}