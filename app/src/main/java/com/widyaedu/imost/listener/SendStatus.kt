package com.widyaedu.imost.listener

import com.widyaedu.imost.model.RatingModel
import com.widyaedu.imost.model.Transaction


interface SendStatus {
    fun setStatus(transaction: Transaction)
    fun setData(rating: RatingModel)

}