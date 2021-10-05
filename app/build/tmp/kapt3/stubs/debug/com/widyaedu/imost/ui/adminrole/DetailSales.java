package com.widyaedu.imost.ui.adminrole;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001c\u001dB\u0005\u00a2\u0006\u0002\u0010\u0002J \u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000eH\u0002J\u0012\u0010\u0013\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0015J\u000e\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\fJ\b\u0010\u0018\u001a\u00020\u0010H\u0003J\u0010\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u001bH\u0003R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"Lcom/widyaedu/imost/ui/adminrole/DetailSales;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/widyaedu/imost/databinding/ActivityDetailSalesBinding;", "btmDate", "Lcom/widyaedu/imost/databinding/BottomDatepickBinding;", "dialog", "Lcom/google/android/material/bottomsheet/BottomSheetDialog;", "itemViewModel", "Lcom/widyaedu/imost/viewmodel/ItemViewModel;", "mListener", "Lcom/widyaedu/imost/ui/adminrole/DetailSales$DateData;", "salesId", "", "getDateSales", "", "start", "end", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setDate", "listener", "showDate", "showGauge", "salesAchiev", "Lcom/widyaedu/imost/model/salesmodel/SalesAchiev;", "Companion", "DateData", "app_debug"})
public final class DetailSales extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.NotNull()
    public static final com.widyaedu.imost.ui.adminrole.DetailSales.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SALESID = "SalesID";
    private com.widyaedu.imost.databinding.ActivityDetailSalesBinding binding;
    private com.widyaedu.imost.databinding.BottomDatepickBinding btmDate;
    private com.google.android.material.bottomsheet.BottomSheetDialog dialog;
    private com.widyaedu.imost.viewmodel.ItemViewModel itemViewModel;
    private com.widyaedu.imost.ui.adminrole.DetailSales.DateData mListener;
    private java.lang.String salesId = "";
    private java.util.HashMap _$_findViewCache;
    
    public DetailSales() {
        super();
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.N)
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.N)
    private final void showDate() {
    }
    
    private final void getDateSales(java.lang.String start, java.lang.String end) {
    }
    
    @android.annotation.SuppressLint(value = {"SetTextI18n"})
    private final void showGauge(com.widyaedu.imost.model.salesmodel.SalesAchiev salesAchiev) {
    }
    
    public final void setDate(@org.jetbrains.annotations.NotNull()
    com.widyaedu.imost.ui.adminrole.DetailSales.DateData listener) {
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H&\u00a8\u0006\b"}, d2 = {"Lcom/widyaedu/imost/ui/adminrole/DetailSales$DateData;", "", "date", "", "salesId", "", "start", "end", "app_debug"})
    public static abstract interface DateData {
        
        public abstract void date(@org.jetbrains.annotations.NotNull()
        java.lang.String salesId, @org.jetbrains.annotations.NotNull()
        java.lang.String start, @org.jetbrains.annotations.NotNull()
        java.lang.String end);
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/widyaedu/imost/ui/adminrole/DetailSales$Companion;", "", "()V", "SALESID", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}