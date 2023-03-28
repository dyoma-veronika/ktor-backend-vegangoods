package com.vegangoods.data

data class SimpleResponse<T>(
    val status: Boolean,
    val message: String,
    val data: T
)
