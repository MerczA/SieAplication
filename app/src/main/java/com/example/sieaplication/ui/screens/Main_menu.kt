package com.example.sieaplication.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.sieaplication.R
import androidx.navigation.NavHostController

// Ancho total de cada fila de botones: 160dp + 16dp + 160dp = 336dp
val GRID_WIDTH = 336.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Main_Menu(navController: NavHostController) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(id = R.drawable.logotec),
                            contentDescription = "Logo",
                            modifier = Modifier
                                .size(48.dp)
                                .padding(end = 8.dp)
                        )
                        Text("Sie")
                    }
                },
                actions = {
                    // (A) Variable de estado para controlar el menú
                    var menuExpanded by remember { mutableStateOf(false) }

                    // (B) Contenedor del IconButton + DropdownMenu
                    Box {
                        // Botón del ícono (abre/cierra el menú)
                        IconButton(onClick = { menuExpanded = !menuExpanded }) {
                            Icon(
                                imageVector = Icons.Default.AccountCircle,
                                contentDescription = "Abrir menú",
                                tint = Color.White
                            )
                        }

                        // Menú desplegable
                        DropdownMenu(
                            expanded = menuExpanded,
                            onDismissRequest = { menuExpanded = false }
                        ) {
                            // 1) Información personal
                            DropdownMenuItem(
                                text = { Text("Información personal") },
                                onClick = {
                                    // Cierra el menú
                                    menuExpanded = false
                                    // Sin funcionalidad extra por ahora
                                }
                            )
                            // 2) Información domicilio y contacto
                            DropdownMenuItem(
                                text = { Text("Información domicilio y contacto") },
                                onClick = {
                                    menuExpanded = false
                                }
                            )
                            // 3) Información escolar
                            DropdownMenuItem(
                                text = { Text("Información escolar") },
                                onClick = {
                                    menuExpanded = false
                                }
                            )
                            // 4) Cambiar datos
                            DropdownMenuItem(
                                text = { Text("Cambiar datos") },
                                onClick = {
                                    menuExpanded = false
                                }
                            )
                            // 5) Cambiar contraseña
                            DropdownMenuItem(
                                text = { Text("Cambiar contraseña") },
                                onClick = {
                                    menuExpanded = false
                                }
                            )
                            // 6) Cerrar sesión
                            DropdownMenuItem(
                                text = { Text("Cerrar sesión") },
                                onClick = {
                                    menuExpanded = false
                                }
                            )
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF2196F3), // Color de la barra
                    titleContentColor = Color.White
                )
            )
        },
        containerColor = Color(0xFFEAEAEA) // Fondo de la pantalla
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            // Tarjeta de info (mismo ancho que las filas de botones)
            StudentInfoCard(
                modifier = Modifier.width(GRID_WIDTH),
                name = "Humberto Martin de la Torre",
                career = "Ing. en Sistemas Computacionales",
                semester = "8",
                controlNumber = "C17150832"
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Fila 1 de botones
            Row(
                modifier = Modifier.width(GRID_WIDTH),
                horizontalArrangement = Arrangement.Center
            ) {
                ButtonCuadrado(
                    text = "Calificaciones",
                    imageRes = R.drawable.calificaciones_icon,
                    onClick = {navController.navigate("calif_screen")}
                )
                Spacer(modifier = Modifier.width(16.dp))
                ButtonCuadrado(
                    text = "Horario",
                    imageRes = R.drawable.horario_icon,


                    onClick = { navController.navigate("screen_horario") }

                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Fila 2 de botones
            Row(
                modifier = Modifier.width(GRID_WIDTH),
                horizontalArrangement = Arrangement.Center
            ) {
                ButtonCuadrado(
                    text = "Kardex",
                    imageRes = R.drawable.kardex_icon,

                    onClick = { navController.navigate("screen_kardex") }

                )
                Spacer(modifier = Modifier.width(16.dp))
                ButtonCuadrado(
                    text = "Grupos en preparación",
                    imageRes = R.drawable.grupos_en_preparacion_icon,
                    onClick = {}
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Fila 3 de botones
            Row(
                modifier = Modifier.width(GRID_WIDTH),
                horizontalArrangement = Arrangement.Center
            ) {
                ButtonCuadrado(
                    text = "Reinscripción",
                    imageRes = R.drawable.inscripsion_icon,
                    onClick = {}
                )
                Spacer(modifier = Modifier.width(16.dp))
                ButtonCuadrado(
                    text = "Avisos Tecnm",
                    imageRes = R.drawable.aviso_icon,
                    onClick = {navController.navigate("screen_avisos")}
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Fila 4 de botones
            Row(
                modifier = Modifier.width(GRID_WIDTH),
                horizontalArrangement = Arrangement.Center
            ) {
                ButtonCuadrado(
                    text = "Documentos",
                    imageRes = R.drawable.docuemntos_icon,
                    onClick = {navController.navigate("screen_Documentos")}
                )
                Spacer(modifier = Modifier.width(16.dp))
                ButtonCuadrado(
                    text = "Credencial Digital",
                    imageRes = R.drawable.credencial_digital_icon,
                    onClick = {navController.navigate("T_Digital")}
                )
            }

            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}

// (A) Tarjeta con info del estudiante
@Composable
fun StudentInfoCard(
    modifier: Modifier = Modifier,
    name: String,
    career: String,
    semester: String,
    controlNumber: String
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Foto de perfil más grande (96.dp)
            Image(
                painter = painterResource(id = R.drawable.alumno_foto_perfil), // Reemplaza con tu recurso
                contentDescription = "Foto de perfil",
                modifier = Modifier
                    .size(96.dp)        // Aumenta el tamaño de la imagen
                    .padding(end = 16.dp)
                    .clip(CircleShape)
            )

            // Columna de texto a la derecha
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.spacedBy(3.dp) // Espacio entre líneas de texto
            ) {
                Text(
                    text = name,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.End,
                    color = Color.Black,
                    fontSize = 14.sp
                )
                Text(
                    text = "Carrera: $career",
                    textAlign = TextAlign.End,
                    color = Color.Black,
                    fontSize = 14.sp
                )
                Text(
                    text = "Semestre: $semester",
                    textAlign = TextAlign.End,
                    color = Color.Black,
                    fontSize = 14.sp
                )
                Text(
                    text = "Número de Control: $controlNumber",
                    textAlign = TextAlign.End,
                    color = Color.Black,
                    fontSize = 14.sp
                )
            }
        }
    }
}

// (B) Botón cuadrado con imagen
@Composable
fun ButtonCuadrado(
    text: String,
    imageRes: Int,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier.size(160.dp),  // Botón cuadrado 160x160
        shape = RoundedCornerShape(13.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF2196F3) // Color azul. Ajusta a tu gusto
        )
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                text = text,
                fontWeight = FontWeight.Bold,
                fontSize = 17.sp,
                textAlign = TextAlign.Center,
                color = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            AsyncImage(
                model = imageRes,
                contentDescription = "Imagen",
                modifier = Modifier.size(80.dp)
            )
        }
    }
}
