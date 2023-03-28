package com.vegangoods.data.model

import kotlinx.serialization.Serializable
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

@Serializable
data class Shop(
    @BsonId
    var id: String = ObjectId().toString(),
    val name: String,
    val country: Country
)
