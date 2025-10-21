package com.example.jameszooexcercise.data.repository

import com.example.jameszooexcercise.data.api.AnimalsApi
import com.example.jameszooexcercise.data.model.AnimalsApiAnimal
import com.example.jameszooexcercise.domain.AnimalsRepository
import javax.inject.Inject
import retrofit2.Response

class AnimalsRepositoryImpl @Inject constructor(
    private val animalsApi: AnimalsApi
) : AnimalsRepository {
    override suspend fun getAnimals(name: String): Response<List<AnimalsApiAnimal>> {
        return animalsApi.getAnimals(name)
    }
}
