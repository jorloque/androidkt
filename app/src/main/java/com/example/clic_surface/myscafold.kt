package com.example.clic_surface

import androidx.compose.material3.Scaffold

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.Help
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Cake
import androidx.compose.material.icons.filled.Face4
import androidx.compose.material.icons.filled.Handyman
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.BackHand
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Help
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopBar() {
    var expanded by rememberSaveable { mutableStateOf(false) }

    TopAppBar(
        title = { Text(text = "Título Top Bar") },
        navigationIcon = {
            IconButton(onClick = { expanded = true }) {
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = "Menú"
                )
            }

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                DropdownMenuItem(
                    text = { Text("Editar") },
                    onClick = {
                        expanded = false
                        // TODO: acción de editar
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Outlined.Edit,
                            contentDescription = null
                        )
                    }
                )

                DropdownMenuItem(
                    text = { Text("Configuración") },
                    onClick = {
                        expanded = false
                        // TODO: acción de configuración
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Outlined.Settings,
                            contentDescription = null
                        )
                    }
                )

                DropdownMenuItem(
                    text = { Text("Envía comentarios") },
                    onClick = {
                        expanded = false
                        // TODO: acción de enviar comentarios
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Outlined.Email,
                            contentDescription = null
                        )
                    },
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Outlined.BackHand,
                            contentDescription = null
                        )
                    }
                )
            }
        },
        actions = {
            Icon(
                imageVector = Icons.Default.AccountCircle,
                contentDescription = "Cuenta"
            )
            Spacer(modifier = Modifier.width(8.dp))
            Icon(
                imageVector = Icons.Default.Settings,
                contentDescription = "Configuración"
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            navigationIconContentColor = Color.Cyan,
            containerColor = Color.DarkGray,
            titleContentColor = Color.White,
            actionIconContentColor = Color.Yellow
        )
    )

}


@Composable
fun MyBottomBar() {
    BottomAppBar {
        IconButton(onClick = { /* TODO */ }) {
            Icon(imageVector = Icons.Default.Cake, contentDescription = "Pastel")
        }
        IconButton(onClick = { /* TODO */ }) {
            Icon(imageVector = Icons.Default.Face4, contentDescription = "Rostro")
        }
        IconButton(onClick = { /* TODO */ }) {
            Icon(imageVector = Icons.Default.Handyman, contentDescription = "Herramientas")
        }
    }
}
