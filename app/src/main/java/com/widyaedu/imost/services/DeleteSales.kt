package com.widyaedu.imost.services

import com.widyaedu.imost.model.Sales

interface DeleteSales {
    fun deleteSales(sales: Sales)
    fun editSales(sales: Sales)
}