package com.vegangoods.data.model

import kotlinx.serialization.Serializable
import org.bson.codecs.pojo.annotations.BsonId

@Serializable
data class Category(
    @BsonId
    val id: Int,
    val name: String,
    val country: Country
)
