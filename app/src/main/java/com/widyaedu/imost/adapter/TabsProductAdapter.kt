package com.widyaedu.imost.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.widyaedu.imost.fragment.ProductFragment
import com.widyaedu.imost.fragment.SpecialProductFragment

class TabsProductAdapter(
    fm: FragmentManager?,
    private val kuota: String,
    private val nomor: String,
    private val sales: String,
    private val pulsa: String,
    private val post: String,
    private val bundling: String,
    private val promo: String,
    private val isAdmin: Boolean,
) :
    FragmentStatePagerAdapter(
        fm!!, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
    ) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> ProductFragment.newInstance(kuota, isAdmin)
            1 -> ProductFragment.newInstance(nomor, isAdmin)
            2 -> ProductFragment.newInstance(sales, isAdmin, true)
            3 -> ProductFragment.newInstance(pulsa, isAdmin)
            4 -> SpecialProductFragment.newInstance(post)
            5 -> SpecialProductFragment.newInstance(bundling)
            else -> ProductFragment.newInstance(promo, isAdmin, param3 = false, param4 = true)
        }
    }

    override fun getPageTitle(position: Int): CharSequence {
        return when (position) {
            0 -> "KUOTA"
            1 -> "NOMOR CANTIK"
            2 -> "SALES"
            3 -> "PULSA"
            4 -> "POST PAID"
            5 -> "BUNDLING"
            else -> "PROMO"
        }
    }

    override fun getCount(): Int {
        return if (isAdmin) 7 else 6
    }
}