package com.example.clic_surface

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp


@Composable
fun DragonBallSearchBar() {
    val context = LocalContext.current
    val dragonBallCharacters = listOf(
        "Son Goku",
        "Vegeta",
        "Piccolo",
        "Son Gohan",
        "Trunks",
        "Bulma",
        "Krillin",
        "Master Roshi",
        "Freezer",
        "Cell"
    )

    var query by remember { mutableStateOf("") }

    // Filtra la lista según el query
    val filteredList = remember(query) {
        dragonBallCharacters.filter {
            it.contains(query, ignoreCase = true)
        }
    }

    Column (modifier = Modifier.fillMaxSize().padding(16.dp)) {
        OutlinedTextField(
            value = query,
            onValueChange = { query = it },
            label = { Text("Buscar personaje") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(filteredList) { character ->
                Text(
                    text = character,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            Toast.makeText(
                                context,
                                "Has seleccionado: $character",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                        .padding(8.dp)
                )
            }
        }
    }
}

