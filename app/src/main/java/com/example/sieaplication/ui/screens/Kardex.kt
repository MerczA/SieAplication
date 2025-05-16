package com.example.sieaplication.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.sieaplication.data.model.Kardex
import com.example.sieaplication.ui.components.BarsScreens

@Composable
fun KardexInfo(navController: NavController) {
    val student = Kardex(
        controlNumber = "22151197",
        name = "GEZA GEOVANNI MERCZ ARELLANO",
        curp = "MEAG040730HASRRZA7",
        period = "ENE-JUN25",
        selectedStudy = "ING. TICS",
        plan = "ITIC-2010-225",
        specialty = "TECNOLOGÍAS DIGITALES E.",
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

    Scaffold(
        topBar = { BarsScreens("Kardex" , navController) },
        containerColor = Color(0xFFE0E0E0)
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 16.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            Card(
                modifier = Modifier
                    .fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    InfoRow("Nombre", student.name)
                    InfoRow("No. Control", student.controlNumber)
                    InfoRow("CURP", student.curp)
                    InfoRow("Período", student.period)
                    Divider(modifier = Modifier.padding(vertical = 8.dp))

                    InfoRow("Carrera", student.selectedStudy)
                    InfoRow("Plan", student.plan)
                    InfoRow("Especialidad", student.specialty)
                    InfoRow("Situación", student.status)
                    Divider(modifier = Modifier.padding(vertical = 8.dp))

                    InfoRow("Ingreso", student.admission)
                    InfoRow("Semestres Validados", student.validatedSemesters.toString())
                    InfoRow("Créditos Plan", student.totalCredits.toString())
                    InfoRow("Créditos Aprobados", student.approvedCredits.toString())
                    InfoRow("Porcentaje", "${student.progressPercentage}%")
                    Divider(modifier = Modifier.padding(vertical = 8.dp))

                    InfoRow("Materias Totales", student.totalSubjects.toString())
                    InfoRow("Materias Cursadas", student.takenSubjects.toString())
                    InfoRow("Materias Aprobadas", student.approvedSubjects.toString())
                    InfoRow("Prom. con Rep", student.gpaWithFails.toString())
                    InfoRow("Prom. sin Rep", student.gpaWithoutFails.toString())
                    InfoRow("Semestre", student.semester.toString())
                    InfoRow("Materias Cursando", student.currentSubjects.toString())
                    InfoRow("Créditos Cursando", student.currentCredits.toString())
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = { navController.navigate("screen_kardex_full") },
                modifier = Modifier
                    .width(220.dp)
                    .align(Alignment.CenterHorizontally)
            ) {
                Text(text = "Ver Kardex gráfico")
            }

            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}

@Composable
fun InfoRow(label: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
            color = Color.DarkGray
        )
        Text(
            text = value,
            style = MaterialTheme.typography.bodyLarge,
            color = Color.Black
        )
    }
}