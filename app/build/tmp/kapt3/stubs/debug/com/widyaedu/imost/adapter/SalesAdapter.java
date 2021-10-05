package com.widyaedu.imost.adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B1\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000eH\u0016J\u0010\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u0007H\u0002J\u0010\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u0007H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/widyaedu/imost/adapter/SalesAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/widyaedu/imost/adapter/SalesAdapter$SalesHolder;", "context", "Landroid/content/Context;", "sales", "", "Lcom/widyaedu/imost/model/Sales;", "roles", "", "listener", "Lcom/widyaedu/imost/services/DeleteSales;", "(Landroid/content/Context;Ljava/util/List;Ljava/lang/String;Lcom/widyaedu/imost/services/DeleteSales;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "showBottomEdit", "showDialog", "SalesHolder", "app_debug"})
public final class SalesAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.widyaedu.imost.adapter.SalesAdapter.SalesHolder> {
    private final android.content.Context context = null;
    private final java.util.List<com.widyaedu.imost.model.Sales> sales = null;
    private final java.lang.String roles = null;
    private final com.widyaedu.imost.services.DeleteSales listener = null;
    
    public SalesAdapter(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    java.util.List<com.widyaedu.imost.model.Sales> sales, @org.jetbrains.annotations.NotNull()
    java.lang.String roles, @org.jetbrains.annotations.Nullable()
    com.widyaedu.imost.services.DeleteSales listener) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.widyaedu.imost.adapter.SalesAdapter.SalesHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.widyaedu.imost.adapter.SalesAdapter.SalesHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    private final void showBottomEdit(com.widyaedu.imost.model.Sales sales) {
    }
    
    private final void showDialog(com.widyaedu.imost.model.Sales sales) {
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a8\u0006\t"}, d2 = {"Lcom/widyaedu/imost/adapter/SalesAdapter$SalesHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "setupView", "", "sales", "Lcom/widyaedu/imost/model/Sales;", "app_debug"})
    public static final class SalesHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        
        public SalesHolder(@org.jetbrains.annotations.NotNull()
        android.view.View itemView) {
            super(null);
        }
        
        public final void setupView(@org.jetbrains.annotations.Nullable()
        com.widyaedu.imost.model.Sales sales) {
        }
    }
}