package com.example.sieaplication.ui.screens

import android.app.DatePickerDialog
import android.content.Context
import android.os.Build
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.background
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import com.example.sieaplication.R
import com.example.sieaplication.data.viewmodel.RecordatorioViewModel
import com.example.sieaplication.ui.components.BarsScreens
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun AgregarRecordatorioScreen(viewModel: RecordatorioViewModel, navController: NavController) {
    val context = LocalContext.current
    var texto by remember { mutableStateOf("") }

    val calendar = Calendar.getInstance()
    var fechaSeleccionada by remember {
        mutableStateOf(SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(calendar.time))
    }

    // DatePickerDialog que se activa al tocar el campo de fecha
    val datePickerDialog = DatePickerDialog(
        context,
        { _, year, month, dayOfMonth ->
            val fecha = Calendar.getInstance().apply {
                set(year, month, dayOfMonth)
            }
            fechaSeleccionada = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(fecha.time)
        },
        calendar.get(Calendar.YEAR),
        calendar.get(Calendar.MONTH),
        calendar.get(Calendar.DAY_OF_MONTH)
    )

    Scaffold(
        topBar = {
            BarsScreens("Nuevo Recordatorio", navController)
        },
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(24.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                OutlinedTextField(
                    value = texto,
                    onValueChange = { texto = it },
                    label = { Text("Escribe tu recordatorio") },
                    modifier = Modifier.fillMaxWidth(),
                    maxLines = 3
                )

                // Campo de fecha clickeable
                OutlinedTextField(
                    value = fechaSeleccionada,
                    onValueChange = {},
                    label = { Text("Fecha") },
                    readOnly = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { datePickerDialog.show() }
                )

                Button(
                    onClick = {
                        if (texto.isNotBlank()) {
                            val mensaje = "$texto - Fecha: $fechaSeleccionada"
                            viewModel.agregarRecordatorio(mensaje)
                            mostrarNotificacion(context, mensaje)
                            Toast.makeText(context, "Recordatorio guardado", Toast.LENGTH_SHORT).show()
                            texto = ""
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2563EB))
                ) {
                    Text("Guardar", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.White)
                }
            }
        }
    )
}

fun mostrarNotificacion(context: Context, mensaje: String) {
    // Verifica si el permiso fue concedido
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU &&
        ContextCompat.checkSelfPermission(context, android.Manifest.permission.POST_NOTIFICATIONS)
        != android.content.pm.PackageManager.PERMISSION_GRANTED
    ) {
        return
    }

    val builder = NotificationCompat.Builder(context, "recordatorio_channel")
        .setSmallIcon(R.drawable.ic_notification) // asegúrate que exista en res/drawable/
        .setContentTitle("Recordatorio agregado")
        .setContentText(mensaje)
        .setPriority(NotificationCompat.PRIORITY_HIGH)

    NotificationManagerCompat.from(context).notify(Random().nextInt(), builder.build())
}
