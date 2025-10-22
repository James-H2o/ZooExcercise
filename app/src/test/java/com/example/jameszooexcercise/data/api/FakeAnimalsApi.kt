package com.example.jameszooexcercise.data.api

import com.example.jameszooexcercise.data.model.AnimalsApiAnimal
import retrofit2.Response

class FakeAnimalsApi : AnimalsApi {
    override suspend fun getAnimals(name: String): Response<List<AnimalsApiAnimal>> {
        return Response.success(
            listOf(
                AnimalsApiAnimal(
                    characteristics = null,
                    locations = null,
                    name = null,
                    taxonomy = null
                )
            )
        )
    }
}
