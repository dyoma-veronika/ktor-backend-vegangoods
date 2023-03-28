package com.vegangoods.di

import com.vegangoods.data.*
import org.koin.dsl.module
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo

val mainModule = module {
    single {
        KMongo.createClient()
            .coroutine
            .getDatabase("VeganGoods")
    }
    single<CountryDataSource> {
        CountryDataSourceImpl(get())
    }
    single<ShopDataSource> {
        ShopDataSourceImpl(get())
    }
    single<CategoryDataSource> {
        CategoryDataSourceImpl(get())
    }
    single<SubcategoryDataSource> {
        SubcategoryDataSourceImpl(get())
    }
    single<ItemDataSource> {
        ItemDataSourceImpl(get())
    }
}
