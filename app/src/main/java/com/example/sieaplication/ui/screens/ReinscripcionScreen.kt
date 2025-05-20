package com.example.sieaplication.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.sieaplication.ui.components.BarsScreens
import androidx.compose.foundation.lazy.items


@Composable
fun Reinscripcion(navController: NavController) {
    // Lista simulada de materias
    val subjects = listOf(
        Triple(1, "Matemáticas", 1),
        Triple(2, "Física", 1),
        Triple(3, "Programación", 2),
        Triple(4, "Bases de Datos", 3),
        Triple(5, "Redes", 4)
    )

    // Estado local de materias seleccionadas
    val selectedSubjectIds = remember { mutableStateListOf<Int>() }

    // Mensaje de reinscripción
    var showSuccessMessage by remember { mutableStateOf(false) }
    var successText by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            BarsScreens("Reinscripcion", navController)
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                val selectedNames = subjects
                    .filter { selectedSubjectIds.contains(it.first) }
                    .joinToString { it.second }

                successText = if (selectedNames.isNotEmpty()) {
                    "Te reinscribiste en: $selectedNames"
                } else {
                    "No seleccionaste ninguna materia"
                }

                showSuccessMessage = true
            }) {
                Icon(Icons.Default.Check, contentDescription = "Reinscribirse")
            }
        }
    ) { padding ->
        Column(modifier = Modifier
            .padding(padding)
            .fillMaxSize()) {

            LazyColumn(modifier = Modifier.weight(1f)) {
                items(subjects) { subject ->
                    val (id, name, semester) = subject
                    val isSelected = selectedSubjectIds.contains(id)

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                            .clickable {
                                if (isSelected) {
                                    selectedSubjectIds.remove(id)
                                } else {
                                    selectedSubjectIds.add(id)
                                }
                            },
                        elevation = CardDefaults.cardElevation(4.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .padding(16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Checkbox(
                                checked = isSelected,
                                onCheckedChange = {
                                    if (isSelected) {
                                        selectedSubjectIds.remove(id)
                                    } else {
                                        selectedSubjectIds.add(id)
                                    }
                                }
                            )
                            Spacer(modifier = Modifier.width(12.dp))
                            Column {
                                Text(text = name, style = MaterialTheme.typography.titleMedium)
                                Text("Semestre $semester", style = MaterialTheme.typography.bodySmall)
                            }
                        }
                    }
                }
            }

            if (showSuccessMessage) {
                Snackbar(
                    modifier = Modifier
                        .padding(16.dp)
                        .align(Alignment.CenterHorizontally),
                    action = {
                        TextButton(onClick = { showSuccessMessage = false }) {
                            Text("Cerrar")
                        }
                    }
                ) {
                    Text(text = successText)
                }
            }
        }
    }
}
