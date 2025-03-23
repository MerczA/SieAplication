package com.example.sieaplication.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.sieaplication.R
import com.example.sieaplication.ui.components.Bars

@Composable
fun Documentos(navController: NavHostController) {
    Scaffold(
        topBar = { Bars() }, // Define la barra de navegación correctamente
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues) // Respeta la altura de la TopBar
                    .padding(horizontal = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = { navController.navigate("main_menu") }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Atrás")
                    }

                    Spacer(modifier = Modifier.width(8.dp))

                    Text(
                        text = "Documentos",
                        fontWeight = FontWeight.Bold,
                        fontSize = MaterialTheme.typography.headlineSmall.fontSize,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.weight(1f)
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Botones en filas
                Row(
                    modifier = Modifier.width(GRID_WIDTH),
                    horizontalArrangement = Arrangement.Center
                ) {
                    ButtonCuadrado(
                        text = "Historial Academico",
                        imageRes = R.drawable.kardex_icon,
                        onClick = { navController.navigate("calif_screen") }
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    ButtonCuadrado(
                        text = "Calificaciones",
                        imageRes = R.drawable.calificaciones_icon,
                        onClick = { navController.navigate("screen_horario") }
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier.width(GRID_WIDTH),
                    horizontalArrangement = Arrangement.Center
                ) {
                    ButtonCuadrado(
                        text = "Constancias",
                        imageRes = R.drawable.docuemntos_icon,
                        onClick = { navController.navigate("documentos_screen") }
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    ButtonCuadrado(
                        text = "Comprobante de inscripciones",
                        imageRes = R.drawable.credencial_digital_icon,
                        onClick = { navController.navigate("credencial_screen") }
                    )
                }
            }
        }
    )
}

