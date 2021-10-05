package com.widyaedu.imost.ui.adminrole;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J(\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u000bH\u0002J\b\u0010\u001f\u001a\u00020\u001bH\u0002J\u0016\u0010 \u001a\u00020\u001b2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00110\"H\u0002J\u0010\u0010#\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\u0013H\u0016J\u0010\u0010%\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\u0013H\u0016J\u0016\u0010&\u001a\u00020\u001b2\f\u0010\'\u001a\b\u0012\u0004\u0012\u00020\u00130\"H\u0002J\u0012\u0010(\u001a\u00020\u001b2\b\u0010)\u001a\u0004\u0018\u00010*H\u0014J\u0016\u0010+\u001a\u00020\u001b2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00110\"H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006-"}, d2 = {"Lcom/widyaedu/imost/ui/adminrole/ManagementSales;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/widyaedu/imost/services/DeleteSales;", "()V", "binding", "Lcom/widyaedu/imost/databinding/ActivityManagementSalesBinding;", "bottomSheetDialog", "Lcom/google/android/material/bottomsheet/BottomSheetDialog;", "btmSheet", "Lcom/widyaedu/imost/databinding/BottomAddSalesBinding;", "cityId", "", "cityId2", "itemViewModel", "Lcom/widyaedu/imost/viewmodel/ItemViewModel;", "listCity", "", "Lcom/widyaedu/imost/model/CityItem;", "listSales", "Lcom/widyaedu/imost/model/Sales;", "myadapter", "Lcom/widyaedu/imost/adapter/SalesAdapter;", "pref", "Lcom/widyaedu/imost/preferences/PreferencesManager;", "searchableSpinner", "Lcom/toptoche/searchablespinnerlibrary/SearchableSpinner;", "addSales", "", "email", "name", "desc", "back", "bottomSheet", "city", "", "deleteSales", "sales", "editSales", "itemSales", "item", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "showSpinner", "itemCity", "app_debug"})
public final class ManagementSales extends androidx.appcompat.app.AppCompatActivity implements com.widyaedu.imost.services.DeleteSales {
    private com.widyaedu.imost.databinding.ActivityManagementSalesBinding binding;
    private com.widyaedu.imost.viewmodel.ItemViewModel itemViewModel;
    private com.google.android.material.bottomsheet.BottomSheetDialog bottomSheetDialog;
    private java.util.List<com.widyaedu.imost.model.CityItem> listCity;
    private java.util.List<com.widyaedu.imost.model.Sales> listSales;
    private java.lang.String cityId;
    private java.lang.String cityId2;
    private com.widyaedu.imost.databinding.BottomAddSalesBinding btmSheet;
    private com.widyaedu.imost.adapter.SalesAdapter myadapter;
    private com.toptoche.searchablespinnerlibrary.SearchableSpinner searchableSpinner;
    private com.widyaedu.imost.preferences.PreferencesManager pref;
    private java.util.HashMap _$_findViewCache;
    
    public ManagementSales() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void itemSales(java.util.List<com.widyaedu.imost.model.Sales> item) {
    }
    
    private final void bottomSheet(java.util.List<com.widyaedu.imost.model.CityItem> city) {
    }
    
    private final void addSales(java.lang.String email, java.lang.String name, java.lang.String cityId, java.lang.String desc) {
    }
    
    private final void showSpinner(java.util.List<com.widyaedu.imost.model.CityItem> itemCity) {
    }
    
    private final void back() {
    }
    
    @java.lang.Override()
    public void deleteSales(@org.jetbrains.annotations.NotNull()
    com.widyaedu.imost.model.Sales sales) {
    }
    
    @java.lang.Override()
    public void editSales(@org.jetbrains.annotations.NotNull()
    com.widyaedu.imost.model.Sales sales) {
    }
}