package com.example.sieaplication.ui.screens

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.graphics.Bitmap
import android.graphics.Color as AndroidColor // Renombrado para evitar conflicto
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.sieaplication.R
import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatWriter
import com.google.zxing.common.BitMatrix


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun T_Digital(navController: NavHostController) {

    val scrollState = rememberScrollState()
    val qrBitmap = generateAlumnoQRCode()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Documentos", fontWeight = FontWeight.Bold, fontSize = 20.sp) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Atrás")
                    }
                }
            )
        },
    content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .verticalScroll(scrollState)
                    .padding(horizontal = 16.dp, vertical = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Card(
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    elevation = CardDefaults.cardElevation(8.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        // Logo de la institución
                        Image(
                            painter = painterResource(id = R.drawable.ita_logo),
                            contentDescription = "Logo de la institución",
                            contentScale = ContentScale.Fit,
                            modifier = Modifier.height(100.dp)
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        // Datos del estudiante
                        Text(nombreAlumno, fontWeight = FontWeight.Bold, fontSize = 20.sp)
                        Text("Carrera: $carrera", fontSize = 14.sp, color = Color.Gray)
                        Text("Control: $numeroControl", fontSize = 16.sp, color = Color.Gray)

                        Spacer(modifier = Modifier.height(20.dp))

                        // Código QR centrado y adaptable
                        qrBitmap?.let {
                            Image(
                                bitmap = it.asImageBitmap(),
                                contentDescription = "Código QR",
                                modifier = Modifier
                                    .size(200.dp)
                            )
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        // NSS a la izquierda y "Estudiante" a la derecha
                        Row(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                "NSS: 987654321",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Gray
                            )
                            Spacer(modifier = Modifier.weight(1f))
                            Text(
                                "Estudiante",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Gray
                            )
                        }
                    }
                }
            }
        }
    )
}

// Datos del alumno
val nombreAlumno = "Humberto Martin de la Torre"
val carrera = "Ing. en Sistemas Computacionales"
val numeroControl = "C17150832"

// Función para obtener el contenido del QR con datos del alumno
fun getDatosAlumnoQR(): String {
    return "Nombre:$nombreAlumno;Carrera:$carrera;Control:$numeroControl"
}

// Función para generar el QR con los datos del alumno
fun generateAlumnoQRCode(): Bitmap? {
    val contenido = getDatosAlumnoQR()
    return generateQRCode(contenido)
}

// Generador de QR
fun generateQRCode(content: String): Bitmap? {
    return try {
        val size = 200
        val bitMatrix: BitMatrix = MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, size, size)
        val bitmap = Bitmap.createBitmap(size, size, Bitmap.Config.RGB_565)
        for (x in 0 until size) {
            for (y in 0 until size) {
                bitmap.setPixel(x, y, if (bitMatrix[x, y]) AndroidColor.BLACK else AndroidColor.WHITE)
            }
        }
        bitmap
    } catch (e: Exception) {
        e.printStackTrace()
        null
    }
}

fun Context.findActivity(): Activity? {
    var context = this
    while (context is ContextWrapper) {
        if (context is Activity) return context
        context = context.baseContext
    }
    return null
}
