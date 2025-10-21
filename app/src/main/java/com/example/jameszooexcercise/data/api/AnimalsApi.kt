package com.example.jameszooexcercise.data.api

import com.example.jameszooexcercise.data.model.AnimalsApiAnimal
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface AnimalsApi {
    //"https://api.api-ninjas.com/v1/animals"
    @GET("animals")
    @Headers(
        "X-Api-Key: XB2xaIrruYztlhnd+h3yCw==bvpvbo1A33T3ptEn"
    )
    suspend fun getAnimals(
        @Query("name") name: String,
    ): Response<List<AnimalsApiAnimal>>
}
