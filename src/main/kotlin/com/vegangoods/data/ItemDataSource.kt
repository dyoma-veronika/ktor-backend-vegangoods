package com.vegangoods.data

import com.vegangoods.data.model.Item

interface ItemDataSource {

    suspend fun getItemsBySubcategory(subcategoryName: String): List<Item>

    suspend fun getItemsByCategory(categoryName: String): List<Item>
}
