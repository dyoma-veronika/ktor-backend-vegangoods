package com.vegangoods.data

import com.vegangoods.data.model.Item

interface ItemDataSource {

    suspend fun getItemsBySubcategory(countryName: String, categoryName: String, subcategoryName: String): List<Item>
}
