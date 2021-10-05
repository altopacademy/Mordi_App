package com.widyaedu.imost.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014J\u0016\u0010\r\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0002J\u0012\u0010\u0011\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J\u0016\u0010\u0014\u001a\u00020\n2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u000fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/widyaedu/imost/ui/SalesActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/widyaedu/imost/databinding/ActivitySalesBinding;", "pref", "Lcom/widyaedu/imost/preferences/PreferencesManager;", "userViewModel", "Lcom/widyaedu/imost/viewmodel/ItemViewModel;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "showRating", "rating", "", "Lcom/widyaedu/imost/model/RatingModel;", "showSalesInfo", "sales", "Lcom/widyaedu/imost/model/Sales;", "showSalesProduct", "itemList", "Lcom/widyaedu/imost/model/ProductItem;", "Companion", "app_debug"})
public final class SalesActivity extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.NotNull()
    public static final com.widyaedu.imost.ui.SalesActivity.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SALES_ID = "extra_sales";
    private com.widyaedu.imost.databinding.ActivitySalesBinding binding;
    private com.widyaedu.imost.viewmodel.ItemViewModel userViewModel;
    private com.widyaedu.imost.preferences.PreferencesManager pref;
    private java.util.HashMap _$_findViewCache;
    
    public SalesActivity() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void showSalesProduct(java.util.List<com.widyaedu.imost.model.ProductItem> itemList) {
    }
    
    private final void showRating(java.util.List<com.widyaedu.imost.model.RatingModel> rating) {
    }
    
    private final void showSalesInfo(com.widyaedu.imost.model.Sales sales) {
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/widyaedu/imost/ui/SalesActivity$Companion;", "", "()V", "SALES_ID", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}