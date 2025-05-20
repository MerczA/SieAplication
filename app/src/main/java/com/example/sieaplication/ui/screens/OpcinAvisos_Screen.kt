package com.example.sieaplication.ui.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import com.example.sieaplication.R
import com.example.sieaplication.ui.components.BarsScreens

// Clase de datos para representar un aviso
data class Aviso(
    val imageResId: Int,
    val title: String,
    val description: String,
    val source: AvisoSource
)

enum class AvisoSource {
    CARRERA, TECNM
}

@Composable
fun AvisosOpcion(navController: NavController) {
    AvisosSelectorScreen(navController = navController)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AvisosSelectorScreen(navController: NavController) {
    val avisos = listOf(
        Aviso(R.drawable.avisoscarrerauno, "Open House", "Los laboratorios de redes no estarán disponibles el 27 de marzo por motivos del evento.", AvisoSource.CARRERA),
        Aviso(R.drawable.avisoscarrerados, "Atención Psicológica", "Acudir a este correo si necesitas atención psicológica: atn.psicologica@aguascalientes.tecnm.mx", AvisoSource.CARRERA),
        Aviso(R.drawable.avisoscarreratres, "Objetos olvidados en el CC", "Dejaron estos termos en el área A del CC.", AvisoSource.CARRERA),
        Aviso(R.drawable.avisoscarreracuatro, "Objetos olvidados", "Olvidaron unos lentes, se encuentran con la coordinadora.", AvisoSource.CARRERA),
        Aviso(R.drawable.avisotecnmuno, "El ITA forma parte activa y sustancial", "Desde su ámbito y experiencia, el TecNM participa activamente en iniciativas clave, especialmente semiconductores.", AvisoSource.TECNM),
        Aviso(R.drawable.avisostecnmdos, "Acuerdan líneas trabajo colaborativo", "El ITA fue sede de la primera reunión de la Comisión #3 del CITIA de la ANUIES.", AvisoSource.TECNM),
        Aviso(R.drawable.avisostecnmtres, "Miembros de la Federación", "FEDESA y el ITA firmaron un convenio para brindar formación académica.", AvisoSource.TECNM),
        Aviso(R.drawable.avisostecnmcuatro, "Estudiantes conquistan INFOMATRIX", "HealthSensor y Ergo Tec ganan preseas de plata en la fase nacional.", AvisoSource.TECNM),
        Aviso(R.drawable.avisostecnmcinco, "Cierra ITA con más de 800 titulados", "En 2024, el TecNM Aguascalientes gradúa más de 800 ingenieros y licenciados.", AvisoSource.TECNM)
    )

    var selectedAviso by remember { mutableStateOf<Aviso?>(null) }

    Scaffold(
        topBar = { BarsScreens("Avisos", navController) },
        containerColor = Color(0xFFF8F8F8)
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            item {
                Text(
                    text = "Últimas noticias del ITA y TecNM",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF003087),
                    modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
                )
            }

            items(avisos) { aviso ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { selectedAviso = aviso },
                    shape = RoundedCornerShape(16.dp),
                    elevation = CardDefaults.cardElevation(6.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = aviso.imageResId),
                            contentDescription = aviso.title,
                            modifier = Modifier
                                .size(70.dp)
                                .clip(RoundedCornerShape(12.dp))
                                .background(Color.LightGray),
                            contentScale = ContentScale.Crop
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = aviso.title,
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 16.sp,
                                color = Color(0xFF222222)
                            )
                            Text(
                                text = aviso.description.take(80) + "...",
                                fontSize = 13.sp,
                                color = Color(0xFF555555),
                                lineHeight = 18.sp,
                                maxLines = 2
                            )
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Box(
                            modifier = Modifier
                                .size(10.dp)
                                .background(
                                    if (aviso.source == AvisoSource.CARRERA) Color(0xFF1E90FF)
                                    else Color(0xFF8B0000),
                                    shape = CircleShape
                                )
                        )
                    }
                }
            }
        }

        selectedAviso?.let { aviso ->
            Dialog(onDismissRequest = { selectedAviso = null }) {
                Card(
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(20.dp)
                            .verticalScroll(rememberScrollState()),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = aviso.imageResId),
                            contentDescription = null,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(180.dp)
                                .clip(RoundedCornerShape(12.dp)),
                            contentScale = ContentScale.Crop
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        Text(
                            text = aviso.title,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black,
                            textAlign = TextAlign.Center
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            text = aviso.description,
                            fontSize = 14.sp,
                            color = Color.DarkGray,
                            textAlign = TextAlign.Justify,
                            lineHeight = 20.sp
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Button(
                            onClick = { selectedAviso = null },
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF003087))
                        ) {
                            Text("Cerrar", color = Color.White)
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
