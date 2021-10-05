package com.widyaedu.imost.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.widyaedu.imost.model.*
import com.widyaedu.imost.model.salesmodel.SalesAchiev
import com.widyaedu.imost.restapi.BaseRest
import com.widyaedu.imost.restapi.apiresponse.ApiErrorResponse
import com.widyaedu.imost.restapi.apiresponse.ApiSuccessResponse
import com.widyaedu.imost.services.*
import kotlinx.coroutines.launch

@Suppress("UNREACHABLE_CODE")
class ItemViewModel : ViewModel() {
    //user
    var user = MutableLiveData<BaseResponse<User>>()
    var status = MutableLiveData<Boolean>()
    var newUser = MutableLiveData<User>()
    var salesInfo = MutableLiveData<Sales>()

    //produk
    var productItem = MutableLiveData<List<ProductItem>>()
    var promoData = MutableLiveData<List<BannerModel>>()
    var producStatus = MutableLiveData<BaseResponse<List<ProductItem>>>()
    var productDetail = MutableLiveData<ProductItem>()
    var productMaster = MutableLiveData<ProductItem>()
    //transaction

    //city
    var cityItem = MutableLiveData<List<CityItem>>()

    //for user
    fun getUserByEmail(email: String) = viewModelScope.launch {
        status.value = true
        when (val apiResponse = BaseRest().createService(UserApi::class.java).getEmail(email)) {
            is ApiSuccessResponse -> {
                //Log.d(getClassName(), "getUser: ${apiResponse.body}")
                user.postValue(apiResponse.body)
                newUser.postValue(apiResponse.body.data)
            }
            is ApiErrorResponse -> {
                //Log.e(getClassName(), "getUser: $apiResponse")
            }
        }
    }

    fun getUserByPhone(phoneNumb: String) = viewModelScope.launch {
        status.value = true
        when (val apiResponse = BaseRest().createService(UserApi::class.java).getPhone(phoneNumb)) {
            is ApiSuccessResponse -> {
                //Log.d(getClassName(), "getUser: ${apiResponse.body}")
                user.postValue(apiResponse.body)
                newUser.postValue(apiResponse.body.data)
            }
            is ApiErrorResponse -> {
                //Log.e(getClassName(), "getUser: $apiResponse")
            }
        }
    }

    fun getUserById(id: String) = viewModelScope.launch {
        status.value = true
        when (val apiResponse = BaseRest().createService(UserApi::class.java).getUserId(id)) {
            is ApiSuccessResponse -> {
                //Log.d(getClassName(), "getUser: ${apiResponse.body}")
                user.postValue(apiResponse.body)
            }
            is ApiErrorResponse -> {
                //Log.e(getClassName(), "getUser: $apiResponse")
            }
        }
    }

    fun setUser(name: String, photo: String?=null, email: String?=null, phoneNumb: String?=null, callback: (User) -> Unit) =
        viewModelScope.launch {
            status.value = true
            val payload = mapOf(
                "name" to name,
                "photo" to photo,
                "email" to email,
                "phone_number" to phoneNumb,
                "city_id" to "3171",
                "role" to "Customer"
            )
            when (val apiResponse =
                BaseRest().createService(UserApi::class.java).setUser(payload)) {
                is ApiSuccessResponse -> {
                    newUser.postValue(apiResponse.body.data)
                    callback(apiResponse.body.data)
                }
                is ApiErrorResponse -> {

                }
            }
        }



    //sales

    fun getSalesId(userId: String) = viewModelScope.launch {
        status.value = true
        when (val apiResponse = BaseRest().createService(UserApi::class.java).getSalesId(userId)) {
            is ApiSuccessResponse -> {
                salesInfo.postValue(apiResponse.body.data)
            }
            is ApiErrorResponse -> {

            }
        }
    }

    fun addSales(email: String, name: String, desc: String, cityId: String) =
        viewModelScope.launch {
            status.value = true
            val salesData = mapOf(
                "email" to email,
                "name" to name,
                "description" to desc,
                "city_id" to cityId
            )
            when (val apiResponse =
                BaseRest().createService(UserApi::class.java).addSales(salesData)) {
                is ApiSuccessResponse -> {
                    salesInfo.postValue(apiResponse.body.data)
                    //Log.d(getClassName(), "addSales: ${apiResponse.body.data}")
                    //Log.d(getClassName(), "datanya: ${salesData}")
                }
                is ApiErrorResponse -> {

                }
            }
        }

