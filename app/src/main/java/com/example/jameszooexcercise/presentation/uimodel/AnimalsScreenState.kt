package com.example.jameszooexcercise.presentation.uimodel

sealed interface AnimalsScreenState {
    class Success(val animals: List<AnimalSearchScreenModel>) : AnimalsScreenState
    class Error() : AnimalsScreenState
    class Loading() : AnimalsScreenState
}
