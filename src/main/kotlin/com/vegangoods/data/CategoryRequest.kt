package com.vegangoods.data

import kotlinx.serialization.Serializable

@Serializable
data class CategoryRequest(
    val countryName: String
)
