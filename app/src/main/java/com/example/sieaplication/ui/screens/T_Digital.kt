package com.example.sieaplication.ui.screens

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.content.pm.ActivityInfo
import android.graphics.Bitmap
import android.graphics.Color as AndroidColor // Renombrado para evitar conflicto
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color // Para Jetpack Compose
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.sieaplication.R
import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatWriter
import com.google.zxing.common.BitMatrix
import androidx.compose.ui.platform.LocalContext
import com.example.sieaplication.ui.components.Bars


@Composable
fun T_Digital(navController: NavHostController) {
    Bars(navController)
    var isFlipped by remember { mutableStateOf(false) } // Estado para voltear la tarjeta
    val qrBitmap = generateQRCode("https://sie.aguascalientes.tecnm.mx/cgi-bin/sie.pl?Opc=PINDEXESTUDIANTE&psie=intertec&dummy=0")
    val context = LocalContext.current
    val activity = remember { context.findActivity() } // Obtiene la Activity de forma segura

    LaunchedEffect(Unit) {
        activity?.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
    }

    DisposableEffect(Unit) {
        onDispose {
            activity?.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED
        }
    }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Bars(navController) // Se coloca arriba

        Spacer(modifier = Modifier.height(16.dp)) // Espaciado

        Box(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f),
            contentAlignment = Alignment.Center
        ) {
            DigitalCard()
        }
    }
}

@Composable
fun DigitalCard() {
    var isFlipped by remember { mutableStateOf(false) } // Estado para voltear la tarjeta
    val qrBitmap = generateQRCode("https://sie.aguascalientes.tecnm.mx/cgi-bin/sie.pl?Opc=PINDEXESTUDIANTE&psie=intertec&dummy=0")

    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(30.dp)
            .clickable { isFlipped = !isFlipped },
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        if (isFlipped) {
            // LADO POSTERIOR (QR)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                qrBitmap?.let {
                    Image(bitmap = it.asImageBitmap(), contentDescription = "QR Code", modifier = Modifier.size(150.dp))
                }
            }
        } else {
            // LADO FRONTAL (Datos del estudiante)
            Row(modifier = Modifier.padding(16.dp)) {
                // Foto del estudiante (izquierda)
                Image(
                    painter = painterResource(id = R.drawable.android), // Reemplázalo con la imagen real
                    contentDescription = "Foto del estudiante",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(200.dp) // Ajuste de tamaño
                        .clip(RoundedCornerShape(16.dp))
                )

                Spacer(modifier = Modifier.width(16.dp)) // Espaciado entre la foto y los datos

                // Datos del estudiante
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .height(IntrinsicSize.Min) // Ajusta la altura a los contenidos
                ) {
                    // Logo de la institución
                    Image(
                        painter = painterResource(id = R.drawable.ita_logo), // Reemplázalo con el logo real
                        contentDescription = "Logo de la institución",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier.height(100.dp) // Ajuste del tamaño
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    // Datos del alumno
                    Text("Nombre del Alumno", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                    Text("Carrera: Ingeniería en Sistemas", fontSize = 16.sp, color = Color.Gray)
                    Text("Número de Control: 12345678", fontSize = 16.sp, color = Color.Gray)

                    Spacer(modifier = Modifier.height(16.dp))

                    // Pie de tarjeta
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text("Estudiante", fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color.Gray)
                        Text("NNS: 987654321", fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color.Gray)
                    }
                }
            }
        }
    }
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
