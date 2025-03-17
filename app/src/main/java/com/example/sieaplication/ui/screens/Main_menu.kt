package com.example.sieaplication.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.sieaplication.R
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.ui.text.style.TextAlign
import coil.compose.AsyncImage
import androidx.navigation.NavHostController
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Build
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.sieaplication.ui.components.SliderMenu

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Main_Menu(navController: NavHostController) {
    // Scaffold: Barra superior fija y un contenedor para el contenido desplazable
    Scaffold(

        // Barra superior (TopAppBar)
        topBar = {
            TopAppBar(
                title = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        // Logo a la izquierda dentro del título
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
                // Ícono de ajustes a la derecha (actions)
                actions = {
                    IconButton(onClick = { }) {
                        Icon(
                            imageVector = Icons.Default.AccountCircle,
                            contentDescription = "Settings",
                            tint = Color.White
                        )
                    }
                },
                // Colores de la barra
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF00A7A7), // Color turquesa (ajusta a tu gusto)
                    titleContentColor = Color.White
                )
            )
        },
        // Color de fondo general del Scaffold
        containerColor = Color(0xFF121212) // Ajusta según tu tema. Si prefieres claro: Color.White
    ) { innerPadding ->

        // Contenido desplazable
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())  // Habilita scroll
                .background(Color(0xFF121212))          // Fondo (mismo color que Scaffold)
        ) {
            // 1) Tarjeta con info del estudiante
            StudentInfoCard(
                name = "Humberto Martin de la Torre",
                career = "Ing. en Sistemas Computacionales",
                semester = "8",
                controlNumber = "C17150832"
            )

            Spacer(modifier = Modifier.height(16.dp))

            // 2) Rejilla de 8 botones (2 col x 4 filas)
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Fila 1
                Row(horizontalArrangement = Arrangement.Center) {
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
                // Fila 2
                Row(horizontalArrangement = Arrangement.Center) {
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
                // Fila 3
                Row(horizontalArrangement = Arrangement.Center) {
                    ButtonCuadrado(
                        text = "Reinscripción",
                        imageRes = R.drawable.inscripsion_icon,
                        onClick = {}
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    ButtonCuadrado(
                        text = "Avisos Tecnm",
                        imageRes = R.drawable.aviso_icon,
                        onClick = { navController.navigate("screen_avisos")}
                    )
                }
                // Fila 4
                Row(horizontalArrangement = Arrangement.Center) {
                    ButtonCuadrado(
                        text = "Documentos",
                        imageRes = R.drawable.docuemntos_icon,
                        onClick = {}
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    ButtonCuadrado(
                        text = "Credencial Digital",
                        imageRes = R.drawable.credencial_digital_icon,
                        onClick = {}
                    )
                }
            }

            Spacer(modifier = Modifier.height(32.dp))
        }
    }

}

// (A) Tarjeta con info del estudiante
@Composable
fun StudentInfoCard(
    name: String,
    career: String,
    semester: String,
    controlNumber: String
) {
    // Card con fondo gris claro (para resaltar)
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF1E1E1E) // Fondo algo más claro que 0xFF121212
        )
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Nombre: $name",
                color = Color.White
            )
            Text(
                text = "Carrera: $career",
                color = Color.White
            )
            Text(
                text = "Semestre: $semester",
                color = Color.White
            )
            Text(
                text = "No. Control: $controlNumber",
                color = Color.White
            )
        }
    }
}

// (B) Botón cuadrado con imagen e ícono
@Composable
fun ButtonCuadrado(
    text: String,
    imageRes: Int,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier.size(160.dp),
        shape = RoundedCornerShape(0.dp),
        // Fondo azul oscuro
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF003366)
        )
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                text = text,
                textAlign = TextAlign.Center,
                color = Color.White, // Texto blanco
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            // Imagen (Ícono)
            AsyncImage(
                model = imageRes,
                contentDescription = "Imagen",
                modifier = Modifier.size(80.dp)
            )
        }
    }
}