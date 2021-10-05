package com.widyaedu.imost.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0005\u00a2\u0006\u0002\u0010\u0002J(\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\u0011\u001a\u00020\rH\u0016J\u0012\u0010\u0012\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014J\u0018\u0010\u0015\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\nH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/widyaedu/imost/ui/CheckoutActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/widyaedu/imost/databinding/ActivityCheckoutBinding;", "pref", "Lcom/widyaedu/imost/preferences/PreferencesManager;", "productViewModel", "Lcom/widyaedu/imost/viewmodel/ItemViewModel;", "salesId", "", "type", "addTransaction", "", "productId", "userId", "qty", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "showPaymentlist", "nama", "Companion", "app_debug"})
public final class CheckoutActivity extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.NotNull()
    public static final com.widyaedu.imost.ui.CheckoutActivity.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String IDProductCheckout = "EXTRA_ID";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String Quantity = "qty";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String id = "id";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String price = "price";
    private com.widyaedu.imost.databinding.ActivityCheckoutBinding binding;
    private com.widyaedu.imost.viewmodel.ItemViewModel productViewModel;
    private com.widyaedu.imost.preferences.PreferencesManager pref;
    private java.lang.String salesId = "";
    private java.lang.String type = "";
    private java.util.HashMap _$_findViewCache;
    
    public CheckoutActivity() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void addTransaction(java.lang.String productId, java.lang.String userId, java.lang.String qty, java.lang.String type) {
    }
    
    private final void showPaymentlist(java.lang.String userId, java.lang.String nama) {
    }
    
    @java.lang.Override()
    public void onBackPressed() {
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/widyaedu/imost/ui/CheckoutActivity$Companion;", "", "()V", "IDProductCheckout", "", "Quantity", "id", "price", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}