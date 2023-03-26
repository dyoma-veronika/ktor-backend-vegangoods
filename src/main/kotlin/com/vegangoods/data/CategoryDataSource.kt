package com.vegangoods.data

import com.vegangoods.data.model.Category

interface CategoryDataSource {

    suspend fun getCategoriesByCountry(countryName: String): List<Category>
}
