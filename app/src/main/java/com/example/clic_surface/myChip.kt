package com.example.clic_surface

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun myChip (){
    SuggestionChip(
        onClick = { /*TODO*/},
        label = { Text("Suggestion chip") }
    )

    AssistChip(
        onClick = { /*TODO*/},
        label = { Text("Assist chip") },
        leadingIcon = {
            Icon(
                Icons.Filled.Settings,
                contentDescription = "Descripcion",
                Modifier.size(AssistChipDefaults.IconSize)
            )
        }
    )
}