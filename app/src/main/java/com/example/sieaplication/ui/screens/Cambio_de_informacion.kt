package com.example.sieaplication.ui.screens

import android.app.DatePickerDialog
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.sieaplication.R
import java.util.Calendar

@Composable
fun PersonalInfoEditScreen(navController: NavHostController) {
    val context = LocalContext.current

    // Estados con la información "guardada" (actual)
    var currentName by remember { mutableStateOf("Juan") }
    var currentLastName by remember { mutableStateOf("Pérez") }
    var currentAddress by remember { mutableStateOf("Calle Falsa 123") }
    var currentPhone by remember { mutableStateOf("555-123456") }
    var currentBirthDate by remember { mutableStateOf("") }

    // Estados para la edición (temporales)
    var tempName by remember { mutableStateOf(currentName) }
    var tempLastName by remember { mutableStateOf(currentLastName) }
    var tempAddress by remember { mutableStateOf(currentAddress) }
    var tempPhone by remember { mutableStateOf(currentPhone) }
    var tempBirthDate by remember { mutableStateOf(currentBirthDate) }

    var showDatePicker by remember { mutableStateOf(false) }
    var showAlertDialog by remember { mutableStateOf(false) }

    // Mostrar DatePickerDialog para actualizar tempBirthDate
    if (showDatePicker) {
        val calendar = Calendar.getInstance()
        DatePickerDialog(
            context,
            { _, year, month, dayOfMonth ->
                tempBirthDate = "$dayOfMonth/${month + 1}/$year"
                showDatePicker = false
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        ).show()
    }

    Scaffold(
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
            // Tarjeta que muestra la información actual guardada
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(text = "Nombre: $currentName", fontSize = 16.sp)
                    Text(text = "Apellido: $currentLastName", fontSize = 16.sp)
                    Text(text = "Dirección: $currentAddress", fontSize = 16.sp)
                    Text(text = "Teléfono: $currentPhone", fontSize = 16.sp)
                    Text(
                        text = "Fecha de nacimiento: ${if (currentBirthDate.isEmpty()) "No seleccionada" else currentBirthDate}",
                        fontSize = 16.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Campos de entrada que modifican los datos temporales
            OutlinedTextField(
                value = tempName,
                onValueChange = { tempName = it },
                label = { Text("Nombre") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = tempLastName,
                onValueChange = { tempLastName = it },
                label = { Text("Apellido") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = tempAddress,
                onValueChange = { tempAddress = it },
                label = { Text("Dirección") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = tempPhone,
                onValueChange = { tempPhone = it },
                label = { Text("Teléfono") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Campo para fecha de nacimiento: al hacer clic se abre el DatePicker
            OutlinedTextField(
                value = tempBirthDate,
                onValueChange = { },
                label = { Text("Fecha de nacimiento") },
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { showDatePicker = true },
                enabled = false,
                placeholder = { Text("Selecciona la fecha de nacimiento") }
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Botón para guardar cambios (actualiza los datos actuales con los temporales)
            Button(
                onClick = { showAlertDialog = true },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Guardar cambios")
            }
        }
    }

    // AlertDialog para confirmar la acción de guardar
    if (showAlertDialog) {
        AlertDialog(
            onDismissRequest = { showAlertDialog = false },
            title = { Text("Confirmar cambios") },
            text = { Text("¿Estás seguro de guardar los cambios?") },
            confirmButton = {
                TextButton(
                    onClick = {
                        // Actualizamos la información actual con lo editado
                        currentName = tempName
                        currentLastName = tempLastName
                        currentAddress = tempAddress
                        currentPhone = tempPhone
                        currentBirthDate = tempBirthDate
                        showAlertDialog = false
                    }
                ) {
                    Text("Sí")
                }
            },
            dismissButton = {
                TextButton(onClick = { showAlertDialog = false }) {
                    Text("No")
                }
            }
        )
    }
}
