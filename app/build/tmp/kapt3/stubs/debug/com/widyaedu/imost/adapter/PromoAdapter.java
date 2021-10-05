package com.widyaedu.imost.adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u001cB3\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0002\u0010\fJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u001c\u0010\u0011\u001a\u00020\u00122\n\u0010\u0013\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0010H\u0016J\u001c\u0010\u0015\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0010H\u0016J\u0010\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u0007H\u0002J\u0010\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u0007H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u001d"}, d2 = {"Lcom/widyaedu/imost/adapter/PromoAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/widyaedu/imost/adapter/PromoAdapter$PromoHolder;", "context", "Landroid/app/Activity;", "product", "", "Lcom/widyaedu/imost/model/ProductItem;", "listener", "Lcom/widyaedu/imost/listener/ProductListener;", "role", "", "(Landroid/app/Activity;Ljava/util/List;Lcom/widyaedu/imost/listener/ProductListener;Ljava/lang/String;)V", "getRole", "()Ljava/lang/String;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "showDialog", "productItem", "showEdit", "PromoHolder", "app_debug"})
public final class PromoAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.widyaedu.imost.adapter.PromoAdapter.PromoHolder> {
    private final android.app.Activity context = null;
    private final java.util.List<com.widyaedu.imost.model.ProductItem> product = null;
    private final com.widyaedu.imost.listener.ProductListener listener = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String role = null;
    
    public PromoAdapter(@org.jetbrains.annotations.NotNull()
    android.app.Activity context, @org.jetbrains.annotations.NotNull()
    java.util.List<com.widyaedu.imost.model.ProductItem> product, @org.jetbrains.annotations.Nullable()
    com.widyaedu.imost.listener.ProductListener listener, @org.jetbrains.annotations.Nullable()
    java.lang.String role) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getRole() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.widyaedu.imost.adapter.PromoAdapter.PromoHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.widyaedu.imost.adapter.PromoAdapter.PromoHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    private final void showEdit(com.widyaedu.imost.model.ProductItem product) {
    }
    
    private final void showDialog(com.widyaedu.imost.model.ProductItem productItem) {
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a8\u0006\t"}, d2 = {"Lcom/widyaedu/imost/adapter/PromoAdapter$PromoHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/widyaedu/imost/adapter/PromoAdapter;Landroid/view/View;)V", "initView", "", "item", "Lcom/widyaedu/imost/model/ProductItem;", "app_debug"})
    public final class PromoHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        
        public PromoHolder(@org.jetbrains.annotations.NotNull()
        android.view.View itemView) {
            super(null);
        }
        
        public final void initView(@org.jetbrains.annotations.Nullable()
        com.widyaedu.imost.model.ProductItem item) {
        }
    }
}