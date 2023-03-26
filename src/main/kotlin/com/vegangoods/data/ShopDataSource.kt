package com.vegangoods.data

import com.vegangoods.data.model.Shop

interface ShopDataSource {

    suspend fun getShopsByCountry(countryName: String): List<Shop>
}
