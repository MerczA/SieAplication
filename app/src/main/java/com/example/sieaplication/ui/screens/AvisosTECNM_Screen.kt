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

// Clase de datos para representar un aviso secundario
data class Aviso(
    val imageResId: Int, // ID del recurso de la imagen
    val title: String,   // Título del aviso
    val description: String // Texto descriptivo del aviso
)

@Composable
fun AvisosTecnmScreenPreview(navController: NavController) {
    AvisosTecnmScreen(navController = navController)
}

@Composable
fun AvisosTecnmScreen(navController: NavController) {
    // Lista de avisos secundarios con datos personalizados
    val avisosSecundarios = listOf(
        Aviso(
            imageResId = R.drawable.avisotecnmuno, // Cambia por el ID de tu imagen
            title = "El ITA forma parte activa y sustancial",
            description = "Desde su ámbito y experiencia, el TecNM a través del Tecnológico de Aguascalientes, participará activamente en el desarrollo de iniciativas clave, especialmente en el tema de semiconductores, un sector fundamental para el futuro económico del estado, y con ello proyectarlo como bastión y semillero de proyectos tecnológicos que lo consoliden como un referente de competitividad en la región, el país y el mundo.\n" +
                    "\n"
        ),
        Aviso(
            imageResId = R.drawable.avisostecnmdos, // Cambia por el ID de tu imagen
            title = "Acuerdan líneas trabajo colaborativo",
            description = "El Instituto Tecnológico de Aguascalientes (ITA) fungió como sede de la primera reunión ordinaria de la Comisión #3 del Consejo de Institutos Tecnológicos e Instituciones Afines (CITIA) de la Asociación Nacional de Universidades e Instituciones de Educación Superior (ANUIES), en la que se abordaron las estrategias, líneas de trabajo y designación de comisiones, para establecer el “Programa para articular la Educación Media Superior y el Tecnológico Nacional de México."
        ),
        Aviso(
            imageResId = R.drawable.avisostecnmtres, // Cambia por el ID de tu imagen
            title = "Miembros de la Federación",
            description = "La Federación de Sindicatos de Trabajadores del Estado de Aguascalientes (FEDESA) y el TecNM Instituto Tecnológico de Aguascalientes (ITA), firmaron un convenio de colaboración con el objetivo de brindar oportunidades de formación y desarrollo académico tanto a los(as) más de 8 mil trabajadores del Estado, así como sus familias."
        ),
        Aviso(
            imageResId = R.drawable.avisostecnmcuatro, // Cambia por el ID de tu imagen
            title = "Estudiantes del Tecnológico de Aguascalientes conquistan los primeros lugares del INFOMATRIX",
            description = "HealthSensor y Ergo Tec igualmente obtuvieron las preseas de plata respectivamente y su participación en la Fase Nacional."
        ),
        Aviso(
            imageResId = R.drawable.avisostecnmcinco, // Cambia por el ID de tu imagen
            title = "Cierra ITA el año con más de 800 nuevos profesionistas titulados",
            description = "El TecNM Aguascalientes, la mejor escuela de ingeniería del País entrega a la sociedad en este 2024 mas de 800 egresados(as) de las licenciaturas en administración e informática, así como las ingenierías en eléctrica, electrónica, Tecnologías de la información y las comunicaciones, mecánica, materiales, química, gestión empresarial, industrial y en sistemas computacionales, al rendir protesta como nuevos profesionistas."
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
                        text = "AVISOS TECNM\nAGUASCALIENTES",
                        fontSize = 20.sp, // Aumentamos el tamaño para mejor jerarquía
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
                            .height(200.dp) // Aumentamos el tamaño de la imagen
                            .background(Color(0xFFF5F5F5)) // Fondo gris claro como fallback
                            .border(1.dp, Color(0xFFDDDDDD), RoundedCornerShape(8.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.tecnmmejorescuela),
                            contentDescription = "Imagen de TECNM",
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
                            text = "Se consolida el TecNM campus Instituto Tecnológico de Aguascalientes como Mejor Escuela de Ingeniería del País\n",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.DarkGray,
                            textAlign = TextAlign.Center
                        )

                        // Texto descriptivo
                        Text(
                            text = "Reconoce ANFEI AL TECNOLÓGICO de Aguascalientes como la mejor escuela de ingeniería en el país\n" +
                                    "Es el máximo reconocimiento que recibe una institución por su calidad educativa en el ámbito de las ingenierías.",
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
                                        .size(60.dp) // Tamaño más pequeño para la lista
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
                                    modifier = Modifier.weight(1f), // Ocupa el espacio restante
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
fun AvisosTecnmScreenPreview() {
    AvisosTecnmScreen(navController = NavController(LocalContext.current))
}