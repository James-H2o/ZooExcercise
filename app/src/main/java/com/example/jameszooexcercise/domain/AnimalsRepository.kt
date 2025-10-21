package com.example.jameszooexcercise.domain

import com.example.jameszooexcercise.data.model.AnimalsApiAnimal
import retrofit2.Response

interface AnimalsRepository {
    suspend fun getAnimals(name: String): Response<List<AnimalsApiAnimal>>
}
