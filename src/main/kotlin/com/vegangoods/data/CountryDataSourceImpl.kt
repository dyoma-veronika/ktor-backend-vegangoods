package com.vegangoods.data

import com.vegangoods.data.model.Country
import org.litote.kmongo.coroutine.CoroutineDatabase

class CountryDataSourceImpl(
    private val db: CoroutineDatabase
) : CountryDataSource {

    private val countries = db.getCollection<Country>()

    override suspend fun getAllCountries(): List<Country> {
        return countries.find().toList()
    }

    override suspend fun addCountry(country: Country) {
        countries.insertOne(country).wasAcknowledged()
    }
}
