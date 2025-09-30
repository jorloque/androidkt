package com.example.clic_surface

import androidx.compose.material3.TimePicker
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TimePickerLayoutType
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import java.util.Calendar




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun myTimePicker(){
    val calendar = Calendar.getInstance()

    val timePickerState = rememberTimePickerState(
        initialHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY),
        initialMinute = Calendar.getInstance().get(Calendar.MINUTE)
    )

    TimePicker(
        state = timePickerState,
       // layoutType = TimePickerLayoutType.Vertical
    )
}