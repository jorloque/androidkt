package com.example.clic_surface


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

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun scrollflow(){
    val textList = listOf("Precio Descendiente", "Precio Ascendente", "Puntuación 4+", "Ofertas", "Más vendidos")

    FlowRow(
        horizontalArrangement = Arrangement.spacedBy(24.dp),
        modifier = Modifier.padding(8.dp),
        //maxItemsInEachRow = 2
    ) {
        textList.forEach{
            Text(
                text = it,
                modifier = Modifier
                    .padding(4.dp)
                    .background(Color.LightGray)
                    .padding(4.dp)
            )
        }
    }
}