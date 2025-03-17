package com.example.sieaplication.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.sieaplication.R
import com.example.sieaplication.data.model.TableScores
import com.example.sieaplication.ui.components.Bars


@Composable
fun CalificacionesTable(navController: NavController) {
            TablaCalificaciones(navController = navController)
}

@Composable
fun TablaCalificaciones(navController: NavController) {
    val calificaciones = arrayOf(
        TableScores(1, "Desarrollo Aplicaciones Móviles", 100, 100, 100, 0, 100, 100, 0),
        TableScores(2, "Bases de Datos", 90, 95, 88, 92, 96, 93, 0),
        TableScores(3, "Programación Web", 85, 80, 82, 88, 90, 86, 0)
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // 🔹 Botón de "Atrás" en la parte superior izquierda
        IconButton(
            onClick = { navController.navigate("main_menu") },
            modifier = Modifier.align(Alignment.TopStart) // 📌 Lo coloca arriba a la izquierda
        ) {
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Atrás")
        }
    }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 50.dp), // 📌 Agregar espacio debajo del botón
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // 🔹 TÍTULO "Calificaciones" centrado
            Text(
                text = "Calificaciones",
                fontWeight = FontWeight.Bold,
                fontSize = MaterialTheme.typography.headlineSmall.fontSize,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
                    .padding(top = 15.dp)
            )

            // 🔹 Caja con borde para la tabla
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(2.dp, Color.Black)
                    .padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Encabezado de la tabla
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Gray)
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    listOf("U1", "U2", "U3", "U4", "U5", "Final").forEach { titulo ->
                        Text(
                            text = titulo,
                            modifier = Modifier.weight(1f),
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
                Divider()

                // 🔹 Filas de calificaciones
                calificaciones.forEach { score ->
                    Column(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        // Fila de Materia
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color.LightGray)
                                .padding(8.dp),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = score.nameClass,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.fillMaxWidth()
                            )
                        }

                        // Fila de calificaciones
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            arrayOf(
                                score.calU1.toString(),
                                score.calU2.toString(),
                                score.calU3.toString(),
                                score.caLU4.toString(),
                                score.calU5.toString(),
                                score.calU6.toString()
                            ).forEach { dato ->
                                Text(
                                    text = dato,
                                    modifier = Modifier.weight(1f),
                                    textAlign = TextAlign.Center
                                )
                            }
                        }
                        Divider()
                    }
                }
            }
        }
}

