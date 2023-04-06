package com.vegangoods.data

import com.vegangoods.data.model.Shop

interface ShopDataSource {
    suspend fun getAllShops(): List<Shop>
    suspend fun getShopsByCountry(countryName: String): List<Shop>
}
