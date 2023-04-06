package com.vegangoods.data

import com.vegangoods.data.model.Category
import com.vegangoods.data.model.Country
import org.litote.kmongo.coroutine.CoroutineDatabase
import org.litote.kmongo.eq

class CategoryDataSourceImpl(
    private val db: CoroutineDatabase
) : CategoryDataSource {

    private val categories = db.getCollection<Category>()
    private val countries = db.getCollection<Country>()

    override suspend fun getAllCategories(): List<Category> {
        return categories.find().toList()
    }

    override suspend fun getCategoriesByCountry(countryName: String): List<Category> {
        val country = countries.findOne(Country::name eq countryName)
        return categories.find(Category::country eq country).toList()
    }

    override suspend fun addCategory(category: Category) {
        categories.insertOne(category).wasAcknowledged()
    }
}
