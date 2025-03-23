package com.example.sieaplication.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.sieaplication.R

@Composable
fun AvisosCarreraScreenPreview(navController: NavController) {
    AvisosCarreraScreen(navController = navController)
}

@Composable
fun AvisosCarreraScreen(navController: NavController) {
    // Lista de avisos secundarios con datos personalizados
    val avisosSecundarios = listOf(
        Aviso(
            imageResId = R.drawable.avisoscarrerauno, // Cambia por el ID de tu imagen
            title = "Open House",
            description = "Los laborarios de redes no estaran disponibles el 27 de marzo por motivos del evento "
        ),
        Aviso(
            imageResId = R.drawable.avisoscarrerados, // Cambia por el ID de tu imagen
            title = "Atención Psicologica",
            description = "Acudir a este correo si necesitas atención psicologica, atn.psicologica@aguascalientes.tecnm.mx "
        ),
        Aviso(
            imageResId = R.drawable.avisoscarreratres, // Cambia por el ID de tu imagen
            title = "Objetos olvidados en el CC",
            description = "Dejaron estos termos en el area A del CC"
        ),
        Aviso(
            imageResId = R.drawable.avisoscarreracuatro, // Cambia por el ID de tu imagen
            title = "Objetos olvidados",
            description = "Olvidaron unos lentes, se encuentra con la cordinadora"
        )
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White) // Fondo blanco para consistencia
            .padding(16.dp)
    ) {
        // 🔹 Botón de "Atrás" en la parte superior izquierda
        IconButton(
            onClick = { navController.navigate("screen_avisos") },
            modifier = Modifier.align(Alignment.TopStart)
        ) {
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Atrás")
        }

        // Tarjeta principal
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.85f) // Reducimos la altura para un diseño más limpio
                .align(Alignment.Center),
            shape = RoundedCornerShape(12.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Encabezado
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "AVISOS [TICS]",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        color = Color(0xFF003087) // Azul oscuro para el título
                    )
                }

                // Aviso principal: Imagen grande arriba, título y texto debajo
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Imagen principal
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                            .background(Color(0xFFF5F5F5))
                            .border(1.dp, Color(0xFFDDDDDD), RoundedCornerShape(8.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.avisoscarreaprincipal),
                            contentDescription = "Imagen principal",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Fit
                        )
                    }

                    // Título y texto principal debajo de la imagen
                    Column(
                        modifier = Modifier.padding(top = 8.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        // Título en negritas
                        Text(
                            text = "Torneo de FIFA",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.DarkGray,
                            textAlign = TextAlign.Center
                        )

                        // Texto descriptivo
                        Text(
                            text = "Los alumnos de la materia de Administración de proyectos, estamos organizando el siguiente evento: \n" +
                                    "Para los interesados las inscripciones pueden ser en el enlace que está en comentarios, en el salón 51 de 9:00 a 10:00 am o si lo prefieren también puede ser conmigo.",
                            fontSize = 14.sp,
                            color = Color.DarkGray,
                            lineHeight = 20.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                }

                // Avisos secundarios en forma de lista desplazable (LazyColumn)
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f), // Ocupa el espacio restante
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(avisosSecundarios) { aviso ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(100.dp),
                            shape = RoundedCornerShape(8.dp),
                            elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
                            colors = CardDefaults.cardColors(containerColor = Color.White),
                            border = BorderStroke(1.dp, Color(0xFFDDDDDD))
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(8.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                // Placeholder para la imagen a la izquierda
                                Box(
                                    modifier = Modifier
                                        .size(60.dp)
                                        .background(Color(0xFFF5F5F5))
                                        .border(1.dp, Color(0xFFDDDDDD), RoundedCornerShape(8.dp)),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = "Imagen",
                                        color = Color.Gray,
                                        fontSize = 10.sp
                                    )

                                    // Código comentado para agregar una imagen real
                                    Image(
                                        painter = painterResource(id = aviso.imageResId),
                                        contentDescription = "Imagen de ${aviso.title}",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.Fit
                                    )

                                }

                                // Columna para el título y el texto a la derecha de la imagen
                                Column(
                                    modifier = Modifier.weight(1f),
                                    verticalArrangement = Arrangement.spacedBy(4.dp)
                                ) {
                                    // Título en negritas
                                    Text(
                                        text = aviso.title,
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color.DarkGray
                                    )

                                    // Texto descriptivo debajo del título
                                    Text(
                                        text = aviso.description,
                                        fontSize = 12.sp,
                                        color = Color.DarkGray,
                                        lineHeight = 16.sp
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AvisosCarreraScreenPreview() {
    AvisosCarreraScreen(navController = NavController(LocalContext.current))
}