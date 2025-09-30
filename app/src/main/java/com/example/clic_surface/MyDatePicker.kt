package com.example.clic_surface

import android.icu.util.Calendar
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DatePicker
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyDatePicker() {
    val datePickerState = rememberDatePickerState(initialSelectedDateMillis = Calendar.getInstance().timeInMillis)
    DatePicker(
        state = datePickerState,
        Modifier.padding(16.dp),
        showModeToggle = true
    )

    Text("Fecha seleccionada: ${
        run { 
            val fecha: Calendar? = Calendar.getInstance()
                .also { 
                    it.timeInMillis = datePickerState.selectedDateMillis!!
                }
            fecha?.time
        }   
    }")
}