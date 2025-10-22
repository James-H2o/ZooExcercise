package com.example.jameszooexcercise.data.repository

import com.example.jameszooexcercise.data.api.AnimalsApi
import com.example.jameszooexcercise.data.api.FakeAnimalsApi
import com.example.jameszooexcercise.data.model.AnimalsApiAnimal
import com.example.jameszooexcercise.domain.AnimalsRepository
import io.mockk.junit4.MockKRule
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test
import retrofit2.Response

class AnimalsRepositoryImplTest {
    @get:Rule
    val mockkRule = MockKRule(this)

    // SUT
    private lateinit var animalsRepositoryImpl: AnimalsRepository

    private val fakeAnimalsApi: AnimalsApi = FakeAnimalsApi()

    @Test
    fun getAnimalsReturns() = runTest {
        // Arrange
        animalsRepositoryImpl = AnimalsRepositoryImpl(fakeAnimalsApi)

        // Act
        val actualResult = animalsRepositoryImpl.getAnimals("test")

        // Assert
        assert(actualResult is Response<List<AnimalsApiAnimal>>)
        assert(actualResult.body() is List<AnimalsApiAnimal>)

    }
}
