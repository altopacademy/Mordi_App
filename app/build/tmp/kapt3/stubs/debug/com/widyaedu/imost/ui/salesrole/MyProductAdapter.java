package com.widyaedu.imost.ui.salesrole;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0013B\u001f\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\nH\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/widyaedu/imost/ui/salesrole/MyProductAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/widyaedu/imost/ui/salesrole/MyProductAdapter$MyProductHolder;", "product", "", "Lcom/widyaedu/imost/model/ProductItem;", "listener", "Lcom/widyaedu/imost/listener/ProductListener;", "(Ljava/util/List;Lcom/widyaedu/imost/listener/ProductListener;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "MyProductHolder", "app_debug"})
public final class MyProductAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.widyaedu.imost.ui.salesrole.MyProductAdapter.MyProductHolder> {
    private final java.util.List<com.widyaedu.imost.model.ProductItem> product = null;
    private final com.widyaedu.imost.listener.ProductListener listener = null;
    
    public MyProductAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<com.widyaedu.imost.model.ProductItem> product, @org.jetbrains.annotations.Nullable()
    com.widyaedu.imost.listener.ProductListener listener) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.widyaedu.imost.ui.salesrole.MyProductAdapter.MyProductHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.widyaedu.imost.ui.salesrole.MyProductAdapter.MyProductHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a8\u0006\t"}, d2 = {"Lcom/widyaedu/imost/ui/salesrole/MyProductAdapter$MyProductHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "setupView", "", "product", "Lcom/widyaedu/imost/model/ProductItem;", "app_debug"})
    public static final class MyProductHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        
        public MyProductHolder(@org.jetbrains.annotations.NotNull()
        android.view.View itemView) {
            super(null);
        }
        
        public final void setupView(@org.jetbrains.annotations.Nullable()
        com.widyaedu.imost.model.ProductItem product) {
        }
    }
}