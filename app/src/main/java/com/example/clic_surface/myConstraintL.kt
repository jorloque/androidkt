package com.example.clic_surface

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.twotone.Android
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun FriendsScreen() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val titleRef = createRef()
        val (iconRef, greetingRef, friendsTitleRef, friendsListRef) = createRefs()

        Text(
            text = "Constraint Layout",
            fontSize = 20.sp,
            modifier = Modifier.constrainAs(titleRef) {
                // Añadir restricciones aquí
            }
        )

        Icon(
            imageVector = Icons.TwoTone.Android,
            contentDescription = "Android",
            modifier = Modifier
                .size(120.dp)
                .constrainAs(iconRef) {
                    // Añadir restricciones aquí
                }
        )

        Text(
            text = "¡Hola Rick!",
            modifier = Modifier.constrainAs(greetingRef) {
                // Añadir restricciones aquí
            }
        )

        Text(
            text = "Amigos:",
            modifier = Modifier.constrainAs(friendsTitleRef) {
                // Añadir restricciones aquí
            }
        )

        Column(modifier = Modifier.constrainAs(friendsListRef) {
            // Añadir restricciones aquí
        }) {
            listOf(
                "Hombre pájaro", "Gearhead", "Squanchy", "Unidad",
                "Dr. Xenon Bloom", "Presidente Obama", "Jaguar"
            ).forEach { friend ->
                ListItem(
                    headlineContent = { Text(friend) },
                    leadingContent = {
                        Icon(
                            imageVector = Icons.Default.AccountCircle,
                            contentDescription = "Destino: $friend",
                            modifier = Modifier.size(50.dp)
                        )
                    }
                )
            }
        }
    }
}
