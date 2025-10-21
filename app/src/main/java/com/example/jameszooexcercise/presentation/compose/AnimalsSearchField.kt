package com.example.jameszooexcercise.presentation.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AnimalsSearchField(
    submitNameButtonClick: (String) -> Unit,
    submitCommonNameButtonClick: (String) -> Unit
) {
    var textFieldNameValue by remember { mutableStateOf("") }
    var textFieldCommonNameValue by remember { mutableStateOf("") }

    // Filter by name
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize()
    ) {
        TextField(
            value = textFieldNameValue,
            onValueChange = { value ->
                textFieldNameValue = value
            }
        )

        // Submit Button
        Button(
            onClick = { submitNameButtonClick(textFieldNameValue) },
            modifier = Modifier.wrapContentSize(),
            enabled = true,
            shape = RoundedCornerShape(8.dp),
            content = { Text(text = "Submit") }
        )
    }

    // Filter by common name
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize()
    ) {
        TextField(
            value = textFieldCommonNameValue,
            onValueChange = { value ->
                textFieldCommonNameValue = value
            }
        )

        // Submit Button
        Button(
            onClick = { submitCommonNameButtonClick(textFieldCommonNameValue) },
            modifier = Modifier.wrapContentSize(),
            enabled = true,
            shape = RoundedCornerShape(8.dp),
            content = { Text(text = "Submit") }
        )
    }
}
