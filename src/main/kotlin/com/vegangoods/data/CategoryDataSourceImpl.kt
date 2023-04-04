package com.vegangoods.data

import com.vegangoods.data.model.Category
import com.vegangoods.data.model.Country
import org.bson.BsonDocument
import org.litote.kmongo.bson
import org.litote.kmongo.coroutine.CoroutineDatabase
import org.litote.kmongo.eq
import org.litote.kmongo.json
import org.slf4j.LoggerFactory

class CategoryDataSourceImpl(
    private val db: CoroutineDatabase
) : CategoryDataSource {

    private val categories = db.getCollection<Category>()
    private val countries = db.getCollection<Country>()
    val logger = LoggerFactory.getLogger("CategoryDataSourceImpl")

    override suspend fun getCategoriesByCountry(countryName: String): List<Category> {
        val country = countries.findOne(Country::name eq countryName)
        logger.debug("ID" + country?.id)
        return categories.find(Category::country eq country).toList()
    }

    override suspend fun addCategory(category: Category) {
        categories.insertOne(category).wasAcknowledged()
    }
}
