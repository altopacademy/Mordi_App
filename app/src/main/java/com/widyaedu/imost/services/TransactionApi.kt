package com.widyaedu.imost.services

import com.widyaedu.imost.BuildConfig
import com.widyaedu.imost.model.BaseResponse
import com.widyaedu.imost.model.Transaction
import com.widyaedu.imost.restapi.apiresponse.ApiResponse
import retrofit2.http.*

interface TransactionApi {
    @Headers("x-api-key: ${BuildConfig.API_KEY}")
    @POST("transaction/create")
    suspend fun setTransaction(@Body item: Map<String, String>): ApiResponse<BaseResponse<Transaction>>

    @Headers("x-api-key: ${BuildConfig.API_KEY}")
    @GET("transaction")
    suspend fun listMyTransaction(
        @Query("user_id") userId: String,
        @Query("role") role: String,
    ): ApiResponse<BaseResponse<List<Transaction>>>

    @Headers("x-api-key: ${BuildConfig.API_KEY}")
    @POST("transaction/verify")
    suspend fun updateStatus(@Body status: Map<String, String>): ApiResponse<BaseResponse<Transaction>>
}