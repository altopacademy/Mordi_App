package com.widyaedu.imost.adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0017B#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\b\u0010\r\u001a\u00020\u000eH\u0016J\u001c\u0010\u000f\u001a\u00020\u00102\n\u0010\u0011\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\u001c\u0010\u0013\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000eH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0018"}, d2 = {"Lcom/widyaedu/imost/adapter/TransactionAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/widyaedu/imost/adapter/TransactionAdapter$TransactionHolder;", "listener", "Lcom/widyaedu/imost/listener/SendStatus;", "item", "", "Lcom/widyaedu/imost/model/Transaction;", "role", "", "(Lcom/widyaedu/imost/listener/SendStatus;Ljava/util/List;Ljava/lang/String;)V", "getRole", "()Ljava/lang/String;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "TransactionHolder", "app_debug"})
public final class TransactionAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.widyaedu.imost.adapter.TransactionAdapter.TransactionHolder> {
    private final com.widyaedu.imost.listener.SendStatus listener = null;
    private final java.util.List<com.widyaedu.imost.model.Transaction> item = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String role = null;
    
    public TransactionAdapter(@org.jetbrains.annotations.NotNull()
    com.widyaedu.imost.listener.SendStatus listener, @org.jetbrains.annotations.NotNull()
    java.util.List<com.widyaedu.imost.model.Transaction> item, @org.jetbrains.annotations.NotNull()
    java.lang.String role) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRole() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.widyaedu.imost.adapter.TransactionAdapter.TransactionHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.widyaedu.imost.adapter.TransactionAdapter.TransactionHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012R\u0019\u0010\u0005\u001a\n \u0006*\u0004\u0018\u00010\u00030\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0019\u0010\t\u001a\n \u0006*\u0004\u0018\u00010\u00030\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0013"}, d2 = {"Lcom/widyaedu/imost/adapter/TransactionAdapter$TransactionHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/widyaedu/imost/adapter/TransactionAdapter;Landroid/view/View;)V", "btmRating", "kotlin.jvm.PlatformType", "getBtmRating", "()Landroid/view/View;", "btmSheet", "getBtmSheet", "dialog", "Lcom/google/android/material/bottomsheet/BottomSheetDialog;", "getDialog", "()Lcom/google/android/material/bottomsheet/BottomSheetDialog;", "initView", "", "transaction", "Lcom/widyaedu/imost/model/Transaction;", "app_debug"})
    public final class TransactionHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final android.view.View btmSheet = null;
        private final android.view.View btmRating = null;
        @org.jetbrains.annotations.NotNull()
        private final com.google.android.material.bottomsheet.BottomSheetDialog dialog = null;
        
        public TransactionHolder(@org.jetbrains.annotations.NotNull()
        android.view.View itemView) {
            super(null);
        }
        
        public final android.view.View getBtmSheet() {
            return null;
        }
        
        public final android.view.View getBtmRating() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.google.android.material.bottomsheet.BottomSheetDialog getDialog() {
            return null;
        }
        
        public final void initView(@org.jetbrains.annotations.Nullable()
        com.widyaedu.imost.model.Transaction transaction) {
        }
    }
}