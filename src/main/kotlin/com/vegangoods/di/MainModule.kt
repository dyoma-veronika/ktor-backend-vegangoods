package com.vegangoods.di

import com.vegangoods.data.*
import org.koin.dsl.module
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo

val mainModule = module {
    single {
        KMongo.createClient()
            .coroutine
            .getDatabase("vegangoods_db")
    }
    factory<CountryDataSource> {
        CountryDataSourceImpl(get())
    }
    factory<ShopDataSource> {
        ShopDataSourceImpl(get())
    }
    factory<CategoryDataSource> {
        CategoryDataSourceImpl(get())
    }
    factory<SubcategoryDataSource> {
        SubcategoryDataSourceImpl(get())
    }
    factory<ItemDataSource> {
        ItemDataSourceImpl(get())
    }
}
