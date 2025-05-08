package com.example.sieaplication.ui.screens



import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.sieaplication.data.model.Materia
import com.example.sieaplication.ui.components.Bars
import com.example.sieaplication.ui.components.BarsScreens


@Composable
fun CalificacionesScreen(navController: NavController) {
    BarsScreens(navController)
    val materias = listOf(
        Materia("TALLER INVESTIG.", listOf(90.0, 85.0, 88.0, 92.0, 87.0, 91.0)),
        Materia("DES. APL / DISP. MOV", listOf(80.0, 75.0, 78.0, 82.0, 77.0, 81.0)),
        Materia("SIS OP I", listOf(85.0, 88.0, 82.0, 89.0, 84.0, 87.0)),
        Materia("NEGOCIOS ELEC I", listOf(70.0, 72.0, 68.0, 74.0, 69.0, 73.0)),
        Materia("REDES EMERGENTES", listOf(95.0, 92.0, 96.0, 94.0, 91.0, 93.0)),
        Materia("TELECOM", listOf(78.0, 80.0, 76.0, 79.0, 75.0, 77.0)),
        Materia("INTERA HUM COM", listOf(88.0, 86.0, 89.0, 87.0, 85.0, 90.0))
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 95.dp)
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Botón de regreso y título
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {


            Text(
                text = "Calificaciones",
                fontWeight = FontWeight.Bold,
                fontSize = MaterialTheme.typography.headlineSmall.fontSize,
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(1f) // Esto lo centra correctamente
            )

        }

        // Lista de materias con tarjetas animadas
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            items(materias) { materia ->
                FlipCard(materia = materia)
                Spacer(modifier = Modifier.height(12.dp))
            }
        }
    }
}

@Composable
fun FlipCard(materia: Materia) {
    var isFlipped by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(160.dp)
            .clickable { isFlipped = !isFlipped },
        colors = CardDefaults.cardColors(
            containerColor = if (isFlipped) Color(0xFF4CAF50) else Color(0xFF2196F3), // Verde o Azul
            contentColor = Color.White
        ),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            if (isFlipped) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = "Promedio de la materia:", fontWeight = FontWeight.Bold)
                    Text(
                        text = "${String.format("%.1f", materia.obtenerPromedio())}",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.ExtraBold
                    )
                }
            } else {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = materia.nombre,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally,
                            ) {
                            Text("U1: ${materia.calificaciones[0]}")
                            Spacer(modifier = Modifier.height(5.dp))
                            Text("U2: ${materia.calificaciones[1]}")
                            Spacer(modifier = Modifier.height(5.dp))
                            Text("U3: ${materia.calificaciones[2]}")
                        }
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text("U4: ${materia.calificaciones[3]}")
                            Spacer(modifier = Modifier.height(5.dp))
                            Text("U5: ${materia.calificaciones[4]}")
                            Spacer(modifier = Modifier.height(5.dp))
                            Text("U6: ${materia.calificaciones[5]}")
                        }
                    }
                }
            }
        }
    }
}