    fun updateProfile(userId: String,
                      name: String,
                      desc: String,
                      email: String,
                      phoneNumb: String? = null,
                      appleId: String?=null,
                      photo: String,
                      cityId: String)=
        viewModelScope.launch {
            val data = mapOf(
                "user_id" to userId,
                "name" to name,
                "description" to desc,
                "email" to email,
                "phone_number" to phoneNumb,
                "appleid" to appleId,
            "photo" to photo,
            "city_id" to cityId)
            status.value = true
            when(val apiResponse = BaseRest().createService(UserApi::class.java).updateUser(data)){
                is ApiSuccessResponse -> {
                    newUser.postValue(apiResponse.body.data)
                }
                is ApiErrorResponse -> {
                    //Log.e(getClassName(), "updateProfile: ${apiResponse.errorMessage}" )
                }
            }
    }

    fun deleteSales(userId: String) = viewModelScope.launch {
        status.value = true
        val id = mapOf(
            "user_id" to userId
        )
        when(val apiResponse = BaseRest().createService(UserApi::class.java).deleteSales(id)){
            is ApiSuccessResponse -> {
                newUser.postValue(apiResponse.body.data)
            }
            is ApiErrorResponse -> {
                //Log.e(getClassName(), "deleteSales: ${apiResponse.errorMessage}")
            }
        }
    }

    var salesData = MutableLiveData<SalesAchiev>()
    fun getSalesAchiev(userId: String, startDate: String?=null, endDate: String?=null)=viewModelScope.launch{
        status.value = true
        when(val apiResponse = BaseRest().createService(UserApi::class.java).listAchievSales(userId, startDate.toString(),
            endDate.toString())){
            is ApiSuccessResponse -> {
                salesData.postValue(apiResponse.body.data)
            }
            is ApiErrorResponse -> {
                //Log.e(getClassName(), "deleteSales: ${apiResponse.errorMessage}")
            }
        }
    }


    //for produk

    lateinit var pulsa: List<ProductItem>
    lateinit var post: List<ProductMaster>
    lateinit var bundling: List<ProductMaster>
    lateinit var kuota: List<ProductItem>
    lateinit var nomor: List<ProductItem>
    var sales = MutableLiveData<List<Sales>>()

    fun getProduct(
        type: String,
        cityId: String = "",
        role: String,
        keyword: String = "",
        id: String = "",
    ) =
        viewModelScope.launch {
            status.value = true
            when (val apiResponse =
                BaseRest().createService(ProductApi::class.java)
                    .getProductList(type, cityId, role, keyword, id)) {
                is ApiSuccessResponse -> {
                    productItem.postValue(apiResponse.body.data)
                    producStatus.postValue(apiResponse.body)
                    //Log.d(getClassName(), "getProduct: ${apiResponse.body}")
                }
                is ApiErrorResponse -> {
                    //Log.e(getClassName(), "getProduct: ${apiResponse}")
                }
            }
        }

    fun getSales(cityId: String = "", role: String, keyword: String = "") = viewModelScope.launch {
        status.value = true

        when (val apiResponse = BaseRest().createService(ProductApi::class.java)
            .getProductList("kuota", cityId, role, keyword)) {
            is ApiSuccessResponse -> {
                kuota = apiResponse.body.data
            }
            is ApiErrorResponse -> {

            }
        }

        when (val apiResponse = BaseRest().createService(ProductApi::class.java)
            .getProductList("nomor_cantik", cityId, role, keyword)) {
            is ApiSuccessResponse -> {
                nomor = apiResponse.body.data
            }
            is ApiErrorResponse -> {

            }
        }

        when (val apiResponse = BaseRest().createService(ProductApi::class.java)
            .getProductList("pulsa", cityId, role, keyword)) {
            is ApiSuccessResponse -> {
                pulsa = apiResponse.body.data
            }
            is ApiErrorResponse -> {

            }
        }

        when (val apiResponse = BaseRest().createService(ProductApi::class.java)
            .getProductListMaster("post_paid")) {
            is ApiSuccessResponse -> {
                post = apiResponse.body.data
            }
            is ApiErrorResponse -> {

            }
        }

        when (val apiResponse = BaseRest().createService(ProductApi::class.java)
            .getProductListMaster("bundling")) {
            is ApiSuccessResponse -> {
                bundling = apiResponse.body.data
            }
            is ApiErrorResponse -> {

            }
        }

        when (val apiResponse = BaseRest().createService(UserApi::class.java).getSales(cityId)) {
            is ApiSuccessResponse -> {
                sales.postValue(apiResponse.body.data)
            }
            is ApiErrorResponse -> {

            }
        }
    }

