package com.example.jameszooexcercise.di.module

import com.example.jameszooexcercise.domain.AnimalsRepository
import com.example.jameszooexcercise.domain.AnimalSearchUseCaseImpl
import com.example.jameszooexcercise.domain.AnimalSearchUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object DomainModule {

    @Provides
    @ViewModelScoped
    fun provideAnimalSearchUseCase(
        animalsRepository: AnimalsRepository
    ): AnimalSearchUseCase {
        return AnimalSearchUseCaseImpl(animalsRepository)
    }
}