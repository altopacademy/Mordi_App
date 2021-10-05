package com.widyaedu.imost.viewmodel;

import java.lang.System;

@kotlin.Suppress(names = {"UNREACHABLE_CODE"})
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b!\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J&\u0010f\u001a\u00020g2\u0006\u0010h\u001a\u00020i2\u0006\u0010j\u001a\u00020i2\u0006\u0010k\u001a\u00020i2\u0006\u0010l\u001a\u00020iJL\u0010m\u001a\u00020g2\u0006\u0010h\u001a\u00020i2\u0006\u0010n\u001a\u00020i2\u0006\u0010o\u001a\u00020i2\u0006\u0010p\u001a\u00020i2\u0006\u0010q\u001a\u00020i2\b\u0010r\u001a\u0004\u0018\u00010i2\b\b\u0002\u0010j\u001a\u00020i2\b\b\u0002\u0010s\u001a\u00020iJ4\u0010t\u001a\u00020g2\u0006\u0010n\u001a\u00020i2\u0006\u0010p\u001a\u00020i2\b\u0010r\u001a\u0004\u0018\u00010i2\b\b\u0002\u0010j\u001a\u00020i2\b\b\u0002\u0010s\u001a\u00020iJ&\u0010u\u001a\u00020g2\u0006\u0010v\u001a\u00020i2\u0006\u0010h\u001a\u00020i2\u0006\u0010w\u001a\u00020i2\u0006\u0010x\u001a\u00020iJ&\u0010y\u001a\u00020g2\u0006\u0010z\u001a\u00020i2\u0006\u0010j\u001a\u00020i2\u0006\u0010k\u001a\u00020i2\u0006\u0010{\u001a\u00020iJ=\u0010|\u001a\u00020g2\u0006\u0010}\u001a\u00020i2\u0006\u0010~\u001a\u00020i2\u0006\u0010\u007f\u001a\u00020i2\u0006\u0010n\u001a\u00020i2\u0015\u0010\u0080\u0001\u001a\u0010\u0012\u0004\u0012\u00020&\u0012\u0005\u0012\u00030\u0082\u00010\u0081\u0001J6\u0010\u0083\u0001\u001a\u00020g2\u0007\u0010\u0084\u0001\u001a\u00020i2\u0007\u0010\u0085\u0001\u001a\u00020i2\u001b\u0010\u0080\u0001\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0005\u0012\u00030\u0082\u00010\u0081\u0001J\u001f\u0010\u0086\u0001\u001a\u00020g2\u0006\u0010}\u001a\u00020i2\u0006\u0010h\u001a\u00020i2\u0006\u0010p\u001a\u00020iJ\u000f\u0010\u0087\u0001\u001a\u00020g2\u0006\u0010}\u001a\u00020iJ\u000f\u0010\u0088\u0001\u001a\u00020g2\u0006\u0010h\u001a\u00020iJ\u0011\u0010\u0089\u0001\u001a\u00020g2\b\b\u0002\u0010j\u001a\u00020iJ\u000f\u0010\u008a\u0001\u001a\u00020g2\u0006\u0010o\u001a\u00020iJ \u0010\u008b\u0001\u001a\u00020g2\u0006\u0010n\u001a\u00020i2\u0006\u0010h\u001a\u00020i2\u0007\u0010\u008c\u0001\u001a\u00020iJ7\u0010\u008d\u0001\u001a\u00020g2\u0006\u0010n\u001a\u00020i2\b\b\u0002\u0010{\u001a\u00020i2\u0007\u0010\u008c\u0001\u001a\u00020i2\t\b\u0002\u0010\u008e\u0001\u001a\u00020i2\b\b\u0002\u0010o\u001a\u00020iJ#\u0010I\u001a\u00020g2\u0006\u0010n\u001a\u00020i2\t\b\u0002\u0010\u008c\u0001\u001a\u00020i2\b\b\u0002\u0010j\u001a\u00020iJ%\u0010\u008f\u0001\u001a\u00020g2\b\b\u0002\u0010{\u001a\u00020i2\u0007\u0010\u008c\u0001\u001a\u00020i2\t\b\u0002\u0010\u008e\u0001\u001a\u00020iJ$\u0010V\u001a\u00020g2\b\b\u0002\u0010{\u001a\u00020i2\u0007\u0010\u008c\u0001\u001a\u00020i2\t\b\u0002\u0010\u008e\u0001\u001a\u00020iJ)\u0010\u0090\u0001\u001a\u00020g2\u0006\u0010h\u001a\u00020i2\u000b\b\u0002\u0010\u0091\u0001\u001a\u0004\u0018\u00010i2\u000b\b\u0002\u0010\u0092\u0001\u001a\u0004\u0018\u00010iJ\u000f\u0010\u0093\u0001\u001a\u00020g2\u0006\u0010h\u001a\u00020iJ\u000f\u0010\u0094\u0001\u001a\u00020g2\u0006\u0010z\u001a\u00020iJ\u000f\u0010\u0095\u0001\u001a\u00020g2\u0006\u0010o\u001a\u00020iJ\u0010\u0010\u0096\u0001\u001a\u00020g2\u0007\u0010\u0097\u0001\u001a\u00020iJ\u000f\u0010\u0098\u0001\u001a\u00020g2\u0006\u0010h\u001a\u00020iJ\u0018\u0010\u0099\u0001\u001a\u00020g2\u0006\u0010h\u001a\u00020i2\u0007\u0010\u008c\u0001\u001a\u00020iJ\u000f\u0010\u009a\u0001\u001a\u00020g2\u0006\u0010h\u001a\u00020iJ\u0006\u0010!\u001a\u00020gJ\u000f\u0010\u009b\u0001\u001a\u00020g2\u0006\u0010h\u001a\u00020iJ\u0010\u0010\u009c\u0001\u001a\u00020g2\u0007\u0010\u009d\u0001\u001a\u00020iJJ\u0010e\u001a\u00020g2\u0006\u0010j\u001a\u00020i2\n\b\u0002\u0010r\u001a\u0004\u0018\u00010i2\n\b\u0002\u0010z\u001a\u0004\u0018\u00010i2\u000b\b\u0002\u0010\u0097\u0001\u001a\u0004\u0018\u00010i2\u0015\u0010\u0080\u0001\u001a\u0010\u0012\u0004\u0012\u000200\u0012\u0005\u0012\u00030\u0082\u00010\u0081\u0001J \u0010\u009e\u0001\u001a\u00020g2\u0007\u0010\u009d\u0001\u001a\u00020i2\u0006\u0010k\u001a\u00020i2\u0006\u0010l\u001a\u00020iJ\'\u0010\u009f\u0001\u001a\u00020g2\u0006\u0010}\u001a\u00020i2\u0006\u0010n\u001a\u00020i2\u0006\u0010p\u001a\u00020i2\u0006\u0010q\u001a\u00020iJQ\u0010\u00a0\u0001\u001a\u00020g2\u0006\u0010h\u001a\u00020i2\u0006\u0010j\u001a\u00020i2\u0006\u0010k\u001a\u00020i2\u0006\u0010z\u001a\u00020i2\u000b\b\u0002\u0010\u0097\u0001\u001a\u0004\u0018\u00010i2\u000b\b\u0002\u0010\u00a1\u0001\u001a\u0004\u0018\u00010i2\u0006\u0010r\u001a\u00020i2\u0006\u0010{\u001a\u00020iJ\u001f\u0010\u00a2\u0001\u001a\u00020g2\u0006\u0010v\u001a\u00020i2\u0006\u0010c\u001a\u00020i2\u0006\u0010q\u001a\u00020iR \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR&\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R&\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00040\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R \u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0007\"\u0004\b\u0019\u0010\tR&\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00040\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000f\"\u0004\b\u001c\u0010\u0011R,\u0010\u001d\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u00040\f0\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u000f\"\u0004\b \u0010\u0011R,\u0010!\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0\u00040\f0\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u000f\"\u0004\b$\u0010\u0011R&\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0\u00040\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010\u000f\"\u0004\b(\u0010\u0011R\u001d\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0\u00040\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010\u000fR \u0010,\u001a\b\u0012\u0004\u0012\u00020&0\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u000f\"\u0004\b.\u0010\u0011R \u0010/\u001a\b\u0012\u0004\u0012\u0002000\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u000f\"\u0004\b2\u0010\u0011R \u00103\u001a\b\u0012\u0004\u0012\u00020\u00170\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0007\"\u0004\b5\u0010\tR \u00106\u001a\b\u0012\u0004\u0012\u00020\u001e0\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u000f\"\u0004\b8\u0010\u0011R \u00109\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0007\"\u0004\b;\u0010\tR,\u0010<\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00040\f0\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u000f\"\u0004\b>\u0010\u0011R \u0010?\u001a\b\u0012\u0004\u0012\u00020\u00170\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u000f\"\u0004\bA\u0010\u0011R&\u0010B\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00040\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u000f\"\u0004\bD\u0010\u0011R&\u0010E\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\u000f\"\u0004\bG\u0010\u0011R \u0010H\u001a\b\u0012\u0004\u0012\u00020\u00170\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\u000f\"\u0004\bJ\u0010\u0011R&\u0010K\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020L0\u00040\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bM\u0010\u000f\"\u0004\bN\u0010\u0011R \u0010O\u001a\b\u0012\u0004\u0012\u00020\u00170\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bP\u0010\u0007\"\u0004\bQ\u0010\tR\u0017\u0010R\u001a\b\u0012\u0004\u0012\u00020*0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\bS\u0010\u000fR&\u0010T\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020U0\u00040\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bV\u0010\u000f\"\u0004\bW\u0010\u0011R \u0010X\u001a\b\u0012\u0004\u0012\u00020Y0\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010\u000f\"\u0004\b[\u0010\u0011R \u0010\\\u001a\b\u0012\u0004\u0012\u00020U0\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b]\u0010\u000f\"\u0004\b^\u0010\u0011R \u0010_\u001a\b\u0012\u0004\u0012\u00020`0\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\ba\u0010\u000f\"\u0004\bb\u0010\u0011R&\u0010c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002000\f0\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bd\u0010\u000f\"\u0004\be\u0010\u0011\u00a8\u0006\u00a3\u0001"}, d2 = {"Lcom/widyaedu/imost/viewmodel/ItemViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "bundling", "", "Lcom/widyaedu/imost/model/ProductMaster;", "getBundling", "()Ljava/util/List;", "setBundling", "(Ljava/util/List;)V", "chat", "Landroidx/lifecycle/MutableLiveData;", "Lcom/widyaedu/imost/model/BaseResponse;", "Lcom/widyaedu/imost/model/ChatData;", "getChat", "()Landroidx/lifecycle/MutableLiveData;", "setChat", "(Landroidx/lifecycle/MutableLiveData;)V", "cityItem", "Lcom/widyaedu/imost/model/CityItem;", "getCityItem", "setCityItem", "kuota", "Lcom/widyaedu/imost/model/ProductItem;", "getKuota", "setKuota", "listChat", "getListChat", "setListChat", "listPayment", "Lcom/widyaedu/imost/model/Payment;", "getListPayment", "setListPayment", "listPaymentMaster", "Lcom/widyaedu/imost/model/PaymentMasterModel;", "getListPaymentMaster", "setListPaymentMaster", "listTransaction", "Lcom/widyaedu/imost/model/Transaction;", "getListTransaction", "setListTransaction", "listrating", "Lcom/widyaedu/imost/model/RatingModel;", "getListrating", "newTransact", "getNewTransact", "setNewTransact", "newUser", "Lcom/widyaedu/imost/model/User;", "getNewUser", "setNewUser", "nomor", "getNomor", "setNomor", "paymentData", "getPaymentData", "setPaymentData", "post", "getPost", "setPost", "producStatus", "getProducStatus", "setProducStatus", "productDetail", "getProductDetail", "setProductDetail", "productItem", "getProductItem", "setProductItem", "productListMaster", "getProductListMaster", "setProductListMaster", "productMaster", "getProductMaster", "setProductMaster", "promoData", "Lcom/widyaedu/imost/model/BannerModel;", "getPromoData", "setPromoData", "pulsa", "getPulsa", "setPulsa", "ratingdata", "getRatingdata", "sales", "Lcom/widyaedu/imost/model/Sales;", "getSales", "setSales", "salesData", "Lcom/widyaedu/imost/model/salesmodel/SalesAchiev;", "getSalesData", "setSalesData", "salesInfo", "getSalesInfo", "setSalesInfo", "status", "", "getStatus", "setStatus", "user", "getUser", "setUser", "addPayment", "Lkotlinx/coroutines/Job;", "userId", "", "name", "desc", "owner", "addProduct", "type", "id", "price", "state", "photo", "description", "addProductMaster", "addRating", "transactionId", "rating", "notes", "addSales", "email", "cityId", "addTransaction", "product_id", "user_id", "quantity", "callback", "Lkotlin/Function1;", "", "addnewRoom", "salesId", "customerId", "createProductFromMaster", "delete", "deleteSales", "getCityList", "getDetailProduct", "getMyproduct", "role", "getProduct", "keyword", "getPromo", "getSalesAchiev", "startDate", "endDate", "getSalesId", "getUserByEmail", "getUserById", "getUserByPhone", "phoneNumb", "listHistoryChat", "listHistoryTransact", "listMyPayment", "listRating", "paymentbyId", "paymentId", "updatePayment", "updateProduct", "updateProfile", "appleId", "updateStatus", "app_debug"})
public final class ItemViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<com.widyaedu.imost.model.BaseResponse<com.widyaedu.imost.model.User>> user;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<java.lang.Boolean> status;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<com.widyaedu.imost.model.User> newUser;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<com.widyaedu.imost.model.Sales> salesInfo;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<java.util.List<com.widyaedu.imost.model.ProductItem>> productItem;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<java.util.List<com.widyaedu.imost.model.BannerModel>> promoData;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<com.widyaedu.imost.model.BaseResponse<java.util.List<com.widyaedu.imost.model.ProductItem>>> producStatus;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<com.widyaedu.imost.model.ProductItem> productDetail;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<com.widyaedu.imost.model.ProductItem> productMaster;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<java.util.List<com.widyaedu.imost.model.CityItem>> cityItem;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<com.widyaedu.imost.model.salesmodel.SalesAchiev> salesData;
    public java.util.List<com.widyaedu.imost.model.ProductItem> pulsa;
    public java.util.List<com.widyaedu.imost.model.ProductMaster> post;
    public java.util.List<com.widyaedu.imost.model.ProductMaster> bundling;
    public java.util.List<com.widyaedu.imost.model.ProductItem> kuota;
    public java.util.List<com.widyaedu.imost.model.ProductItem> nomor;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<java.util.List<com.widyaedu.imost.model.Sales>> sales;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<java.util.List<com.widyaedu.imost.model.ProductMaster>> productListMaster;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<com.widyaedu.imost.model.Transaction> newTransact;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<java.util.List<com.widyaedu.imost.model.Transaction>> listTransaction;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<com.widyaedu.imost.model.Payment> paymentData;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<com.widyaedu.imost.model.BaseResponse<java.util.List<com.widyaedu.imost.model.Payment>>> listPayment;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<com.widyaedu.imost.model.BaseResponse<java.util.List<com.widyaedu.imost.model.PaymentMasterModel>>> listPaymentMaster;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<com.widyaedu.imost.model.BaseResponse<com.widyaedu.imost.model.ChatData>> chat;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<java.util.List<com.widyaedu.imost.model.ChatData>> listChat;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.widyaedu.imost.model.RatingModel> ratingdata = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.widyaedu.imost.model.RatingModel>> listrating = null;
    
    public ItemViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.widyaedu.imost.model.BaseResponse<com.widyaedu.imost.model.User>> getUser() {
        return null;
    }
    
    public final void setUser(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<com.widyaedu.imost.model.BaseResponse<com.widyaedu.imost.model.User>> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> getStatus() {
        return null;
    }
    
    public final void setStatus(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.lang.Boolean> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.widyaedu.imost.model.User> getNewUser() {
        return null;
    }
    
    public final void setNewUser(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<com.widyaedu.imost.model.User> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.widyaedu.imost.model.Sales> getSalesInfo() {
        return null;
    }
    
    public final void setSalesInfo(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<com.widyaedu.imost.model.Sales> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.List<com.widyaedu.imost.model.ProductItem>> getProductItem() {
        return null;
    }
    
    public final void setProductItem(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.util.List<com.widyaedu.imost.model.ProductItem>> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.List<com.widyaedu.imost.model.BannerModel>> getPromoData() {
        return null;
    }
    
    public final void setPromoData(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.util.List<com.widyaedu.imost.model.BannerModel>> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.widyaedu.imost.model.BaseResponse<java.util.List<com.widyaedu.imost.model.ProductItem>>> getProducStatus() {
        return null;
    }
    
    public final void setProducStatus(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<com.widyaedu.imost.model.BaseResponse<java.util.List<com.widyaedu.imost.model.ProductItem>>> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.widyaedu.imost.model.ProductItem> getProductDetail() {
        return null;
    }
    
    public final void setProductDetail(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<com.widyaedu.imost.model.ProductItem> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.widyaedu.imost.model.ProductItem> getProductMaster() {
        return null;
    }
    
    public final void setProductMaster(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<com.widyaedu.imost.model.ProductItem> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.List<com.widyaedu.imost.model.CityItem>> getCityItem() {
        return null;
    }
    
    public final void setCityItem(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.util.List<com.widyaedu.imost.model.CityItem>> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job getUserByEmail(@org.jetbrains.annotations.NotNull()
    java.lang.String email) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job getUserByPhone(@org.jetbrains.annotations.NotNull()
    java.lang.String phoneNumb) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job getUserById(@org.jetbrains.annotations.NotNull()
    java.lang.String id) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job setUser(@org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.Nullable()
    java.lang.String photo, @org.jetbrains.annotations.Nullable()
    java.lang.String email, @org.jetbrains.annotations.Nullable()
    java.lang.String phoneNumb, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.widyaedu.imost.model.User, kotlin.Unit> callback) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job getSalesId(@org.jetbrains.annotations.NotNull()
    java.lang.String userId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job addSales(@org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String desc, @org.jetbrains.annotations.NotNull()
    java.lang.String cityId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job updateProfile(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String desc, @org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.Nullable()
    java.lang.String phoneNumb, @org.jetbrains.annotations.Nullable()
    java.lang.String appleId, @org.jetbrains.annotations.NotNull()
    java.lang.String photo, @org.jetbrains.annotations.NotNull()
    java.lang.String cityId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job deleteSales(@org.jetbrains.annotations.NotNull()
    java.lang.String userId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.widyaedu.imost.model.salesmodel.SalesAchiev> getSalesData() {
        return null;
    }
    
    public final void setSalesData(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<com.widyaedu.imost.model.salesmodel.SalesAchiev> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job getSalesAchiev(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.Nullable()
    java.lang.String startDate, @org.jetbrains.annotations.Nullable()
    java.lang.String endDate) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.widyaedu.imost.model.ProductItem> getPulsa() {
        return null;
    }
    
    public final void setPulsa(@org.jetbrains.annotations.NotNull()
    java.util.List<com.widyaedu.imost.model.ProductItem> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.widyaedu.imost.model.ProductMaster> getPost() {
        return null;
    }
    
    public final void setPost(@org.jetbrains.annotations.NotNull()
    java.util.List<com.widyaedu.imost.model.ProductMaster> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.widyaedu.imost.model.ProductMaster> getBundling() {
        return null;
    }
    
    public final void setBundling(@org.jetbrains.annotations.NotNull()
    java.util.List<com.widyaedu.imost.model.ProductMaster> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.widyaedu.imost.model.ProductItem> getKuota() {
        return null;
    }
    
    public final void setKuota(@org.jetbrains.annotations.NotNull()
    java.util.List<com.widyaedu.imost.model.ProductItem> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.widyaedu.imost.model.ProductItem> getNomor() {
        return null;
    }
    
    public final void setNomor(@org.jetbrains.annotations.NotNull()
    java.util.List<com.widyaedu.imost.model.ProductItem> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.List<com.widyaedu.imost.model.Sales>> getSales() {
        return null;
    }
    
    public final void setSales(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.util.List<com.widyaedu.imost.model.Sales>> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job getProduct(@org.jetbrains.annotations.NotNull()
    java.lang.String type, @org.jetbrains.annotations.NotNull()
    java.lang.String cityId, @org.jetbrains.annotations.NotNull()
    java.lang.String role, @org.jetbrains.annotations.NotNull()
    java.lang.String keyword, @org.jetbrains.annotations.NotNull()
    java.lang.String id) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job getSales(@org.jetbrains.annotations.NotNull()
    java.lang.String cityId, @org.jetbrains.annotations.NotNull()
    java.lang.String role, @org.jetbrains.annotations.NotNull()
    java.lang.String keyword) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job getPromo(@org.jetbrains.annotations.NotNull()
    java.lang.String cityId, @org.jetbrains.annotations.NotNull()
    java.lang.String role, @org.jetbrains.annotations.NotNull()
    java.lang.String keyword) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job getDetailProduct(@org.jetbrains.annotations.NotNull()
    java.lang.String id) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job addProduct(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    java.lang.String type, @org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    java.lang.String price, @org.jetbrains.annotations.NotNull()
    java.lang.String state, @org.jetbrains.annotations.Nullable()
    java.lang.String photo, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String description) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job addProductMaster(@org.jetbrains.annotations.NotNull()
    java.lang.String type, @org.jetbrains.annotations.NotNull()
    java.lang.String price, @org.jetbrains.annotations.Nullable()
    java.lang.String photo, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String description) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job getMyproduct(@org.jetbrains.annotations.NotNull()
    java.lang.String type, @org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    java.lang.String role) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job updateProduct(@org.jetbrains.annotations.NotNull()
    java.lang.String product_id, @org.jetbrains.annotations.NotNull()
    java.lang.String type, @org.jetbrains.annotations.NotNull()
    java.lang.String price, @org.jetbrains.annotations.NotNull()
    java.lang.String state) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job delete(@org.jetbrains.annotations.NotNull()
    java.lang.String product_id) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.List<com.widyaedu.imost.model.ProductMaster>> getProductListMaster() {
        return null;
    }
    
    public final void setProductListMaster(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.util.List<com.widyaedu.imost.model.ProductMaster>> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job getProductMaster(@org.jetbrains.annotations.NotNull()
    java.lang.String type, @org.jetbrains.annotations.NotNull()
    java.lang.String role, @org.jetbrains.annotations.NotNull()
    java.lang.String name) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job createProductFromMaster(@org.jetbrains.annotations.NotNull()
    java.lang.String product_id, @org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    java.lang.String price) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.widyaedu.imost.model.Transaction> getNewTransact() {
        return null;
    }
    
    public final void setNewTransact(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<com.widyaedu.imost.model.Transaction> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.List<com.widyaedu.imost.model.Transaction>> getListTransaction() {
        return null;
    }
    
    public final void setListTransaction(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.util.List<com.widyaedu.imost.model.Transaction>> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job addTransaction(@org.jetbrains.annotations.NotNull()
    java.lang.String product_id, @org.jetbrains.annotations.NotNull()
    java.lang.String user_id, @org.jetbrains.annotations.NotNull()
    java.lang.String quantity, @org.jetbrains.annotations.NotNull()
    java.lang.String type, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.widyaedu.imost.model.Transaction, kotlin.Unit> callback) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job listHistoryTransact(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    java.lang.String role) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job updateStatus(@org.jetbrains.annotations.NotNull()
    java.lang.String transactionId, @org.jetbrains.annotations.NotNull()
    java.lang.String user, @org.jetbrains.annotations.NotNull()
    java.lang.String state) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job getCityList(@org.jetbrains.annotations.NotNull()
    java.lang.String name) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.widyaedu.imost.model.Payment> getPaymentData() {
        return null;
    }
    
    public final void setPaymentData(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<com.widyaedu.imost.model.Payment> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.widyaedu.imost.model.BaseResponse<java.util.List<com.widyaedu.imost.model.Payment>>> getListPayment() {
        return null;
    }
    
    public final void setListPayment(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<com.widyaedu.imost.model.BaseResponse<java.util.List<com.widyaedu.imost.model.Payment>>> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.widyaedu.imost.model.BaseResponse<java.util.List<com.widyaedu.imost.model.PaymentMasterModel>>> getListPaymentMaster() {
        return null;
    }
    
    public final void setListPaymentMaster(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<com.widyaedu.imost.model.BaseResponse<java.util.List<com.widyaedu.imost.model.PaymentMasterModel>>> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job addPayment(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String desc, @org.jetbrains.annotations.NotNull()
    java.lang.String owner) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job listPaymentMaster() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job listMyPayment(@org.jetbrains.annotations.NotNull()
    java.lang.String userId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job paymentbyId(@org.jetbrains.annotations.NotNull()
    java.lang.String paymentId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job updatePayment(@org.jetbrains.annotations.NotNull()
    java.lang.String paymentId, @org.jetbrains.annotations.NotNull()
    java.lang.String desc, @org.jetbrains.annotations.NotNull()
    java.lang.String owner) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.widyaedu.imost.model.BaseResponse<com.widyaedu.imost.model.ChatData>> getChat() {
        return null;
    }
    
    public final void setChat(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<com.widyaedu.imost.model.BaseResponse<com.widyaedu.imost.model.ChatData>> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.List<com.widyaedu.imost.model.ChatData>> getListChat() {
        return null;
    }
    
    public final void setListChat(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.util.List<com.widyaedu.imost.model.ChatData>> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job addnewRoom(@org.jetbrains.annotations.NotNull()
    java.lang.String salesId, @org.jetbrains.annotations.NotNull()
    java.lang.String customerId, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.widyaedu.imost.model.BaseResponse<com.widyaedu.imost.model.ChatData>, kotlin.Unit> callback) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job listHistoryChat(@org.jetbrains.annotations.NotNull()
    java.lang.String userId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.widyaedu.imost.model.RatingModel> getRatingdata() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.List<com.widyaedu.imost.model.RatingModel>> getListrating() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job addRating(@org.jetbrains.annotations.NotNull()
    java.lang.String transactionId, @org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    java.lang.String rating, @org.jetbrains.annotations.NotNull()
    java.lang.String notes) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job listRating(@org.jetbrains.annotations.NotNull()
    java.lang.String userId) {
        return null;
    }
}