    fun getPromo(cityId: String = "", role: String, keyword: String = "") = viewModelScope.launch {
        status.value = true
        when (val apiResponse =
            BaseRest().createService(ProductApi::class.java)
                .getPromo(cityId = cityId, role = role, key = keyword)) {
            is ApiSuccessResponse -> {
                promoData.postValue(apiResponse.body.data)
                //Log.d(getClassName(), "getProduct: ${apiResponse.body}")
            }
            is ApiErrorResponse -> {
                //Log.e(getClassName(), "getProduct: $apiResponse")
            }
        }
    }

    fun getDetailProduct(id: String) = viewModelScope.launch {
        status.value = true
        when (val apiResponse =
            BaseRest().createService(ProductApi::class.java).getProductDetail(id)) {
            is ApiSuccessResponse -> {
                productDetail.postValue(apiResponse.body.data)
                //Log.d(getClassName(), "getDetail ${apiResponse.body}")
            }
            is ApiErrorResponse -> {
                //Log.e(getClassName(), "getProduct: ${apiResponse}")
            }
        }
    }


    fun addProduct(
        userId: String,
        type: String,
        id: String,
        price: String,
        state: String,
        photo: String?,
        name: String = "",
        description: String = "",
    ) = viewModelScope.launch {
        val item = mapOf(
            "type" to type,
            "user_id" to userId,
            "product_id" to id,
            "price" to price,
            "status" to state,
            "name" to name,
            "description" to description,
            "photo" to photo
        )
        status.value = true
        when (val apiResponse =
            BaseRest().createService(ProductApi::class.java).addItemProduct(item)) {
            is ApiSuccessResponse -> {
                productDetail.postValue(apiResponse.body.data)

            }
            is ApiErrorResponse -> {

            }
        }
    }

    fun addProductMaster(
        type: String,
        price: String,
        photo: String?,
        name: String = "",
        description: String = "",
    ) = viewModelScope.launch {
        val item = mapOf(
            "type" to type,
            "price" to price,
            "name" to name,
            "description" to description,
            "photo" to photo
        )
        status.value = true
        when (val apiResponse =
            BaseRest().createService(ProductApi::class.java).addItemProductMaster(item)) {
            is ApiSuccessResponse -> {
                productMaster.postValue(apiResponse.body.data)
            }
            is ApiErrorResponse -> {

            }
        }
    }

    fun getMyproduct(type: String, userId: String, role: String) = viewModelScope.launch {
        status.value = true
        when (val apiResponse =
            BaseRest().createService(ProductApi::class.java).getMyProduct(type, userId, role)) {
            is ApiSuccessResponse -> {
                productItem.postValue(apiResponse.body.data)
                producStatus.postValue(apiResponse.body)
            }
            is ApiErrorResponse -> {

            }
        }
    }

    fun updateProduct(
        product_id: String,
        type: String,
        price: String,
        state: String,
    ) = viewModelScope.launch {
        val item = mapOf(
            "product_details_id" to product_id,
            "type" to type,
            "price" to price,
            "status" to state
        )

        when (val apiResponse =
            BaseRest().createService(ProductApi::class.java).updateProduct(item)) {
            is ApiSuccessResponse -> {
                productDetail.postValue(apiResponse.body.data)
            }
            is ApiErrorResponse -> {
                //Log.e(getClassName(), "updateProduct: ${apiResponse.errorMessage}", )
            }
        }
    }

    fun delete(product_id: String) = viewModelScope.launch {
        val id = mapOf(
            "product_details_id" to product_id
        )
        when(val apiResponse = BaseRest().createService(ProductApi::class.java).deleteProduct(id)){
            is ApiSuccessResponse -> {
                productDetail.postValue(apiResponse.body.data)
            }
            is ApiErrorResponse -> {
                //Log.e(getClassName(), "updateProduct: ${apiResponse.errorMessage}", )
            }
        }
    }

