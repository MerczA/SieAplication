package com.example.sieaplication.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.sieaplication.ui.components.Bars

@Composable
fun AvisosOpcion(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize()) {
        Bars(navController = navController)
        AvisosSelectorContent(navController = navController)
    }
}


@Composable
fun AvisosSelectorContent(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {
        // 🔹 Botón de "Atrás" en la parte superior izquierda
        IconButton(
            onClick = { navController.navigate("main_menu") },
            modifier = Modifier.align(Alignment.TopStart)
        ) {
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Atrás")
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            // Título
            Text(
                text = "Selecciona Tipo de Avisos",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF003087), // Azul oscuro como en "Sistema de Integración Escolar"
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // Tarjeta de AVISOS TECNM
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(155.dp)
                    .clickable { navController.navigate("screen_avisos_tecnm") },
                shape = RoundedCornerShape(12.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier
                            .size(60.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .background(Color(0xFF8B0000)), // Marrón oscuro para "TECNM"
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "TECNM",
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        text = "AVISOS TECNM AGUASCALIENTES",
                        color = Color(0xFF003087), // Azul oscuro para el título
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )

                    Text(
                        text = "Información institucional y eventos",
                        color = Color.DarkGray,
                        fontSize = 14.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(top = 4.dp)
                    )
                }
            }

            // Tarjeta de AVISOS CARRERA
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(155.dp)
                    .clickable { navController.navigate("screen_avisos_carrera") },
                shape = RoundedCornerShape(12.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier
                            .size(60.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .background(Color(0xFF1E90FF)), // Azul claro para "ISC"
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "ISC",
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        text = "AVISOS CARRERA",
                        color = Color(0xFF003087), // Azul oscuro para el título
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )

                    Text(
                        text = "Información específica de tu carrera",
                        color = Color.DarkGray,
                        fontSize = 14.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(top = 4.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AvisosSelectorScreenPreview() {
    AvisosOpcion(navController = NavController(LocalContext.current))
}
