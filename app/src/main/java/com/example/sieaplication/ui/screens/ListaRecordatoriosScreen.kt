package com.example.sieaplication.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.navigation.NavController
import com.example.sieaplication.data.viewmodel.RecordatorioViewModel
import com.example.sieaplication.ui.components.BarsScreens

@Composable
fun ListaRecordatoriosScreen (viewModel: RecordatorioViewModel, navController: NavController) {
    BarsScreens("Lista de Recordatorios" , navController )

    val recordatorios by viewModel.recordatorios.collectAsState()

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(24.dp)) {

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(recordatorios) { recordatorio ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(text = recordatorio.texto)
                        Spacer(modifier = Modifier.height(8.dp))
                        Button(
                            onClick = {
                                viewModel.eliminarRecordatorio(recordatorio.id)
                            }
                        ) {
                            Text("Eliminar")
                        }
                    }
                }
            }
        }
    }

    // Carga inicial
    LaunchedEffect(Unit) {
        viewModel.cargarRecordatorios()
    }
}