    var productListMaster = MutableLiveData<List<ProductMaster>>()
    fun getProductMaster(type: String, role: String = "Sales", name: String = "") =
        viewModelScope.launch {
            when (val apiResponse = BaseRest().createService(ProductApi::class.java)
                .getProductListMaster(type, role, name)) {
                is ApiSuccessResponse -> {
                    productListMaster.postValue(apiResponse.body.data)
                }

                is ApiErrorResponse -> {

                }
            }
        }

    fun createProductFromMaster(product_id: String, userId: String, price: String) =
        viewModelScope.launch {
            val data = mapOf(
                "product_id" to product_id,
                "user_id" to userId,
                "price" to price
            )

        when(val apiResponse = BaseRest().createService(ProductApi::class.java).createProduct(data)){
            is ApiSuccessResponse -> {
                productDetail.postValue(apiResponse.body.data)
            }
        }
    }
    //transaction
    var newTransact = MutableLiveData<Transaction>()
    var listTransaction = MutableLiveData<List<Transaction>>()
    fun addTransaction(
        product_id: String,
        user_id: String,
        quantity: String,
        type: String,
        callback: (Transaction) -> Unit,
    ) = viewModelScope.launch {
        status.value = true
        val item = mapOf(
            "product_details_id" to product_id,
            "user_id" to user_id,
            "type" to type,
            "quantity" to quantity
        )
        when (val apiResponse =
            BaseRest().createService(TransactionApi::class.java).setTransaction(item)) {
            is ApiSuccessResponse -> {
                newTransact.postValue(apiResponse.body.data)
                callback(apiResponse.body.data)
            }
            is ApiErrorResponse -> {

            }
        }
    }

    fun listHistoryTransact(userId: String, role: String) = viewModelScope.launch {
        status.value = true
        when (val apiResponse =
            BaseRest().createService(TransactionApi::class.java).listMyTransaction(userId, role)) {
            is ApiSuccessResponse -> {
                listTransaction.postValue(apiResponse.body.data)
            }
            is ApiErrorResponse -> {
                //Log.e(getClassName(), "listTransaction: ${apiResponse}")
            }
        }
    }

    fun updateStatus(transactionId: String, user: String, state: String) = viewModelScope.launch {
        status.value = true
        val statusproduct = mapOf(
            "transaction_id" to transactionId,
            "user_id" to user,
            "verify" to state
        )
        when (val apiResponse =
            BaseRest().createService(TransactionApi::class.java).updateStatus(statusproduct)) {
            is ApiSuccessResponse -> {
                newTransact.postValue(apiResponse.body.data)
            }
            is ApiErrorResponse -> {

            }
        }
    }

    //for city
    fun getCityList(name: String = "") = viewModelScope.launch {
        status.value = true
        when (val apiResponse = BaseRest().createService(CityApi::class.java).getCityList(name)) {
            is ApiSuccessResponse -> {
                cityItem.postValue(apiResponse.body.data)
            }
            is ApiErrorResponse -> {
                //Log.e(getClassName(), "getCityList: ${apiResponse}")
            }
        }
    }

    //payment
    var paymentData = MutableLiveData<Payment>()
    var listPayment = MutableLiveData<BaseResponse<List<Payment>>>()
    var listPaymentMaster = MutableLiveData<BaseResponse<List<PaymentMasterModel>>>()
    fun addPayment(userId: String, name: String, desc: String, owner: String) = viewModelScope.launch {
        status.value = true
        val item = mapOf(
            "user_id" to userId,
            "payment_method_id" to name,
            "account_number" to desc,
            "account_name" to owner

        )
        when(val apiResponse = BaseRest().createService(PaymentApi::class.java).setPayment(item)){
            is ApiSuccessResponse -> {
                paymentData.postValue(apiResponse.body.data)
            }
            is ApiErrorResponse -> {
                //Log.e(getClassName(), "getCityList: ${apiResponse.errorMessage}")
            }
        }
    }

