package com.widyaedu.imost.services;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J-\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00040\u00032\b\b\u0003\u0010\u0007\u001a\u00020\bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\n"}, d2 = {"Lcom/widyaedu/imost/services/CityApi;", "", "getCityList", "Lcom/widyaedu/imost/restapi/apiresponse/ApiResponse;", "Lcom/widyaedu/imost/model/BaseResponse;", "", "Lcom/widyaedu/imost/model/CityItem;", "name", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface CityApi {
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "city")
    @retrofit2.http.Headers(value = {"x-api-key: 18be70c0-4e4d-44ff-a475-50c51ece99a3"})
    public abstract java.lang.Object getCityList(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "name")
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.widyaedu.imost.restapi.apiresponse.ApiResponse<com.widyaedu.imost.model.BaseResponse<java.util.List<com.widyaedu.imost.model.CityItem>>>> continuation);
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 3)
    public final class DefaultImpls {
    }
}