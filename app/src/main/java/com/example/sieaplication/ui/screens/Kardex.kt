package com.example.sieaplication.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.unit.dp
import com.example.sieaplication.data.model.Kardex
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.sieaplication.ui.components.Bars
import com.example.sieaplication.ui.components.SliderMenu

@Composable
fun KardexInfo(navController: NavController) {
    Bars()
    val student = Kardex(
        controlNumber = "22151197",
        name = "GEZA GEOVANNI MERCZ ARELLANO",
        curp = "MEAG040730HASRRZA7",
        period = "ENE-JUN25",
        selectedStudy = "ING. TICS",
        plan = "ITIC-2010-225",
        specialty = "TECNOLOGÍAS DIGITALES EMERGENTES",
        status = "VIGENTE",
        admission = "2223 AGODIC2022",
        validatedSemesters = 0,
        totalCredits = 260,
        approvedCredits = 153,
        progressPercentage = 58,
        totalSubjects = 50,
        takenSubjects = 33,
        approvedSubjects = 33,
        gpaWithFails = 94.3,
        gpaWithoutFails = 94.3,
        semester = 6,
        currentSubjects = 7,
        currentCredits = 31
    )


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Botón de regreso arriba a la izquierda
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            IconButton(
                onClick = { navController.navigate("main_menu") }
            ) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Atrás")
            }
        }

        // Título
        Text(
            text = "Información del Estudiante",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(8.dp))

        // Tarjeta con información del estudiante
        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                InfoRow(label = "Nombre", value = student.name)
                InfoRow(label = "No. Control", value = student.controlNumber)
                InfoRow(label = "CURP", value = student.curp)
                InfoRow(label = "Período", value = student.period)
                Divider(modifier = Modifier.padding(vertical = 8.dp))

                InfoRow(label = "Carrera", value = student.selectedStudy)
                InfoRow(label = "Plan", value = student.plan)
                InfoRow(label = "Especialidad", value = student.specialty)
                InfoRow(label = "Situación", value = student.status)
                Divider(modifier = Modifier.padding(vertical = 8.dp))

                InfoRow(label = "Ingreso", value = student.admission)
                InfoRow(label = "Semestres Validados", value = student.validatedSemesters.toString())
                InfoRow(label = "Créditos Plan", value = student.totalCredits.toString())
                InfoRow(label = "Créditos Aprobados", value = student.approvedCredits.toString())
                InfoRow(label = "Porcentaje", value = "${student.progressPercentage}%")
                Divider(modifier = Modifier.padding(vertical = 8.dp))

                InfoRow(label = "Materias Totales", value = student.totalSubjects.toString())
                InfoRow(label = "Materias Cursadas", value = student.takenSubjects.toString())
                InfoRow(label = "Materias Aprobadas", value = student.approvedSubjects.toString())
                InfoRow(label = "Prom. con Rep", value = student.gpaWithFails.toString())
                InfoRow(label = "Prom. sin Rep", value = student.gpaWithoutFails.toString())
                InfoRow(label = "Semestre", value = student.semester.toString())
                InfoRow(label = "Materias Cursando", value = student.currentSubjects.toString())
                InfoRow(label = "Créditos Cursando", value = student.currentCredits.toString())
            }
        }
    }
}

@Composable
fun InfoRow(label: String, value: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = label, fontWeight = FontWeight.Bold)
        Text(text = value, color = Color.Gray)
    }
}
