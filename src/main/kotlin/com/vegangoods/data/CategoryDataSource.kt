package com.vegangoods.data

import com.vegangoods.data.model.Category

interface CategoryDataSource {
    suspend fun getAllCategories(): List<Category>
    suspend fun getCategoriesByCountry(countryName: String): List<Category>
    suspend fun addCategory(category: Category)
}
