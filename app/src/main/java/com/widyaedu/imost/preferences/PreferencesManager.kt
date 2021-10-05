package com.widyaedu.imost.preferences

import android.content.Context


class PreferencesManager(context: Context) {
    private val sp = context.getSharedPreferences("user_pref", Context.MODE_PRIVATE)


    fun setCity(city: String) {
        val spe = sp.edit()
        spe.putString(CITY, city)
        spe.apply()
    }

    fun getCity(): String {
        return sp.getString(CITY, "1101").toString()
    }

    fun setUserId(userId: String) {
        val spe = sp.edit()
        spe.putString(USER_ID, userId)
        spe.apply()
    }

    fun getUser(): String {
        return sp.getString(USER_ID, "").toString()
    }

    fun setRole(role: String) {
        val spe = sp.edit()
        spe.putString(ROLE, role)
        spe.apply()
    }

    fun getRole(): String {
        return sp.getString(ROLE, "").toString()
    }

    fun setPhoto(photo: String){
        val spe = sp.edit()
        spe.putString(PHOTO, photo)
        spe.apply()
    }

    fun getPhoto(): String {
        return sp.getString(PHOTO, "").toString()
    }

    fun putWelcomed() {
        sp.edit().putBoolean(WELCOMED, true).apply()
    }

    fun isWelcomed(): Boolean {
        return sp.getBoolean(WELCOMED, false)
    }

    companion object {
        private const val WELCOMED = "welcomed"
        private const val USER_ID = "userId_pref"
        private const val CITY = "city"
        private const val ROLE = "role_pref"
        private const val PHOTO = "photo"
    }
}