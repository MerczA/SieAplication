package com.example.sieaplication.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.sieaplication.R

// Clase de datos para representar un aviso
data class Aviso(
    val imageResId: Int, // ID del recurso de la imagen
    val title: String,   // Título del aviso
    val description: String, // Texto descriptivo del aviso
    val source: AvisoSource // Origen del aviso (Carrera o TECNM)
)

// Enum para definir el origen del aviso
enum class AvisoSource {
    CARRERA, TECNM
}

@Composable
fun AvisosOpcion(navController: NavController) {
    AvisosSelectorScreen(navController = navController)
}

@Composable
fun AvisosSelectorScreen(navController: NavController) {
    // Lista combinada de avisos de Carrera y TECNM (excluyendo el aviso principal)
    val avisosSecundarios = listOf(
        // Avisos de Carrera
        Aviso(
            imageResId = R.drawable.avisoscarrerauno,
            title = "Open House",
            description = "Los laboratorios de redes no estarán disponibles el 27 de marzo por motivos del evento.",
            source = AvisoSource.CARRERA
        ),
        Aviso(
            imageResId = R.drawable.avisoscarrerados,
            title = "Atención Psicológica",
            description = "Acudir a este correo si necesitas atención psicológica: atn.psicologica@aguascalientes.tecnm.mx",
            source = AvisoSource.CARRERA
        ),
        Aviso(
            imageResId = R.drawable.avisoscarreratres,
            title = "Objetos olvidados en el CC",
            description = "Dejaron estos termos en el área A del CC.",
            source = AvisoSource.CARRERA
        ),
        Aviso(
            imageResId = R.drawable.avisoscarreracuatro,
            title = "Objetos olvidados",
            description = "Olvidaron unos lentes, se encuentran con la coordinadora.",
            source = AvisoSource.CARRERA
        ),
        // Avisos de TECNM
        Aviso(
            imageResId = R.drawable.avisotecnmuno,
            title = "El ITA forma parte activa y sustancial",
            description = "Desde su ámbito y experiencia, el TecNM a través del Tecnológico de Aguascalientes, participará activamente en el desarrollo de iniciativas clave, especialmente en el tema de semiconductores.",
            source = AvisoSource.TECNM
        ),
        Aviso(
            imageResId = R.drawable.avisostecnmdos,
            title = "Acuerdan líneas trabajo colaborativo",
            description = "El Instituto Tecnológico de Aguascalientes fungió como sede de la primera reunión ordinaria de la Comisión #3 del CITIA de la ANUIES.",
            source = AvisoSource.TECNM
        ),
        Aviso(
            imageResId = R.drawable.avisostecnmtres,
            title = "Miembros de la Federación",
            description = "La FEDESA y el TecNM Instituto Tecnológico de Aguascalientes firmaron un convenio de colaboración para brindar oportunidades de formación.",
            source = AvisoSource.TECNM
        ),
        Aviso(
            imageResId = R.drawable.avisostecnmcuatro,
            title = "Estudiantes del Tecnológico de Aguascalientes conquistan los primeros lugares del INFOMATRIX",
            description = "HealthSensor y Ergo Tec obtuvieron las preseas de plata y su participación en la Fase Nacional.",
            source = AvisoSource.TECNM
        ),
        Aviso(
            imageResId = R.drawable.avisostecnmcinco,
            title = "Cierra ITA el año con más de 800 nuevos profesionistas titulados",
            description = "El TecNM Aguascalientes entrega en 2024 más de 800 egresados de diversas ingenierías y licenciaturas.",
            source = AvisoSource.TECNM
        )
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {
        // Botón de "Atrás" en la parte superior izquierda
        IconButton(
            onClick = { navController.navigate("main_menu") },
            modifier = Modifier.align(Alignment.TopStart)
        ) {
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Atrás")
        }

        // Tarjeta principal
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.85f)
                .align(Alignment.Center),
            shape = RoundedCornerShape(12.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Encabezado
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "TODOS LOS AVISOS",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        color = Color(0xFF003087)
                    )
                }

                // Lista de avisos en LazyColumn
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    // Aviso principal
                    item {
                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            // Imagen principal
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(200.dp)
                                    .background(Color(0xFFF5F5F5))
                                    .border(1.dp, Color(0xFFDDDDDD), RoundedCornerShape(8.dp)),
                                contentAlignment = Alignment.Center
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.tecnmmejorescuela),
                                    contentDescription = "Imagen de TECNM",
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.Fit
                                )
                            }

                            // Título y texto principal debajo de la imagen
                            Column(
                                modifier = Modifier.padding(top = 8.dp),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.spacedBy(4.dp)
                            ) {
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(40.dp)
                                        .verticalScroll(rememberScrollState())
                                ) {
                                    Text(
                                        text = "Se consolida el TecNM campus Instituto Tecnológico de Aguascalientes como Mejor Escuela de Ingeniería del País",
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color.DarkGray,
                                        textAlign = TextAlign.Center
                                    )
                                }
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(100.dp)
                                        .verticalScroll(rememberScrollState())
                                ) {
                                    Text(
                                        text = "Reconoce ANFEI AL TECNOLÓGICO de Aguascalientes como la mejor escuela de ingeniería en el país\n" +
                                                "Es el máximo reconocimiento que recibe una institución por su calidad educativa en el ámbito de las ingenierías.",
                                        fontSize = 14.sp,
                                        color = Color.DarkGray,
                                        lineHeight = 20.sp,
                                        textAlign = TextAlign.Center
                                    )
                                }
                            }
                        }
                    }

                    // Avisos secundarios
                    items(avisosSecundarios) { aviso ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(100.dp),
                            shape = RoundedCornerShape(8.dp),
                            elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
                            colors = CardDefaults.cardColors(containerColor = Color.White)
                        ) {
                            Row(
                                modifier = Modifier.fillMaxSize(),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                // Borde izquierdo
                                Box(
                                    modifier = Modifier
                                        .width(4.dp)
                                        .fillMaxHeight()
                                        .background(
                                            when (aviso.source) {
                                                AvisoSource.CARRERA -> Color(0xFF1E90FF)
                                                AvisoSource.TECNM -> Color(0xFF8B0000)
                                            }
                                        )
                                )

                                // Contenido principal
                                Row(
                                    modifier = Modifier
                                        .weight(1f)
                                        .padding(8.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                                ) {
                                    // Imagen a la izquierda
                                    Box(
                                        modifier = Modifier
                                            .size(60.dp)
                                            .background(Color(0xFFF5F5F5))
                                            .border(1.dp, Color(0xFFDDDDDD), RoundedCornerShape(8.dp)),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Image(
                                            painter = painterResource(id = aviso.imageResId),
                                            contentDescription = "Imagen de ${aviso.title}",
                                            modifier = Modifier.fillMaxSize(),
                                            contentScale = ContentScale.Fit
                                        )
                                    }

                                    // Columna para título y texto
                                    Column(
                                        modifier = Modifier.weight(1f),
                                        verticalArrangement = Arrangement.spacedBy(4.dp)
                                    ) {
                                        Box(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .height(24.dp)
                                                .verticalScroll(rememberScrollState())
                                        ) {
                                            Text(
                                                text = aviso.title,
                                                fontSize = 14.sp,
                                                fontWeight = FontWeight.Bold,
                                                color = Color.DarkGray
                                            )
                                        }
                                        Box(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .height(48.dp)
                                                .verticalScroll(rememberScrollState())
                                        ) {
                                            Text(
                                                text = aviso.description,
                                                fontSize = 12.sp,
                                                color = Color.DarkGray,
                                                lineHeight = 16.sp
                                            )
                                        }
                                    }
                                }

                                // Borde derecho
                                Box(
                                    modifier = Modifier
                                        .width(4.dp)
                                        .fillMaxHeight()
                                        .background(
                                            when (aviso.source) {
                                                AvisoSource.CARRERA -> Color(0xFF1E90FF)
                                                AvisoSource.TECNM -> Color(0xFF8B0000)
                                            }
                                        )
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AvisosSelectorScreenPreview() {
    AvisosSelectorScreen(navController = NavController(LocalContext.current))
}