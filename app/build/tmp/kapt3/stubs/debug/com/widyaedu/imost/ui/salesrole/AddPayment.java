package com.widyaedu.imost.ui.salesrole;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0012\u0010\u0015\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014J\u0016\u0010\u0018\u001a\u00020\u00112\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lcom/widyaedu/imost/ui/salesrole/AddPayment;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/widyaedu/imost/databinding/ActivityAddPaymentBinding;", "idBank", "", "isEdit", "", "Ljava/lang/Boolean;", "itemViewModel", "Lcom/widyaedu/imost/viewmodel/ItemViewModel;", "namaBank", "paymentId", "pref", "Lcom/widyaedu/imost/preferences/PreferencesManager;", "addRekening", "", "editRekening", "payment", "Lcom/widyaedu/imost/model/Payment;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "showBanklist", "data", "", "Lcom/widyaedu/imost/model/PaymentMasterModel;", "Companion", "app_debug"})
public final class AddPayment extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.NotNull()
    public static final com.widyaedu.imost.ui.salesrole.AddPayment.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EDIT_PAYMENT_EXTRA = "EXTRA_PAYMENT";
    private com.widyaedu.imost.databinding.ActivityAddPaymentBinding binding;
    private com.widyaedu.imost.viewmodel.ItemViewModel itemViewModel;
    private com.widyaedu.imost.preferences.PreferencesManager pref;
    private java.lang.String namaBank = "";
    private java.lang.String idBank = "";
    private java.lang.Boolean isEdit;
    private java.lang.String paymentId = "";
    private java.util.HashMap _$_findViewCache;
    
    public AddPayment() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void showBanklist(java.util.List<com.widyaedu.imost.model.PaymentMasterModel> data) {
    }
    
    private final void addRekening() {
    }
    
    private final void editRekening(com.widyaedu.imost.model.Payment payment) {
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/widyaedu/imost/ui/salesrole/AddPayment$Companion;", "", "()V", "EDIT_PAYMENT_EXTRA", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}