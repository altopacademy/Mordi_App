package com.widyaedu.imost.services

import com.widyaedu.imost.BuildConfig
import com.widyaedu.imost.model.BaseResponse
import com.widyaedu.imost.model.Payment
import com.widyaedu.imost.model.PaymentMasterModel
import com.widyaedu.imost.restapi.apiresponse.ApiResponse
import retrofit2.http.*

interface PaymentApi {
    @Headers("x-api-key: ${BuildConfig.API_KEY}")
    @POST("payment_method/create")
    suspend fun setPayment(@Body payload: Map<String, String>): ApiResponse<BaseResponse<Payment>>

    @Headers("x-api-key: ${BuildConfig.API_KEY}")
    @GET("payment_method")
    suspend fun listPayment(@Query("user_id") userId: String): ApiResponse<BaseResponse<List<Payment>>>

    @Headers("x-api-key: ${BuildConfig.API_KEY}")
    @GET("payment_method/master")
    suspend fun listPaymentMaster(): ApiResponse<BaseResponse<List<PaymentMasterModel>>>

    @Headers("x-api-key: ${BuildConfig.API_KEY}")
    @GET("payment_method/by_id")
    suspend fun paymentDetail(@Query("payment_method_details_id") paymentId: String): ApiResponse<BaseResponse<Payment>>

    @Headers("x-api-key: ${BuildConfig.API_KEY}")
    @POST("payment_method/update")
    suspend fun updatePayment(@Body payload: Map<String, String>): ApiResponse<BaseResponse<Payment>>
}