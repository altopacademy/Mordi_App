package com.widyaedu.imost.ui.product;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0010\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0014\u001a\u00020\u0006H\u0002J\b\u0010\u0015\u001a\u00020\u0012H\u0002J\u0012\u0010\u0016\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014J\u0010\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0016\u0010\u001c\u001a\u00020\u00122\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\t0\u001eH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2 = {"Lcom/widyaedu/imost/ui/product/ListProductActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/widyaedu/imost/databinding/ActivityListProductBinding;", "cityId", "", "listCity", "", "Lcom/widyaedu/imost/model/CityItem;", "pref", "Lcom/widyaedu/imost/preferences/PreferencesManager;", "productViewModel", "Lcom/widyaedu/imost/viewmodel/ItemViewModel;", "searchableSpinner", "Lcom/toptoche/searchablespinnerlibrary/SearchableSpinner;", "type", "back", "", "getType", "role", "initSearch", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "showLoading", "state", "", "showSpinner", "itemCity", "", "Companion", "app_debug"})
public final class ListProductActivity extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.NotNull()
    public static final com.widyaedu.imost.ui.product.ListProductActivity.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PRODUCT_TYPE = "type";
    private com.widyaedu.imost.databinding.ActivityListProductBinding binding;
    private com.widyaedu.imost.viewmodel.ItemViewModel productViewModel;
    private com.toptoche.searchablespinnerlibrary.SearchableSpinner searchableSpinner;
    private java.lang.String cityId = "";
    private java.util.List<com.widyaedu.imost.model.CityItem> listCity;
    private com.widyaedu.imost.preferences.PreferencesManager pref;
    private java.lang.String type = "";
    private java.util.HashMap _$_findViewCache;
    
    public ListProductActivity() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initSearch() {
    }
    
    private final void showSpinner(java.util.List<com.widyaedu.imost.model.CityItem> itemCity) {
    }
    
    private final void back() {
    }
    
    private final void getType(java.lang.String type, java.lang.String role) {
    }
    
    private final void showLoading(boolean state) {
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/widyaedu/imost/ui/product/ListProductActivity$Companion;", "", "()V", "PRODUCT_TYPE", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}