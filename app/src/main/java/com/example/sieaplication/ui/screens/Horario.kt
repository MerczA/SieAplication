package com.example.sieaplication.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.sieaplication.data.model.Horario
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.*
import androidx.navigation.NavController
import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.sp
import com.example.sieaplication.ui.components.BarsScreens


@Composable
fun PreviewHorarioScreen(navController: NavController) {
    HorarioScreen(navController = navController)
}
@Composable
fun HorarioScreen(navController: NavController) {
    val horarios = listOf(
        Horario(1, "TALLER INVESTIG.", 4, 7, "HECTOR SALVADOR GONZALEZ", "10:00-11:00", "Lunes a Jueves"),
        Horario(2, "DES. APL / DISP. MOV", 4, 7, "ITIC RICARDO EMMANUEL REY", "07:00-08:00", "Lunes a Jueves"),
        Horario(3, "SIS OP I", 5, 6, "LIC. MIRIAM MALO TORRES", "12:00-13:00", "Lunes a Viernes"),
        Horario(4, "NEGOCIOS ELEC I", 4, 7, "EDGAR RAUL BAÑUELOS DIAZ", "08:00-09:00", "Lunes a Jueves"),
        Horario(5, "REDES EMERGENTES", 5, 7, "DR. MARCO ANTONIO HERNAND", "11:00-12:00", "Lunes a Viernes"),
        Horario(6, "TELECOM", 5, 6, "LIC. CYNTHIA VANESSA TEJE", "13:00-14:00", "Lunes a Viernes")
    )

    Scaffold(
        topBar = { BarsScreens("Horarios" , navController) } // Usa Scaffold para manejar la TopBar correctamente
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues) // Esto evita que se empalme con la TopBar
                .padding(horizontal = 16.dp, vertical = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(horarios) { horario ->
                    FlipCard(horario = horario)
                }
            }
        }
    }
}



@Composable
fun FlipCard(horario: Horario) {
    var isFlipped by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .shadow(8.dp, shape = RoundedCornerShape(16.dp))
            .clip(RoundedCornerShape(16.dp))
            .clickable { isFlipped = !isFlipped },
        colors = CardDefaults.cardColors(containerColor = Color.Transparent)
    ) {
        if (isFlipped) {
            BackCard(horario)
        } else {
            FrontCard(horario)
        }
    }
}

@Composable
fun FrontCard(horario: Horario) {
    Card(
        modifier = Modifier.fillMaxSize(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF42A5F5))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = horario.nombreMateria,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color.White,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Column {
                    Text("Créditos: ${horario.creditos}", color = Color.White, fontWeight = FontWeight.SemiBold)
                    Text("Semestre: ${horario.semestre}", color = Color.White)
                }
                Column {
                    Text("Docente: ${horario.docente}", color = Color.White, fontWeight = FontWeight.SemiBold)
                    Text("Horario: ${horario.horario}", color = Color.White)
                }
            }
        }
    }
}

@Composable
fun BackCard(horario: Horario) {
    val diasSemana = listOf("Lunes", "Martes", "Miércoles", "Jueves", "Viernes")
    val diasDisponibles = when (horario.creditos) {
        in 5..Int.MAX_VALUE -> diasSemana
        else -> listOf("Lunes", "Martes", "Miércoles", "Jueves")
    }

    Card(
        modifier = Modifier.fillMaxSize(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF90CAF9))
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Días de Clase",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                diasSemana.forEach { dia ->
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .background(
                                color = if (dia in diasDisponibles) Color.Green else Color.Red,
                                shape = CircleShape
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = dia.first().toString(), color = Color.White, fontWeight = FontWeight.Bold)
                    }
                }
            }
        }
    }
}

