package com.vegangoods.data

import com.vegangoods.data.model.Category
import com.vegangoods.data.model.Item
import com.vegangoods.data.model.Subcategory
import org.litote.kmongo.coroutine.CoroutineDatabase
import org.litote.kmongo.eq

class ItemDataSourceImpl(
    private val db: CoroutineDatabase
) : ItemDataSource {

    private val items = db.getCollection<Item>()
    private val subcategories = db.getCollection<Subcategory>()
    private val categories = db.getCollection<Category>()

    override suspend fun getItemsBySubcategory(subcategoryName: String): List<Item> {
        val subcategory = subcategories.findOne(subcategoryName)
        return items.find(Item::subcategory eq subcategory).toList()
    }

    override suspend fun getItemsByCategory(categoryName: String): List<Item> {
        val category = categories.findOne(categoryName)
        return items.find(Item::category eq category).toList()
    }
}
