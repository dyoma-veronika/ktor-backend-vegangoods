package com.vegangoods.data

import com.vegangoods.data.model.Category
import com.vegangoods.data.model.Subcategory
import org.litote.kmongo.coroutine.CoroutineDatabase
import org.litote.kmongo.eq

class SubcategoryDataSourceImpl(
    private val db: CoroutineDatabase
) : SubcategoryDataSource {

    private val subcategories = db.getCollection<Subcategory>()
    private val categories = db.getCollection<Category>()

    override suspend fun getSubcategoriesByCategory(categoryName: String): List<Subcategory> {
        val category = categories.findOne(categoryName)
        return subcategories.find(Subcategory::category eq category).toList()
    }
}
