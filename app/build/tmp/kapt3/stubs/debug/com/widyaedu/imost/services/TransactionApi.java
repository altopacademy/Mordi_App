package com.widyaedu.imost.services;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J7\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00040\u00032\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ3\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00040\u00032\u0014\b\u0001\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\rH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ3\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00040\u00032\u0014\b\u0001\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\rH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0011"}, d2 = {"Lcom/widyaedu/imost/services/TransactionApi;", "", "listMyTransaction", "Lcom/widyaedu/imost/restapi/apiresponse/ApiResponse;", "Lcom/widyaedu/imost/model/BaseResponse;", "", "Lcom/widyaedu/imost/model/Transaction;", "userId", "", "role", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setTransaction", "item", "", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateStatus", "status", "app_debug"})
public abstract interface TransactionApi {
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "transaction/create")
    @retrofit2.http.Headers(value = {"x-api-key: 18be70c0-4e4d-44ff-a475-50c51ece99a3"})
    public abstract java.lang.Object setTransaction(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    java.util.Map<java.lang.String, java.lang.String> item, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.widyaedu.imost.restapi.apiresponse.ApiResponse<com.widyaedu.imost.model.BaseResponse<com.widyaedu.imost.model.Transaction>>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "transaction")
    @retrofit2.http.Headers(value = {"x-api-key: 18be70c0-4e4d-44ff-a475-50c51ece99a3"})
    public abstract java.lang.Object listMyTransaction(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "user_id")
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "role")
    java.lang.String role, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.widyaedu.imost.restapi.apiresponse.ApiResponse<com.widyaedu.imost.model.BaseResponse<java.util.List<com.widyaedu.imost.model.Transaction>>>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "transaction/verify")
    @retrofit2.http.Headers(value = {"x-api-key: 18be70c0-4e4d-44ff-a475-50c51ece99a3"})
    public abstract java.lang.Object updateStatus(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    java.util.Map<java.lang.String, java.lang.String> status, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.widyaedu.imost.restapi.apiresponse.ApiResponse<com.widyaedu.imost.model.BaseResponse<com.widyaedu.imost.model.Transaction>>> continuation);
}