package com.example.jameszooexcercise.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jameszooexcercise.domain.AnimalSearchUseCase
import com.example.jameszooexcercise.presentation.uimodel.AnimalScreenEvent
import com.example.jameszooexcercise.presentation.uimodel.AnimalsScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class AnimalsViewModel @Inject constructor(
    val animalSearchUseCase: AnimalSearchUseCase
) : ViewModel() {

    private val _animalScreenState: MutableStateFlow<AnimalsScreenState> =
        MutableStateFlow(AnimalsScreenState.Loading())
    val animalScreenState = _animalScreenState

    init {
        getAnimals("dog")
    }

    fun animalsScreenEvent(animalScreenEvent: AnimalScreenEvent) {
        when (animalScreenEvent) {
            is AnimalScreenEvent.SearchButtonPress -> {
                getAnimals(animalScreenEvent.name)
            }
        }
    }

    fun getAnimals(name: String) {
        viewModelScope.launch {
            animalSearchUseCase.getAnimals(name = name).collect { newList ->
                _animalScreenState.update {
                    AnimalsScreenState.Success(newList)
                }
            }
        }
    }
}
