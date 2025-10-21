package com.example.jameszooexcercise.di.module

import com.example.jameszooexcercise.data.api.AnimalsApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    const val BASE_URL = "https://api.api-ninjas.com/v1/"
    const val API_KEY = "XB2xaIrruYztlhnd+h3yCw==bvpvbo1A33T3ptEn"

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideAnimalsApi(retrofit: Retrofit): AnimalsApi {
        return retrofit.create(AnimalsApi::class.java)
    }
}
