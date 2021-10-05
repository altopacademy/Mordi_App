package com.widyaedu.imost.listener;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&\u00a8\u0006\t"}, d2 = {"Lcom/widyaedu/imost/listener/ProductListener;", "", "deleteProduct", "", "productId", "", "editProduct", "product", "Lcom/widyaedu/imost/model/ProductItem;", "app_debug"})
public abstract interface ProductListener {
    
    public abstract void editProduct(@org.jetbrains.annotations.NotNull()
    com.widyaedu.imost.model.ProductItem product);
    
    public abstract void deleteProduct(@org.jetbrains.annotations.NotNull()
    java.lang.String productId);
}