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
        topBar = { BarsScreens("Kardex", navController) },
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
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    SimpleInfo("Nombre: ${student.name}")
                    SimpleInfo("No. Control: ${student.controlNumber}")
                    SimpleInfo("CURP: ${student.curp}")
                    SimpleInfo("Período: ${student.period}")

                    Divider(modifier = Modifier.padding(vertical = 8.dp))

                    SimpleInfo("Carrera: ${student.selectedStudy}")
                    SimpleInfo("Plan: ${student.plan}")
                    SimpleInfo("Especialidad: ${student.specialty}")
                    SimpleInfo("Situación: ${student.status}")

                    Divider(modifier = Modifier.padding(vertical = 8.dp))

                    SimpleInfo("Ingreso: ${student.admission}")
                    SimpleInfo("Semestres Validados: ${student.validatedSemesters}")
                    SimpleInfo("Créditos Plan: ${student.totalCredits}")
                    SimpleInfo("Créditos Aprobados: ${student.approvedCredits}")
                    SimpleInfo("Porcentaje: ${student.progressPercentage}%")

                    Divider(modifier = Modifier.padding(vertical = 8.dp))

                    SimpleInfo("Materias Totales: ${student.totalSubjects}")
                    SimpleInfo("Materias Cursadas: ${student.takenSubjects}")
                    SimpleInfo("Materias Aprobadas: ${student.approvedSubjects}")
                    SimpleInfo("Prom. con Rep: ${student.gpaWithFails}")
                    SimpleInfo("Prom. sin Rep: ${student.gpaWithoutFails}")
                    SimpleInfo("Semestre: ${student.semester}")
                    SimpleInfo("Materias Cursando: ${student.currentSubjects}")
                    SimpleInfo("Créditos Cursando: ${student.currentCredits}")
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Button(
                onClick = { navController.navigate("screen_kardex_full") },
                modifier = Modifier
                    .width(250.dp)
                    .align(Alignment.CenterHorizontally)
            ) {
                Text(text = "Ver Kardex por semestre")
            }
            Button(
                onClick = { navController.navigate("full_kardex") },
                modifier = Modifier
                    .width(250.dp)
                    .align(Alignment.CenterHorizontally)
            ) {
                Text(text = "Ver Kardex gráfico completo")
            }
        }
    }
}

@Composable
fun SimpleInfo(text: String) {
    Text(
        text = text,
        style = TextStyle(fontSize = 16.sp),
        color = Color.Black,
        modifier = Modifier.padding(vertical = 4.dp)
    )
}
