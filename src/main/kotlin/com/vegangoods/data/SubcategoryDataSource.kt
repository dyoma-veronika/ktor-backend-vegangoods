package com.vegangoods.data

import com.vegangoods.data.model.Subcategory

interface SubcategoryDataSource {

    suspend fun getSubcategoriesByCategory(countryName: String, categoryName: String): List<Subcategory>
}
