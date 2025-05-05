package com.example.sieaplication.ui.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sieaplication.data.viewmodel.RecordatorioViewModel
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun AgregarRecordatorioScreen(viewModel: RecordatorioViewModel) {
    var texto by remember { mutableStateOf("") }
    var fecha by remember { mutableStateOf(SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Date())) }
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE3F2FD))
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Nuevo Recordatorio",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF0D47A1)
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = texto,
            onValueChange = { texto = it },
            label = { Text("Escribe tu recordatorio") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = false,
            maxLines = 3
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = fecha,
            onValueChange = { fecha = it },
            label = { Text("Fecha") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                if (texto.isNotBlank()) {
                    viewModel.agregarRecordatorio("$texto - Fecha: $fecha")
                    Toast.makeText(context, "Recordatorio guardado", Toast.LENGTH_SHORT).show()
                    texto = ""
                }
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1976D2))
        ) {
            Text("Guardar", color = Color.White)
        }
    }
}
