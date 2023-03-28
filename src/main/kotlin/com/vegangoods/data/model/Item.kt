package com.vegangoods.data.model

import kotlinx.serialization.Serializable
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

@Serializable
data class Item(
    @BsonId
    var id: String = ObjectId().toString(),
    val country: Country,
    val shop: List<Shop>,
    val category: Category,
    val subcategory: Subcategory,
    val originalName: String,
    val translatedName: String,
    val ingredients: String,
    val price: Double,
    val quantity: String,
    val imageUrl: String
)
