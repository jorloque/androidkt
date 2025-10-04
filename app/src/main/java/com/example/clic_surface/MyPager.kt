package com.example.clic_surface

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MyContent() {
    val colors = listOf(Color.LightGray, Color.Magenta, Color.Cyan, Color.Yellow, Color.White)

    // pageCount es obligatorio: lo pasamos como lambda
    val pagerState = rememberPagerState(initialPage = 0, pageCount = { colors.size })
    // o con trailing lambda:
    // val pagerState = rememberPagerState(initialPage = 0) { colors.size }

    HorizontalPager(state = pagerState) { page ->
        Text(
            text = "Página $page",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(16.dp)
                .background(colors[page])
                .fillMaxSize()
        )
    }
}

