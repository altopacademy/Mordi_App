package com.widyaedu.imost.services

import com.widyaedu.imost.BuildConfig
import com.widyaedu.imost.model.BaseResponse
import com.widyaedu.imost.model.ChatData
import com.widyaedu.imost.restapi.apiresponse.ApiResponse
import retrofit2.http.*

interface RoomChatApi {
    @Headers("x-api-key: ${BuildConfig.API_KEY}")
    @POST("room/create")
    suspend fun addRoomCode(@Body data: Map<String, String?>): ApiResponse<BaseResponse<ChatData>>

    @Headers("x-api-key: ${BuildConfig.API_KEY}")
    @GET("room")
    suspend fun listHistory(@Query("user_id")userId: String): ApiResponse<BaseResponse<List<ChatData>>>
}