package com.example.clic_surface

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedCard
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.items


@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun lazyscroll(){
    val dragonBallCharacters = listOf(
        "Son Goku",
        "vegeta",
        "Piccolo",
        "Son Gohan",
        "Trunks",
        "Bulma",
        "Krillin",
        "Master Roshi",
        "Freezer",
        "Cell"
    )

    LazyColumn(
        modifier = Modifier.padding(5.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)){
        item {
            OutlinedCard(
                modifier = Modifier
                    .background(Color.DarkGray)
                    .padding(8.dp)
                    .fillMaxWidth()
            ) {
                Text(text = "Personajes",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(8.dp)
                )

            }
        }
        items(dragonBallCharacters){character ->
            Card(modifier = Modifier
                .background(Color(0xFF666666))
                .padding(8.dp)
                .fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFF67979)
                )
            ) {
                Text(text = character,
                    color = Color.White,
                    modifier = Modifier
                        .height(80.dp)
                        .padding(8.dp)
                )
            }
        }
    }
}