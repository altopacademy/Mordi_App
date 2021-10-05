package com.widyaedu.imost.listener

import com.widyaedu.imost.model.ProductItem

interface ProductListener {
    fun editProduct(product: ProductItem)
    fun deleteProduct(productId: String)
}