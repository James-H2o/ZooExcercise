package com.example.jameszooexcercise.di.module

import com.example.jameszooexcercise.data.repository.AnimalsRepositoryImpl
import com.example.jameszooexcercise.domain.AnimalsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindAnimalsRepository(
        animalsRepositoryImpl: AnimalsRepositoryImpl
    ): AnimalsRepository
}
