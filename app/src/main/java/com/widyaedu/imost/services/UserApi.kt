package com.widyaedu.imost.services

import com.widyaedu.imost.BuildConfig
import com.widyaedu.imost.model.BaseResponse
import com.widyaedu.imost.model.Sales
import com.widyaedu.imost.model.User
import com.widyaedu.imost.model.salesmodel.SalesAchiev
import com.widyaedu.imost.restapi.apiresponse.ApiResponse
import retrofit2.http.*


interface UserApi {
    @Headers("x-api-key: ${BuildConfig.API_KEY}")
    @GET("user/by_email")
    suspend fun getEmail(@Query("email") email: String): ApiResponse<BaseResponse<User>>

    @Headers("x-api-key: ${BuildConfig.API_KEY}")
    @GET("user/by_phone_number")
    suspend fun getPhone(@Query("phone_number") phoneNumber: String): ApiResponse<BaseResponse<User>>

    @Headers("x-api-key: ${BuildConfig.API_KEY}")
    @GET("user/by_id")
    suspend fun getUserId(@Query("user_id") userId: String): ApiResponse<BaseResponse<User>>

    @Headers("x-api-key: ${BuildConfig.API_KEY}")
    @POST("user/create")
    suspend fun setUser(@Body payload: Map<String, String?>): ApiResponse<BaseResponse<User>>

    //Sales
    @Headers("x-api-key: ${BuildConfig.API_KEY}")
    @GET("user")
    suspend fun getSales(
        @Query("city_id") city: String = "",
        @Query("role") role: String = "Sales",
        @Query("keyword") keyword: String = "",
    ): ApiResponse<BaseResponse<List<Sales>>>

    @Headers("x-api-key: ${BuildConfig.API_KEY}")
    @GET("user/by_id")
    suspend fun getSalesId(
        @Query("user_id") city: String = "",
        @Query("role") role: String = "Sales",
    ): ApiResponse<BaseResponse<Sales>>

    @Headers("x-api-key: ${BuildConfig.API_KEY}")
    @POST("user/new_sales")
    suspend fun addSales(@Body payload: Map<String, String>): ApiResponse<BaseResponse<Sales>>

    @Headers("x-api-key: ${BuildConfig.API_KEY}")
    @POST("user/update")
    suspend fun updateUser(@Body data: Map<String, String?>): ApiResponse<BaseResponse<User>>

    @Headers("x-api-key: ${BuildConfig.API_KEY}")
    @POST("user/deactive_sales")
    suspend fun deleteSales(@Body data: Map<String, String>): ApiResponse<BaseResponse<User>>

    @Headers("x-api-key: ${BuildConfig.API_KEY}")
    @GET("user/sales_data")
    suspend fun listAchievSales(@Query("user_id")userId: String,
                                @Query("start_date")startDate: String?=null,
                                @Query("end_date")endDate: String?=null): ApiResponse<BaseResponse<SalesAchiev>>
}

