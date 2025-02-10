package com.example.a67437_modul_13

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun WellnessScreen(
    modifier: Modifier = Modifier,
    wellnessViewModel: WellnessViewModel = viewModel()
) {
    Column(modifier = modifier) {
        StatefulCounter()
        WaterCounter()

        WellnessTasksList(
            list = wellnessViewModel.tasks,
            onCheckedTask = { task, checked ->
                wellnessViewModel.changeTaskChecked(task, checked)
            },
            onCloseTask = { task ->
                wellnessViewModel.remove(task)
            }
        )
    }
}

//private fun getWellnessTasks() = List(30) { i -> WellnessTask(i, "Task # $i") }


@Composable
fun StatefulCounter() {
    val count = rememberSaveable { mutableStateOf(0) }

    Column {
        Text(text = "Count: ${count.value}")
        Button(onClick = { count.value++ }) {
            Text("Increase")
        }
    }
}
