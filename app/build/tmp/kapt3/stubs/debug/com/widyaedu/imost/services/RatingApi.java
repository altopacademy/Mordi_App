package com.widyaedu.imost.services;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J3\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0014\b\u0001\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ-\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000b0\u00040\u00032\b\b\u0001\u0010\f\u001a\u00020\bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000e"}, d2 = {"Lcom/widyaedu/imost/services/RatingApi;", "", "addRating", "Lcom/widyaedu/imost/restapi/apiresponse/ApiResponse;", "Lcom/widyaedu/imost/model/BaseResponse;", "Lcom/widyaedu/imost/model/RatingModel;", "data", "", "", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "listRating", "", "userId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface RatingApi {
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "rating/create")
    @retrofit2.http.Headers(value = {"x-api-key: 18be70c0-4e4d-44ff-a475-50c51ece99a3"})
    public abstract java.lang.Object addRating(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    java.util.Map<java.lang.String, java.lang.String> data, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.widyaedu.imost.restapi.apiresponse.ApiResponse<com.widyaedu.imost.model.BaseResponse<com.widyaedu.imost.model.RatingModel>>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "rating")
    @retrofit2.http.Headers(value = {"x-api-key: 18be70c0-4e4d-44ff-a475-50c51ece99a3"})
    public abstract java.lang.Object listRating(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "user_id")
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.widyaedu.imost.restapi.apiresponse.ApiResponse<com.widyaedu.imost.model.BaseResponse<java.util.List<com.widyaedu.imost.model.RatingModel>>>> continuation);
}