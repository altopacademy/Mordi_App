package com.widyaedu.imost.services

import com.widyaedu.imost.BuildConfig
import com.widyaedu.imost.model.BannerModel
import com.widyaedu.imost.model.BaseResponse
import com.widyaedu.imost.model.ProductItem
import com.widyaedu.imost.model.ProductMaster
import com.widyaedu.imost.restapi.apiresponse.ApiResponse
import retrofit2.http.*

interface ProductApi {
    @Headers("x-api-key: ${BuildConfig.API_KEY}")
    @GET("product")
    suspend fun getProductList(
        @Query("type") type: String,
        @Query("city_id") cityId: String = "",
        @Query("role") role: String,
        @Query("name") key: String = "",
        @Query("product_id") productId: String = "",
    ): ApiResponse<BaseResponse<List<ProductItem>>>

    @Headers("x-api-key: ${BuildConfig.API_KEY}")
    @GET("banner")
    suspend fun getPromo(
        @Query("city_id") cityId: String,
        @Query("role") role: String = "",
        @Query("keyword") key: String = "",
        @Query("broadcast_location") broadcast: String = "",
    ): ApiResponse<BaseResponse<List<BannerModel>>>

    @Headers("x-api-key: ${BuildConfig.API_KEY}")
    @GET("product/by_id")
    suspend fun getProductDetail(@Query("product_details_id") productId: String): ApiResponse<BaseResponse<ProductItem>>

    @Headers("x-api-key: ${BuildConfig.API_KEY}")
    @POST("product/create")
    suspend fun addItemProduct(@Body data: Map<String, String?>): ApiResponse<BaseResponse<ProductItem>>

    @Headers("x-api-key: ${BuildConfig.API_KEY}")
    @POST("product/create_master")
    suspend fun addItemProductMaster(@Body data: Map<String, String?>): ApiResponse<BaseResponse<ProductItem>>

    @Headers("x-api-key: ${BuildConfig.API_KEY}")
    @GET("product")
    suspend fun getMyProduct(
        @Query("type") type: String,
        @Query("user_id") userId: String,
        @Query("role") role: String,
    ): ApiResponse<BaseResponse<List<ProductItem>>>

    @Headers("x-api-key: ${BuildConfig.API_KEY}")
    @POST("product/update")
    suspend fun updateProduct(@Body item: Map<String, String?>): ApiResponse<BaseResponse<ProductItem>>

    @Headers("x-api-key: ${BuildConfig.API_KEY}")
    @POST("product/delete")
    suspend fun deleteProduct(@Body item: Map<String, String?>): ApiResponse<BaseResponse<ProductItem>>

    @Headers("x-api-key: ${BuildConfig.API_KEY}")
    @GET("product/master")
    suspend fun getProductListMaster(
        @Query("type") type: String,
        @Query("role") role: String = "",
        @Query("name") name: String = "",
    ): ApiResponse<BaseResponse<List<ProductMaster>>>

    @Headers("x-api-key: ${BuildConfig.API_KEY}")
    @POST("product/create")
    suspend fun createProduct(@Body data: Map<String, String?>): ApiResponse<BaseResponse<ProductItem>>

}