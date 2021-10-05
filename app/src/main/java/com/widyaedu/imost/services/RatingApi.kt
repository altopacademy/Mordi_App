package com.widyaedu.imost.services

import com.widyaedu.imost.BuildConfig
import com.widyaedu.imost.model.BaseResponse
import com.widyaedu.imost.model.RatingModel
import com.widyaedu.imost.restapi.apiresponse.ApiResponse
import retrofit2.http.*

interface RatingApi {
    @Headers("x-api-key: ${BuildConfig.API_KEY}")
    @POST("rating/create")
    suspend fun addRating(@Body data: Map<String, String>): ApiResponse<BaseResponse<RatingModel>>

    @Headers("x-api-key: ${BuildConfig.API_KEY}")
    @GET("rating")
    suspend fun listRating(@Query("user_id")userId: String): ApiResponse<BaseResponse<List<RatingModel>>>
}