    fun listPaymentMaster() = viewModelScope.launch {
        status.value = true
        when (val apiResponse =
            BaseRest().createService(PaymentApi::class.java).listPaymentMaster()) {
            is ApiSuccessResponse -> {
                listPaymentMaster.postValue(apiResponse.body)
            }
            is ApiErrorResponse -> {
                //Log.e(getClassName(), "listMyPayment: ${apiResponse.errorMessage}")
            }
        }
    }

    fun listMyPayment(userId: String) = viewModelScope.launch {
        status.value = true
        when (val apiResponse =
            BaseRest().createService(PaymentApi::class.java).listPayment(userId)) {
            is ApiSuccessResponse -> {
                listPayment.postValue(apiResponse.body)
            }
            is ApiErrorResponse -> {
                //Log.e(getClassName(), "listMyPayment: ${apiResponse.errorMessage}")
            }
        }
    }

    fun paymentbyId(paymentId: String) = viewModelScope.launch {
        when (val apiResponse =
            BaseRest().createService(PaymentApi::class.java).paymentDetail(paymentId)) {
            is ApiSuccessResponse -> {
                paymentData.postValue(apiResponse.body.data)
            }
            is ApiErrorResponse -> {
                //Log.e(getClassName(), "paymentbyId: ${apiResponse.errorMessage}", )
            }
        }
    }


    fun updatePayment(paymentId: String, desc: String, owner: String) = viewModelScope.launch {
        val item = mapOf(
            "payment_method_details_id" to paymentId,
            "account_number" to desc,
            "account_name" to owner
        )

        when (val apiResponse = BaseRest().createService(PaymentApi::class.java).updatePayment(item)){
            is ApiSuccessResponse -> {
                paymentData.postValue(apiResponse.body.data)
            }
            is ApiErrorResponse -> {
                //Log.e(getClassName(), "listMyPayment: ${apiResponse.errorMessage}")
            }
        }
    }
    //roomchat
    var chat = MutableLiveData<BaseResponse<ChatData>>()
    var listChat = MutableLiveData<List<ChatData>>()
    fun addnewRoom(salesId: String, customerId: String, callback: (BaseResponse<ChatData>) -> Unit) = viewModelScope.launch {
        status.value = true
        val item = mapOf(
            "sales_id" to salesId,
            "customer_id" to customerId
        )
        when (val apiResponse = BaseRest().createService(RoomChatApi::class.java).addRoomCode(item)){
            is ApiSuccessResponse -> {
                chat.postValue(apiResponse.body)
                callback(apiResponse.body)
            }
            is ApiErrorResponse -> {
                //Log.e(getClassName(), "codeFailed: ${apiResponse.errorMessage}")
            }
        }

    }

    fun listHistoryChat(userId: String) = viewModelScope.launch {
        status.value = true
        when (val apiResponse = BaseRest().createService(RoomChatApi::class.java).listHistory(userId)){
            is ApiSuccessResponse -> {
                listChat.postValue(apiResponse.body.data)
            }
            is ApiErrorResponse -> {
                //Log.e(getClassName(), "listHistoryChat: ${apiResponse.errorMessage}" )
            }
        }
    }

    //rating
    val ratingdata = MutableLiveData<RatingModel>()
    val listrating = MutableLiveData<List<RatingModel>>()
    fun addRating(transactionId: String, userId: String, rating: String, notes: String) = viewModelScope.launch {
        status.value = true
        val data = mapOf(
            "transaction_id" to transactionId,
            "user_id" to userId,
            "rating" to rating,
            "notes" to notes
        )
        when(val apiResponse = BaseRest().createService(RatingApi::class.java).addRating(data)){
            is ApiSuccessResponse -> {
                ratingdata.postValue(apiResponse.body.data)
            }
            is ApiErrorResponse -> {
                //Log.e(getClassName(), "addRating: ${apiResponse.errorMessage}")
            }
        }
    }

    fun listRating(userId: String) = viewModelScope.launch {
        status.value = true
        when(val apiResponse = BaseRest().createService(RatingApi::class.java).listRating(userId)){
            is ApiSuccessResponse -> {
                listrating.postValue(apiResponse.body.data)
            }
            is ApiErrorResponse -> {
                //Log.e(getClassName(), "listRating: ${apiResponse.errorMessage}")
            }
        }
    }

}