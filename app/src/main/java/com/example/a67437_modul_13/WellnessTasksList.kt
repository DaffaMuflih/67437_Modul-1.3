package com.example.a67437_modul_13

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.runtime.remember

fun getWellnessTasks() = List(30) { i -> WellnessTask(i, "Task # $i") }

@Composable
fun WellnessTasksList(
    modifier: Modifier = Modifier,
    list: List<WellnessTask> = remember { getWellnessTasks() }
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(list) { task ->
            val checkedState = remember { mutableStateOf(false) } // Menyimpan state untuk setiap item

            WellnessTaskItem(
                taskName = task.label,
                checked = checkedState.value,
                onCheckedChange = { newValue -> checkedState.value = newValue },
                onClose = {} // Implementasi tombol close jika diperlukan
            )
        }
    }
}
