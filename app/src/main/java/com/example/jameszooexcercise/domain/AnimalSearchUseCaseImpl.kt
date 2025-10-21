package com.example.jameszooexcercise.domain

import com.example.jameszooexcercise.presentation.uimodel.AnimalSearchScreenModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class AnimalSearchUseCaseImpl(
    private val animalsRepository: AnimalsRepository
) : AnimalSearchUseCase {
    override suspend fun getAnimals(name: String): Flow<MutableList<AnimalSearchScreenModel>> =
        flow {
            val response = animalsRepository.getAnimals(name = name)
            val animalsScreenState = mutableListOf<AnimalSearchScreenModel>()

            if (response.isSuccessful) {
                val list = response.body()

                list?.forEach {
                    animalsScreenState.add(
                        AnimalSearchScreenModel(
                            name = it.name,
                            phylum = it.taxonomy?.phylum,
                            scientificName = it.taxonomy?.scientificName
                        )
                    )
                }
            }

            emit(animalsScreenState)
        }
}
