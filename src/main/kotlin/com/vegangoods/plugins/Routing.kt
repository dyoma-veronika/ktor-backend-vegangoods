package com.vegangoods.plugins

import com.vegangoods.data.*
import com.vegangoods.routes.*
import io.ktor.server.application.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Application.configureRouting() {
    val categoryDataSource by inject<CategoryDataSource>()
    val countryDataSource by inject<CountryDataSource>()
    val itemDataSource by inject<ItemDataSource>()
    val shopDataSource by inject<ShopDataSource>()
    val subcategoryDataSource by inject<SubcategoryDataSource>()

    routing {
        getCategoriesByCountry(categoryDataSource)
        getAllCountries(countryDataSource)
        getItemsBySubcategory(itemDataSource)
        getItemsByCategory(itemDataSource)
        getShopsByCountry(shopDataSource)
        getSubcategoriesByCategory(subcategoryDataSource)
        addCountry(countryDataSource)
        addCategory(categoryDataSource)
    }
}
