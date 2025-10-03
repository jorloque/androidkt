package com.example.clic_surface


import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedCard
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState
import androidx.compose.material3.Button
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.unit.times
import kotlinx.coroutines.launch


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun lazyvstate(){
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
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

        val scrollState = rememberLazyStaggeredGridState()

        val showEndTextGrid by remember {
            derivedStateOf {
                scrollState.firstVisibleItemIndex > 0
            }
        }

        val coroutineGridScope = rememberCoroutineScope()

        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(3),
            verticalItemSpacing = 8.dp,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            state = scrollState,
            modifier = Modifier.weight(3f)

        ) {
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
                val randomHeight = ((2..30).random() * 15).dp
                Card(
                    modifier = Modifier
                        .background(Color.LightGray)
                        .padding(8.dp)
                        .fillMaxWidth()
                        .height(randomHeight)
                ) {
                    Text(
                        text = character,
                        modifier = Modifier
                            .height(80.dp)
                            .padding(8.dp)
                    )
                }
            }


        }
        if (showEndTextGrid) {
            Button(
                modifier = Modifier
                    .weight(0.5f)
                    .fillMaxWidth(),
                onClick = {
                    coroutineGridScope.launch {
                        scrollState.animateScrollToItem(0, 0)
                    }
                }) {
                Text(text = "Volver arriba")
            }
        }
    }
}