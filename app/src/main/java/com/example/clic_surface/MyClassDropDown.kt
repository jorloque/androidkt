package com.example.clic_surface

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyClassDropdown() {
    val classes = listOf(
        "Bárbaro", "Bardo", "Brujo", "Clérigo", "Druida", "Explorador",
        "Guerrero", "Hechicero", "Mago", "Monje", "Paladín", "Pícaro"
    )

    var showMenu by rememberSaveable { mutableStateOf(false) }
    var selectedOptionText by rememberSaveable { mutableStateOf("Selecciona una clase") }

    ExposedDropdownMenuBox(
        expanded = showMenu,
        onExpandedChange = { showMenu = !showMenu }
    ) {
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = selectedOptionText,
            onValueChange = {}, // No editable
            readOnly = true,
            label = { Text(text = "Clase") },
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded = showMenu)
            },
            colors = ExposedDropdownMenuDefaults.textFieldColors()
        )

        ExposedDropdownMenu(
            expanded = showMenu,
            onDismissRequest = { showMenu = false }
        ) {
            classes.forEach { option ->
                DropdownMenuItem(
                    text = { Text(option) },
                    onClick = {
                        selectedOptionText = option
                        showMenu = false
                    }
                )
            }
        }
    }
}
