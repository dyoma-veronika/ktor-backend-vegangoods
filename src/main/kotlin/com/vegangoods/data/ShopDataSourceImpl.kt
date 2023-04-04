package com.vegangoods.data

import com.vegangoods.data.model.Country
import com.vegangoods.data.model.Shop
import org.litote.kmongo.coroutine.CoroutineDatabase
import org.litote.kmongo.eq

class ShopDataSourceImpl(
    private val db: CoroutineDatabase
) : ShopDataSource {

    private val shops = db.getCollection<Shop>()
    private val countries = db.getCollection<Country>()

    override suspend fun getShopsByCountry(countryName: String): List<Shop> {
        val country = countries.findOne(Country::name eq countryName)
        return shops.find(Shop::country eq country).toList()
    }
}
