package com.widyaedu.imost.restapi

import com.widyaedu.imost.BuildConfig
import com.widyaedu.imost.restapi.apiresponse.ApiResponseCallAdapterFactory
import com.widyaedu.imost.services.UserApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class BaseRest {
    val httploging = HttpLoggingInterceptor()


    private fun buildRetrofit(): Retrofit {
        httploging.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder().addInterceptor(httploging).build()
        return Retrofit.Builder().baseUrl(BuildConfig.BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(ApiResponseCallAdapterFactory())
            .build()
    }

    fun api(): UserApi {
        return buildRetrofit().create(UserApi::class.java)
    }

    fun <T> createService(service: Class<T>): T {
        return buildRetrofit().create(service)
    }


}