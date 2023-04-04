package com.vegangoods.data

import com.vegangoods.data.model.Category
import com.vegangoods.data.model.Country
import com.vegangoods.data.model.Subcategory
import org.litote.kmongo.and
import org.litote.kmongo.coroutine.CoroutineDatabase
import org.litote.kmongo.eq

class SubcategoryDataSourceImpl(
    private val db: CoroutineDatabase
) : SubcategoryDataSource {

    private val subcategories = db.getCollection<Subcategory>()
    private val categories = db.getCollection<Category>()
    private val countries = db.getCollection<Country>()

    override suspend fun getSubcategoriesByCategory(countryName: String, categoryName: String): List<Subcategory> {
        val country = countries.findOne(Country::name eq countryName)
        val category = categories.findOne(and(Category::country eq country, Category::name eq categoryName))
        return subcategories.find(Subcategory::category eq category).toList()
    }
}
