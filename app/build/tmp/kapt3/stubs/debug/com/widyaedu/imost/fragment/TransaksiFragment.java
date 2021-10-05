package com.widyaedu.imost.fragment;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001e2\u00020\u00012\u00020\u0002:\u0001\u001eB\u0005\u00a2\u0006\u0002\u0010\u0003J\u0016\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\u0010H\u0002J$\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0017J\u0010\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\nH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Lcom/widyaedu/imost/fragment/TransaksiFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/widyaedu/imost/listener/SendStatus;", "()V", "binding", "Lcom/widyaedu/imost/databinding/FragmentTrxBinding;", "itemViewModel", "Lcom/widyaedu/imost/viewmodel/ItemViewModel;", "listTransaction", "", "Lcom/widyaedu/imost/model/Transaction;", "pref", "Lcom/widyaedu/imost/preferences/PreferencesManager;", "getlistTransaction", "", "item", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "setData", "rating", "Lcom/widyaedu/imost/model/RatingModel;", "setStatus", "transaction", "Companion", "app_debug"})
public final class TransaksiFragment extends androidx.fragment.app.Fragment implements com.widyaedu.imost.listener.SendStatus {
    private com.widyaedu.imost.databinding.FragmentTrxBinding binding;
    private com.widyaedu.imost.viewmodel.ItemViewModel itemViewModel;
    private com.widyaedu.imost.preferences.PreferencesManager pref;
    private java.util.List<com.widyaedu.imost.model.Transaction> listTransaction;
    @org.jetbrains.annotations.NotNull()
    public static final com.widyaedu.imost.fragment.TransaksiFragment.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    public TransaksiFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @android.annotation.SuppressLint(value = {"ResourceAsColor"})
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final void getlistTransaction(java.util.List<com.widyaedu.imost.model.Transaction> item) {
    }
    
    @java.lang.Override()
    public void setStatus(@org.jetbrains.annotations.NotNull()
    com.widyaedu.imost.model.Transaction transaction) {
    }
    
    @java.lang.Override()
    public void setData(@org.jetbrains.annotations.NotNull()
    com.widyaedu.imost.model.RatingModel rating) {
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/widyaedu/imost/fragment/TransaksiFragment$Companion;", "", "()V", "newInstance", "Lcom/widyaedu/imost/fragment/TransaksiFragment;", "data", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.widyaedu.imost.fragment.TransaksiFragment newInstance(@org.jetbrains.annotations.NotNull()
        java.lang.String data) {
            return null;
        }
    }
}