package com.widyaedu.imost.services;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J-\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00040\u00032\b\b\u0001\u0010\u0007\u001a\u00020\bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ#\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00050\u00040\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ\'\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00040\u00032\b\b\u0001\u0010\u000e\u001a\u00020\bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ3\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00040\u00032\u0014\b\u0001\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0011H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012J3\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00040\u00032\u0014\b\u0001\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0011H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0014"}, d2 = {"Lcom/widyaedu/imost/services/PaymentApi;", "", "listPayment", "Lcom/widyaedu/imost/restapi/apiresponse/ApiResponse;", "Lcom/widyaedu/imost/model/BaseResponse;", "", "Lcom/widyaedu/imost/model/Payment;", "userId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "listPaymentMaster", "Lcom/widyaedu/imost/model/PaymentMasterModel;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "paymentDetail", "paymentId", "setPayment", "payload", "", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updatePayment", "app_debug"})
public abstract interface PaymentApi {
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "payment_method/create")
    @retrofit2.http.Headers(value = {"x-api-key: 18be70c0-4e4d-44ff-a475-50c51ece99a3"})
    public abstract java.lang.Object setPayment(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    java.util.Map<java.lang.String, java.lang.String> payload, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.widyaedu.imost.restapi.apiresponse.ApiResponse<com.widyaedu.imost.model.BaseResponse<com.widyaedu.imost.model.Payment>>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "payment_method")
    @retrofit2.http.Headers(value = {"x-api-key: 18be70c0-4e4d-44ff-a475-50c51ece99a3"})
    public abstract java.lang.Object listPayment(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "user_id")
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.widyaedu.imost.restapi.apiresponse.ApiResponse<com.widyaedu.imost.model.BaseResponse<java.util.List<com.widyaedu.imost.model.Payment>>>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "payment_method/master")
    @retrofit2.http.Headers(value = {"x-api-key: 18be70c0-4e4d-44ff-a475-50c51ece99a3"})
    public abstract java.lang.Object listPaymentMaster(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.widyaedu.imost.restapi.apiresponse.ApiResponse<com.widyaedu.imost.model.BaseResponse<java.util.List<com.widyaedu.imost.model.PaymentMasterModel>>>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "payment_method/by_id")
    @retrofit2.http.Headers(value = {"x-api-key: 18be70c0-4e4d-44ff-a475-50c51ece99a3"})
    public abstract java.lang.Object paymentDetail(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "payment_method_details_id")
    java.lang.String paymentId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.widyaedu.imost.restapi.apiresponse.ApiResponse<com.widyaedu.imost.model.BaseResponse<com.widyaedu.imost.model.Payment>>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "payment_method/update")
    @retrofit2.http.Headers(value = {"x-api-key: 18be70c0-4e4d-44ff-a475-50c51ece99a3"})
    public abstract java.lang.Object updatePayment(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    java.util.Map<java.lang.String, java.lang.String> payload, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.widyaedu.imost.restapi.apiresponse.ApiResponse<com.widyaedu.imost.model.BaseResponse<com.widyaedu.imost.model.Payment>>> continuation);
}