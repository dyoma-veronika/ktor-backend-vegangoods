package com.vegangoods.data

import com.vegangoods.data.model.Country

interface CountryDataSource {

    suspend fun getAllCountries(): List<Country>
    suspend fun addCountry(country: Country)
}
