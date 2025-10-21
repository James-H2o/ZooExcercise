package com.example.jameszooexcercise.domain

import com.example.jameszooexcercise.presentation.uimodel.AnimalSearchScreenModel
import kotlinx.coroutines.flow.Flow

interface AnimalSearchUseCase {
    suspend fun getAnimals(name: String): Flow<MutableList<AnimalSearchScreenModel>>
}
