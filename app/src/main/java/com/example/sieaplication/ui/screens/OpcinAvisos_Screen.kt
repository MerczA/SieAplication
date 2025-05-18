package com.example.sieaplication.ui.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
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
    val avisosSecundarios = listOf(
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

    var showDialog by remember { mutableStateOf(false) }
    var selectedAviso by remember { mutableStateOf<Aviso?>(null) }

    Scaffold(
        topBar = { BarsScreens("Avisos", navController) },
        containerColor = Color(0xFFEAEAEA)
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(1f)
                    .padding(top = 16.dp),
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
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "TODOS LOS AVISOS",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF003087)
                        )
                    }

                    LazyColumn(
                        modifier = Modifier.fillMaxWidth().weight(1f),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        item {
                            Column(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
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

                                Column(
                                    modifier = Modifier.padding(top = 8.dp),
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.spacedBy(4.dp)
                                ) {
                                    Text(
                                        text = "Se consolida el TecNM como Mejor Escuela de Ingeniería del País",
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color.DarkGray,
                                        textAlign = TextAlign.Center
                                    )
                                    Text(
                                        text = "Reconoce ANFEI al ITA como la mejor escuela de ingeniería en México.",
                                        fontSize = 14.sp,
                                        color = Color.DarkGray,
                                        textAlign = TextAlign.Center,
                                        lineHeight = 20.sp
                                    )
                                }
                            }
                        }

                        items(avisosSecundarios) { aviso ->
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(100.dp)
                                    .clickable {
                                        selectedAviso = aviso
                                        showDialog = true
                                    },
                                shape = RoundedCornerShape(8.dp),
                                elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
                                colors = CardDefaults.cardColors(containerColor = Color.White)
                            ) {
                                Row(
                                    modifier = Modifier.fillMaxSize(),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .width(4.dp)
                                            .fillMaxHeight()
                                            .background(
                                                if (aviso.source == AvisoSource.CARRERA) Color(0xFF1E90FF)
                                                else Color(0xFF8B0000)
                                            )
                                    )
                                    Row(
                                        modifier = Modifier
                                            .weight(1f)
                                            .padding(8.dp),
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                                    ) {
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

                                        Column(
                                            modifier = Modifier.weight(1f),
                                            verticalArrangement = Arrangement.spacedBy(4.dp)
                                        ) {
                                            Text(
                                                text = aviso.title,
                                                fontSize = 14.sp,
                                                fontWeight = FontWeight.Bold,
                                                color = Color.DarkGray
                                            )
                                        }
                                    }
                                    Box(
                                        modifier = Modifier
                                            .width(4.dp)
                                            .fillMaxHeight()
                                            .background(
                                                if (aviso.source == AvisoSource.CARRERA) Color(0xFF1E90FF)
                                                else Color(0xFF8B0000)
                                            )
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }

        // Diálogo emergente
        if (showDialog && selectedAviso != null) {
            Dialog(onDismissRequest = { showDialog = false }) {
                Card(
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(16.dp)
                            .verticalScroll(rememberScrollState()),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = selectedAviso!!.imageResId),
                            contentDescription = null,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(200.dp),
                            contentScale = ContentScale.Fit
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = selectedAviso!!.title,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black,
                            textAlign = TextAlign.Center
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = selectedAviso!!.description,
                            fontSize = 14.sp,
                            color = Color.DarkGray,
                            textAlign = TextAlign.Justify
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Button(onClick = { showDialog = false }) {
                            Text("Cerrar")
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
