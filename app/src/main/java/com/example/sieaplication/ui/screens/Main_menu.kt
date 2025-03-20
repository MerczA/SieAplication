package com.example.sieaplication.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
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
                    var menuExpanded by remember { mutableStateOf(false) }
                    Box {
                        IconButton(onClick = { menuExpanded = !menuExpanded }) {
                            Icon(
                                imageVector = Icons.Default.AccountCircle,
                                contentDescription = "Abrir menú",
                                tint = Color.White
                            )
                        }
                        DropdownMenu(
                            expanded = menuExpanded,
                            onDismissRequest = { menuExpanded = false }
                        ) {
                            DropdownMenuItem(
                                text = { Text("Información personal") },
                                onClick = { menuExpanded = false }
                            )
                            DropdownMenuItem(
                                text = { Text("Información domicilio y contacto") },
                                onClick = { menuExpanded = false }
                            )
                            DropdownMenuItem(
                                text = { Text("Información escolar") },
                                onClick = { menuExpanded = false }
                            )
                            DropdownMenuItem(
                                text = { Text("Cambiar datos") },
                                onClick = { menuExpanded = false }
                            )
                            DropdownMenuItem(
                                text = { Text("Cambiar contraseña") },
                                onClick = { menuExpanded = false }
                            )
                            DropdownMenuItem(
                                text = { Text("Cerrar sesión") },
                                onClick = { menuExpanded = false }
                            )
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF2196F3),
                    titleContentColor = Color.White
                )
            )
        },
        containerColor = Color(0xFFEAEAEA)
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            // Tarjeta de info: .fillMaxWidth() para ajustarse a la pantalla
            StudentInfoCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                name = "Humberto Martin de la Torre",
                career = "Ing. en Sistemas Computacionales",
                semester = "8",
                controlNumber = "C17150832"
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Fila 1
            ButtonRow(
                leftButtonText = "Calificaciones",
                leftButtonIcon = R.drawable.calificaciones_icon,
                onLeftClick = { navController.navigate("calif_screen") },
                rightButtonText = "Horario",
                rightButtonIcon = R.drawable.horario_icon,
                onRightClick = { navController.navigate("screen_horario") }
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Fila 2
            ButtonRow(
                leftButtonText = "Kardex",
                leftButtonIcon = R.drawable.kardex_icon,
                onLeftClick = { navController.navigate("screen_kardex") },
                rightButtonText = "Grupos en preparación",
                rightButtonIcon = R.drawable.grupos_en_preparacion_icon,
                onRightClick = {}
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Fila 3
            ButtonRow(
                leftButtonText = "Reinscripción",
                leftButtonIcon = R.drawable.inscripsion_icon,
                onLeftClick = {},
                rightButtonText = "Avisos Tecnm",
                rightButtonIcon = R.drawable.aviso_icon,
                onRightClick = { navController.navigate("screen_avisos") }
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Fila 4 de botones
            Row(
                modifier = Modifier.width(GRID_WIDTH),
                horizontalArrangement = Arrangement.Center
            ) {
                ButtonCuadrado(
                    text = "Documentos",
                    imageRes = R.drawable.docuemntos_icon,
                    onClick = {}
                )
                Spacer(modifier = Modifier.width(16.dp))
                ButtonCuadrado(
                    text = "Credencial Digital",
                    imageRes = R.drawable.credencial_digital_icon,
                    onClick = {navController.navigate("T_Digital")}
                )
            }

            // Fila 4
            ButtonRow(
                leftButtonText = "Documentos",
                leftButtonIcon = R.drawable.docuemntos_icon,
                onLeftClick = {},
                rightButtonText = "Credencial Digital",
                rightButtonIcon = R.drawable.credencial_digital_icon,
                onRightClick = {}
            )


            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}

/**
 * Muestra dos botones responsivos en una fila.
 * Cada botón ocupa la mitad del ancho, con aspectRatio(1f) para mantener la forma cuadrada.
 */
@Composable
fun ButtonRow(
    leftButtonText: String,
    leftButtonIcon: Int,
    onLeftClick: () -> Unit,
    rightButtonText: String,
    rightButtonIcon: Int,
    onRightClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Caja izquierda (mitad de la fila, cuadrada)
        Box(
            modifier = Modifier
                .weight(1f)       // Ocupa mitad del ancho
                .aspectRatio(1f)  // Forza forma cuadrada
        ) {
            ButtonSquare(
                text = leftButtonText,
                imageRes = leftButtonIcon,
                onClick = onLeftClick
            )
        }

        // Caja derecha (mitad de la fila, cuadrada)
        Box(
            modifier = Modifier
                .weight(1f)
                .aspectRatio(1f)
        ) {
            ButtonSquare(
                text = rightButtonText,
                imageRes = rightButtonIcon,
                onClick = onRightClick
            )
        }
    }
}

/**
 * Botón cuadrado que llena el espacio asignado por la caja que lo contiene.
 * La caja (Box) ya maneja el aspectRatio(1f).
 */
@Composable
fun ButtonSquare(
    text: String,
    imageRes: Int,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier.fillMaxSize(),
        shape = RoundedCornerShape(13.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF2196F3)
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
            Spacer(modifier = Modifier.height(10.dp))
            AsyncImage(
                model = imageRes,
                contentDescription = "Imagen",
                modifier = Modifier.size(90.dp)
            )
        }
    }
}

/**
 * Tarjeta con la información del estudiante, usando fillMaxWidth() para ajustarse a la pantalla.
 */
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
            Image(
                painter = painterResource(id = R.drawable.alumno_foto_perfil),
                contentDescription = "Foto de perfil",
                modifier = Modifier
                    .size(96.dp)
                    .padding(end = 16.dp)
                    .clip(CircleShape)
            )
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.spacedBy(3.dp)
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
