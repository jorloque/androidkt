package com.example.clic_surface

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedCard
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.ui.unit.times


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun lazyvstaggrid(){
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

    LazyVerticalStaggeredGrid (
        columns = StaggeredGridCells.Fixed(3),
        verticalItemSpacing = 8.dp,
        horizontalArrangement = Arrangement.spacedBy(8.dp)) {

        item {
            OutlinedCard(
                modifier = Modifier
                    .background(Color.DarkGray)
                    .padding(8.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Personajes",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(8.dp)

                )
            }

        }
        items(dragonBallCharacters) { character ->
            val randomHeight = ((1..30)).random() * 15.dp
            Card(
                modifier = Modifier
                    .background(Color.LightGray)
                    .padding(8.dp)
                    .fillMaxWidth()
                    .height(randomHeight)
            ) {
                Text(
                    text = character,
                    modifier = Modifier.height(80.dp).padding(8.dp)
                )

            }
        }
    }
}