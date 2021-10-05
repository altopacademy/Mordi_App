package com.widyaedu.imost.ui.product;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0012\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\u0012\u0010\u0014\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/widyaedu/imost/ui/product/DetailProductActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/widyaedu/imost/databinding/ActivityDetailProductBinding;", "btmprodukBinding", "Lcom/widyaedu/imost/databinding/BottomMenuAddProductBinding;", "dialog", "Lcom/google/android/material/bottomsheet/BottomSheetDialog;", "pref", "Lcom/widyaedu/imost/preferences/PreferencesManager;", "productViewModel", "Lcom/widyaedu/imost/viewmodel/ItemViewModel;", "role", "", "hideBtn", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "showDetail", "product", "Lcom/widyaedu/imost/model/ProductItem;", "Companion", "app_debug"})
public final class DetailProductActivity extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.NotNull()
    public static final com.widyaedu.imost.ui.product.DetailProductActivity.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String IDProduct = "EXTRA_ID";
    private com.widyaedu.imost.preferences.PreferencesManager pref;
    private com.widyaedu.imost.viewmodel.ItemViewModel productViewModel;
    private com.widyaedu.imost.databinding.ActivityDetailProductBinding binding;
    private com.widyaedu.imost.databinding.BottomMenuAddProductBinding btmprodukBinding;
    private com.google.android.material.bottomsheet.BottomSheetDialog dialog;
    private java.lang.String role = "";
    private java.util.HashMap _$_findViewCache;
    
    public DetailProductActivity() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void showDetail(com.widyaedu.imost.model.ProductItem product) {
    }
    
    private final void hideBtn(java.lang.String role) {
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/widyaedu/imost/ui/product/DetailProductActivity$Companion;", "", "()V", "IDProduct", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}