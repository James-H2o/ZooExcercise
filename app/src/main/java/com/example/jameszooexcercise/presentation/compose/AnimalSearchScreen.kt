package com.example.jameszooexcercise.presentation.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.jameszooexcercise.presentation.AnimalsViewModel
import com.example.jameszooexcercise.presentation.ui.theme.JamesZooExcerciseTheme
import com.example.jameszooexcercise.presentation.uimodel.AnimalScreenEvent
import com.example.jameszooexcercise.presentation.uimodel.AnimalsScreenState

@Composable
fun AnimalSearchScreen() {
    val viewModel = hiltViewModel<AnimalsViewModel>()

    var screenState by remember { mutableStateOf(viewModel.animalScreenState) }


    fun submitNameButtonClick(text: String) {
        viewModel.animalsScreenEvent(AnimalScreenEvent.SearchButtonPress(text))
    }

    fun submitCommonNameButtonClick(text: String) {
        viewModel.animalsScreenEvent(AnimalScreenEvent.SearchButtonPress(text))
    }

    Column(Modifier.fillMaxSize().safeContentPadding()) {

        AnimalsSearchField(
            submitNameButtonClick = { submitNameButtonClick(it) },
            submitCommonNameButtonClick = { submitCommonNameButtonClick(it) }
        )

        // Show Animals when response was Success
        when (val state = screenState.collectAsState().value) {
            is AnimalsScreenState.Loading -> {
                // Show Loading indicator
            }

            is AnimalsScreenState.Error -> {
                // Show an Error message
            }

            is AnimalsScreenState.Success -> {
                val animals = state.animals
                JamesZooExcerciseTheme {
                    Scaffold(
                        modifier = Modifier.fillMaxSize(),
                        topBar = {
                            // TopBar goes here
                        },
                    ) { innerPadding ->
                        // quiet the linter
                        val padding = innerPadding

                        LazyColumn(Modifier.fillMaxSize()) {
                            items(animals) {
                                println(it.name)
                                AnimalCard(it)
                                Spacer(Modifier.size(8.dp))
                            }
                        }
                    }
                }
            }
        }
    }
}
