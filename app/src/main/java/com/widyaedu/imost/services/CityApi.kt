package com.widyaedu.imost.services

import com.widyaedu.imost.BuildConfig
import com.widyaedu.imost.model.BaseResponse
import com.widyaedu.imost.model.CityItem
import com.widyaedu.imost.restapi.apiresponse.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface CityApi {
    @Headers("x-api-key: ${BuildConfig.API_KEY}")
    @GET("city")
    suspend fun getCityList(@Query("name") name: String = ""): ApiResponse<BaseResponse<List<CityItem>>>

}