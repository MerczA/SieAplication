package com.example.sieaplication.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.sieaplication.data.model.GrupoModel
import com.example.sieaplication.data.viewmodel.UserViewModel
import com.example.sieaplication.ui.components.BarsScreens
import com.example.sieaplication.ui.components.CardGrupo

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GrupoScreen(navController: NavController, viewModel: UserViewModel = viewModel()) {
    var grupos by remember { mutableStateOf<List<GrupoModel>>(emptyList()) }
    var selectedSemestre by remember { mutableStateOf("Todos") }
    var expanded by remember { mutableStateOf(false) }

    val semestres = listOf("Todos") + (1..9).map { it.toString() }

    // Obtener los datos desde la API
    LaunchedEffect(Unit) {
        viewModel.getGrupos { response ->
            if (response.isSuccessful) {
                grupos = response.body() ?: emptyList()
            } else {
                Log.d("debug-grupo", "Error al obtener los grupos")
            }
        }
    }

    Scaffold(
        topBar = {
            BarsScreens("Grupos en Preparación", navController)
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(8.dp)
        ) {
            // Dropdown confiable para seleccionar semestre
            Box(modifier = Modifier.fillMaxWidth()) {
                OutlinedTextField(
                    value = selectedSemestre,
                    onValueChange = {},
                    readOnly = true,
                    label = { Text("Selecciona un semestre") },
                    trailingIcon = {
                        IconButton(onClick = { expanded = !expanded }) {
                            Icon(
                                imageVector = Icons.Default.ArrowDropDown,
                                contentDescription = "Abrir menú"
                            )
                        }
                    },
                    modifier = Modifier.fillMaxWidth()
                )

                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    semestres.forEach { semestre ->
                        DropdownMenuItem(
                            text = { Text(semestre) },
                            onClick = {
                                selectedSemestre = semestre
                                expanded = false
                            }
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Lista filtrada
            val gruposFiltrados = if (selectedSemestre == "Todos") {
                grupos
            } else {
                grupos.filter { it.semestre == selectedSemestre }
            }

            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(gruposFiltrados) { grupo ->
                    CardGrupo(
                        materia = grupo.materia,
                        maestro = grupo.maestro,
                        horario = grupo.horario,
                        numeroCreditos = grupo.numero_creditos,
                        semestre = grupo.semestre
                    )
                }
            }
        }
    }
}
