package com.vegangoods.data.model

import kotlinx.serialization.Serializable
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.codecs.pojo.annotations.BsonProperty
import org.bson.types.ObjectId

@Serializable
data class Category(
    @BsonId
    var id: String = ObjectId().toString(),
    val name: String,
    val country: Country,
    val imageUrl: String
)
