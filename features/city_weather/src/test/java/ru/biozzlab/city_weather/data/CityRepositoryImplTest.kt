package ru.biozzlab.city_weather.data

import org.junit.Before

import org.junit.Assert.*
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.never
import org.mockito.Mockito.times
import org.mockito.MockitoAnnotations
import ru.biozzlab.city_weather.domain.interfaces.CityRepository
import ru.biozzlab.city_weather.domain.models.City
import ru.biozzlab.city_weather.domain.type.Failure
import ru.biozzlab.entities.Either

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
    @Mock private lateinit var mockCache: CityCache
    @Mock private lateinit var mockRemote: CityRemote

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        cityRepository = CityRepositoryImpl(mockCache, mockRemote)
    }

    @Test
    fun loadingFromRemote() {
        val result = Either.Right(city)
        Mockito.`when`(mockRemote.loadCityData(city.cityName)).thenReturn(result)

        assertEquals(result, cityRepository.getCity(city.cityName))

        Mockito.verify(mockCache, times(1)).saveCityData(city)
        Mockito.verify(mockCache, never()).loadCityData(city.cityName)
    }

    @Test
    fun loadingFromCache() {
        val resultFromRemote = Either.Left(Failure.NetworkConnectionError)
        val resultFromCache = Either.Right(city)

        Mockito.`when`(mockRemote.loadCityData(city.cityName)).thenReturn(resultFromRemote)
        Mockito.`when`(mockCache.loadCityData(city.cityName)).thenReturn(resultFromCache)

        assertEquals(resultFromCache, cityRepository.getCity(city.cityName))

        Mockito.verify(mockCache, times(1)).loadCityData(city.cityName)
        Mockito.verify(mockCache, never()).saveCityData(city)
    }
}