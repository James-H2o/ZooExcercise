package com.example.jameszooexcercise.presentation.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jameszooexcercise.presentation.uimodel.AnimalSearchScreenModel

@Composable
fun AnimalCard(animalData: AnimalSearchScreenModel) {
    Card(
        elevation = CardDefaults.cardElevation(2.dp),
        shape = RoundedCornerShape(size = 16.dp),
        modifier = Modifier
            .background(color = Color.White)
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(
            Modifier
                .fillMaxWidth()
        ) {
            animalData.name?.let {
                Text(
                    modifier = Modifier.padding(4.dp),
                    text = it,
                    fontSize = 24.sp
                )
            }
            animalData.scientificName?.let {
                Text(
                    modifier = Modifier.padding(4.dp),
                    text = it,
                    fontSize = 24.sp
                )
            }
            animalData.phylum?.let {
                Text(
                    modifier = Modifier.padding(4.dp),
                    text = it,
                    fontSize = 24.sp
                )
            }
        }
    }
}
