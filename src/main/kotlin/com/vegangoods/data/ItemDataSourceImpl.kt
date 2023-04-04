package com.vegangoods.data

import com.vegangoods.data.model.Category
import com.vegangoods.data.model.Country
import com.vegangoods.data.model.Item
import com.vegangoods.data.model.Subcategory
import org.litote.kmongo.and
import org.litote.kmongo.coroutine.CoroutineDatabase
import org.litote.kmongo.eq

class ItemDataSourceImpl(
    private val db: CoroutineDatabase
) : ItemDataSource {

    private val items = db.getCollection<Item>()
    private val subcategories = db.getCollection<Subcategory>()
    private val categories = db.getCollection<Category>()
    private val countries = db.getCollection<Country>()

    override suspend fun getItemsBySubcategory(
        countryName: String,
        categoryName: String,
        subcategoryName: String
    ): List<Item> {
        val country = countries.findOne(Country::name eq countryName)
        val category = categories.findOne(and(Category::country eq country, Category::name eq categoryName))
        val subcategory =
            subcategories.findOne(and(Subcategory::category eq category, Subcategory::name eq subcategoryName))
        return items.find(Item::subcategory eq subcategory).toList()
    }
}
