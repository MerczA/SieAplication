package com.example.sieaplication.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sieaplication.data.model.Horario
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.*
import androidx.navigation.NavController
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.ui.unit.dp
import com.example.sieaplication.data.model.TableScores
import com.example.sieaplication.ui.components.SliderMenu


@Composable
fun PreviewHorarioScreen(navController: NavController) {
    HorarioScreen(navController = navController)
}


@Composable
fun HorarioScreen(navController: NavController) {
    val horarios = listOf( // Convierte a List directamente
        Horario(1, "TALLER INVESTIG.", 4, 7, "HECTOR SALVADOR GONZALEZ", "10:00-11:00", "Lunes a Jueves"),
        Horario(2, "DES. APL / DISP. MOV", 4, 7, "ITIC RICARDO EMMANUEL REY", "07:00-08:00", "Lunes a Jueves"),
        Horario(3, "SIS OP I", 4, 6, "LIC. MIRIAM MALO TORRES", "12:00-13:00", "Lunes a Jueves"),
        Horario(4, "NEGOCIOS ELEC I", 4, 7, "EDGAR RAUL BAÑUELOS DIAZ", "08:00-09:00", "Lunes y Jueves"),
        Horario(5, "REDES EMERGENTES", 5, 7, "DR. MARCO ANTONIO HERNAND", "11:00-12:00", "Lunes a Viernes"),
        Horario(6, "TELECOM", 5, 6, "LIC. CYNTHIA VANESSA TEJE", "13:00-14:00", "Lunes a Viernes"),
        Horario(7, "INTERA HUM COM", 4, 7, "DOC. RICARDO MENDOZA GONZ", "09:00-10:00", "Lunes a Jueves")
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Botón de regreso mejor ubicado
        IconButton(
            onClick = { navController.navigate("main_menu") },
            modifier = Modifier.align(Alignment.Start)
        ) {
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Atrás")
        }

        Text(
            text = "Horario de Clases",
            fontWeight = FontWeight.Bold,
            fontSize = MaterialTheme.typography.headlineSmall.fontSize,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .border(2.dp, Color.Black)
                .padding(8.dp)
        ) {
            items(horarios) { horario ->
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 12.dp, horizontal = 8.dp)
                        .border(1.dp, Color.Gray)
                        .background(Color.LightGray)
                        .padding(16.dp)
                ) {
                    Text(
                        text = horario.nombreMateria,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text("Créditos: ${horario.creditos}", fontWeight = FontWeight.Bold)
                            Spacer(modifier = Modifier.height(4.dp))
                            Text("Semestre: ${horario.semestre}")
                        }
                        Spacer(modifier = Modifier.width(16.dp))
                        Column(modifier = Modifier.weight(2f)) {
                            Text("Docente: ${horario.docente}", fontWeight = FontWeight.Bold)
                            Spacer(modifier = Modifier.height(4.dp))
                            Text("Horario: ${horario.horario}")
                            Spacer(modifier = Modifier.height(4.dp))
                            Text("Días: ${horario.dias}")
                        }
                    }
                }
                Spacer(modifier = Modifier.height(12.dp))
            }
        }
    }

}


