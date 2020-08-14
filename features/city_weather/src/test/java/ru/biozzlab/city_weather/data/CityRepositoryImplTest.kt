package ru.biozzlab.city_weather.data

import org.junit.Before

import org.junit.Assert.*
import org.mockito.Mock
import ru.biozzlab.city_weather.domain.interfaces.CityRepository
import ru.biozzlab.city_weather.domain.models.City

class CityRepositoryImplTest {
    private val city = City(
        "Kazan",
        "weather",
        "min - max",
        "icon.png",
        "temp",
        "pressure",
        "humidity",
        "description",
        "windSpeed")

    private lateinit var cityRepository: CityRepository
    @Mock private lateinit var cache: CityCache
    @Mock private lateinit var remote: CityRemote

    @Before
    fun setUp() {
    }
}