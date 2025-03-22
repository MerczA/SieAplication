package com.example.sieaplication.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.sieaplication.R
import com.example.sieaplication.ui.components.Bars

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GeneralInfoScreen(navController: NavHostController) {
    Scaffold(
        topBar = { Bars(navController) }, // Usa tu TopAppBar existente
        containerColor = Color(0xFFF5F5F5)
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Fila superior: botón de "Atrás" + título
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { navController.navigate("main_menu") }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Atrás"
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Cambio de Información",
                    fontWeight = FontWeight.Bold,
                    fontSize = MaterialTheme.typography.headlineSmall.fontSize
                )
            }

            // NUEVA tarjeta para esta pantalla, con foto centrada y campos adicionales
            GeneralStudentInfoCard(
                modifier = Modifier
                    .fillMaxWidth(),
                name = "Humberto Martin de la Torre",
                career = "Ing. en Sistemas Computacionales",
                semester = "8",
                controlNumber = "C17150832",
                address = "Av. Siempre Viva 742",
                phone = "555-1234567",
                curp = "HUMT123456HDFRNR07"
            )
        }
    }
}

/**
 * Tarjeta especial para la pantalla de Información General.
 * Muestra la foto de perfil centrada arriba y datos extra (dirección, teléfono, CURP).
 */
@Composable
fun GeneralStudentInfoCard(
    modifier: Modifier = Modifier,
    photoRes: Int = R.drawable.alumno_foto_perfil, // Reemplaza con tu recurso de imagen
    name: String,
    career: String,
    semester: String,
    controlNumber: String,
    address: String,
    phone: String,
    curp: String
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Foto de perfil centrada
            Image(
                painter = painterResource(id = photoRes),
                contentDescription = "Foto de perfil",
                modifier = Modifier
                    .size(200.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.height(50.dp))  // Más espacio entre imagen y textos

            // Columna de textos centrados
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center
                )
                Text(
                    text = "Carrera: $career",
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center
                )
                Text(
                    text = "Semestre: $semester",
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center
                )
                Text(
                    text = "Número de Control: $controlNumber",
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Dirección: $address",
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center
                )
                Text(
                    text = "Teléfono: $phone",
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center
                )
                Text(
                    text = "CURP: $curp",
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

