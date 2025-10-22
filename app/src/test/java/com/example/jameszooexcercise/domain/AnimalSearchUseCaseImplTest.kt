package com.example.jameszooexcercise.domain

import com.example.jameszooexcercise.data.model.AnimalsApiAnimal
import com.example.jameszooexcercise.presentation.uimodel.AnimalSearchScreenModel
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.junit4.MockKRule
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import retrofit2.Response

class AnimalSearchUseCaseImplTest {
    @get:Rule
    val mockkRule = MockKRule(this)

    // SUT
    private lateinit var animalSearchUseCaseImpl: AnimalSearchUseCase

    @RelaxedMockK
    private lateinit var mockAnimalsRepository: AnimalsRepository

    @Test
    fun getAnimalsReturns() = runTest {
        // Arrange
        val expectedResult = "TestName"

        coEvery { mockAnimalsRepository.getAnimals(any()) } returns Response.success(
            listOf(
                AnimalsApiAnimal(
                    characteristics = null,
                    locations = null,
                    name = expectedResult,
                    taxonomy = null
                )
            )
        )
        animalSearchUseCaseImpl = AnimalSearchUseCaseImpl(mockAnimalsRepository)

        // Act
        val actualResult = animalSearchUseCaseImpl.getAnimals("test").first()

        // Assert
        assert(actualResult is MutableList<AnimalSearchScreenModel>)
        assertEquals(expectedResult, actualResult[0].name)
    }
}
