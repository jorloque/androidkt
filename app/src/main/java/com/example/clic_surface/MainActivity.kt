package com.example.clic_surface

import com.example.clic_surface.ui.theme.Clic_surfaceTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Clic_surfaceTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        MyTripleCheckBox()
                    }
                }
            }
        }
    }
}

// ✅ Componente personalizado con tres opciones
@Composable
fun MyTripleCheckBox() {
    var isCheckedA by remember { mutableStateOf(false) }
    var isCheckedB by remember { mutableStateOf(false) }
    var isCheckedC by remember { mutableStateOf(false) }

    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp)
        ) {
            Checkbox(
                checked = isCheckedA,
                onCheckedChange = { isCheckedA = it }
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Opción A")
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp)
        ) {
            Checkbox(
                checked = isCheckedB,
                onCheckedChange = { isCheckedB = it }
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Opción B")
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp)
        ) {
            Checkbox(
                checked = isCheckedC,
                onCheckedChange = { isCheckedC = it }
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Opción C")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyTripleCheckBoxPreview() {
    Clic_surfaceTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            MyTripleCheckBox()
        }
    }
}