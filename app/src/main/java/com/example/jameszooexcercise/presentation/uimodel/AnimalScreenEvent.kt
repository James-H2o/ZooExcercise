package com.example.jameszooexcercise.presentation.uimodel

sealed interface AnimalScreenEvent {
    class SearchButtonPress(val name: String) : AnimalScreenEvent
}
