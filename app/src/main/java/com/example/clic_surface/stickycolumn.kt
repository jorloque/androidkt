package com.example.clic_surface


import androidx.compose.foundation.ExperimentalFoundationApi
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun stickycolumn(){
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
        val groupCharacters: Map<Char, List<String>> = dragonBallCharacters.sorted().groupBy {
            it[0]
        }

        groupCharacters.forEach() { header, names ->
            stickyHeader {
                Text(
                    text = header.toString(),
                    fontSize = 30.sp,
                    color = Color.Blue,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .background(Color.LightGray)
                        .fillMaxWidth()
                )
            }
            items(names){name ->
                Text(
                    text = name,
                    modifier = Modifier
                        .padding(start= 40.dp,top= 4.dp, bottom = 4.dp)
                )
            }

        }
    }
}