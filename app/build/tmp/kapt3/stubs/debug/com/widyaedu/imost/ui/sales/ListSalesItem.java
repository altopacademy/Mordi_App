package com.widyaedu.imost.ui.sales;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\u0012\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014J\u0010\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0018\u0010\u0018\u001a\u00020\u00112\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aH\u0002J\u0016\u0010\u001c\u001a\u00020\u00112\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\t0\u001aH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"Lcom/widyaedu/imost/ui/sales/ListSalesItem;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/widyaedu/imost/databinding/ActivityListSalesItemBinding;", "city_id", "", "listCity", "", "Lcom/widyaedu/imost/model/CityItem;", "pref", "Lcom/widyaedu/imost/preferences/PreferencesManager;", "productViewModel", "Lcom/widyaedu/imost/viewmodel/ItemViewModel;", "searchableSpinner", "Lcom/toptoche/searchablespinnerlibrary/SearchableSpinner;", "back", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "showLoading", "state", "", "showSales", "sales", "", "Lcom/widyaedu/imost/model/Sales;", "showSpinner", "itemCity", "app_debug"})
public final class ListSalesItem extends androidx.appcompat.app.AppCompatActivity {
    private com.widyaedu.imost.databinding.ActivityListSalesItemBinding binding;
    private com.widyaedu.imost.viewmodel.ItemViewModel productViewModel;
    private com.toptoche.searchablespinnerlibrary.SearchableSpinner searchableSpinner;
    private java.lang.String city_id;
    private java.util.List<com.widyaedu.imost.model.CityItem> listCity;
    private com.widyaedu.imost.preferences.PreferencesManager pref;
    private java.util.HashMap _$_findViewCache;
    
    public ListSalesItem() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void showSales(java.util.List<com.widyaedu.imost.model.Sales> sales) {
    }
    
    private final void showSpinner(java.util.List<com.widyaedu.imost.model.CityItem> itemCity) {
    }
    
    private final void back() {
    }
    
    private final void showLoading(boolean state) {
    }
}