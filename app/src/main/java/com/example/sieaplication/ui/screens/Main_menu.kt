package com.example.sieaplication.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.sieaplication.R
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.text.style.TextAlign
import coil.compose.AsyncImage


@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun Main_Menu(
    onDatosGeneralesClick: () -> Unit = {},
    onCalificacionesClick: () -> Unit = {},
    onHorarioClick: () -> Unit = {},
    onKardexClick: () -> Unit = {},
    onGruposPreparacionClick: () -> Unit = {},
    onReinscripcionClick: () -> Unit = {},
    onDocumentosClick: () -> Unit = {},
    onAjustesClick: () -> Unit = {}
) {
    Box(modifier = Modifier.fillMaxSize()) {

        // (1) FILA SUPERIOR: Logo (izq) + Ajustes (der), anclada arriba
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter)   // Fija la fila en la parte superior
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.logotec), // Reemplaza con tu logo
                contentDescription = "Logo",
                modifier = Modifier.size(180.dp)  // Ajusta según tu preferencia
            )
            Button(onClick = onAjustesClick) {
                Text("Ajustes")
            }
        }

        // (2) CUADRÍCULA 2x3 CENTRADA en la pantalla
        Column(
            modifier = Modifier
                .align(Alignment.Center)           // Centra la columna en el Box
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp) // espacio vertical entre filas
        ) {
            // Fila 1: Datos Generales / Calificaciones
            Row(horizontalArrangement = Arrangement.Center) {
                ButtonCuadrado(
                    text = "Datos Generales",
                    imageRes = R.drawable.datos_generales,
                    onClick = {}
                )
                Spacer(modifier = Modifier.width(16.dp))
                ButtonCuadrado(
                    text = "Calificaciones",
                    imageRes = R.drawable.calificaciones_icon,
                    onClick = {}
                )
            }

            // Fila 2: Horario / Kardex
            Row(horizontalArrangement = Arrangement.Center) {
                ButtonCuadrado(
                    text = "Horario",
                    imageRes = R.drawable.horario_icon,
                    onClick = {}
                )
                Spacer(modifier = Modifier.width(16.dp))
                ButtonCuadrado(
                    text = "Kardex",
                    imageRes = R.drawable.kardex_icon,
                    onClick = {}
                )
            }

            // Fila 3: Grupos en preparación / Reinscripción
            Row(horizontalArrangement = Arrangement.Center) {
                ButtonCuadrado(
                    text = "Grupos en preparación",
                    imageRes = R.drawable.grupos_en_preparacion_icon,
                    onClick = {}
                )
                Spacer(modifier = Modifier.width(16.dp))
                ButtonCuadrado(
                    text = "Reinscripción",
                    imageRes = R.drawable.inscripsion_icon,
                    onClick = {}
                )
            }
        }

        // (3) BOTÓN DOCUMENTOS, anclado abajo
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter) // Fija la fila en la parte inferior
                .padding(16.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = onDocumentosClick,
                modifier = Modifier.size(width = 300.dp, height = 60.dp)
            ) {
                Text("Documentos")
            }
        }
    }
}

/**
 * Composable para un botón cuadrado, sin esquinas redondeadas
 * con tamaño suficiente (160.dp) para texto + ícono.
 */


@Composable
fun ButtonCuadrado(
    text: String,
    imageRes: Int, // Recurso del GIF (por ejemplo, R.drawable.mi_gif)
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier.size(160.dp),  // Botón cuadrado 160x160
        shape = RoundedCornerShape(0.dp)   // Esquinas rectas
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top  // Contenido en la parte superior
        ) {
            // Texto en la parte superior
            Text(
                text = text,
                textAlign = TextAlign.Center,      // Centra el texto horizontalmente
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            // Imagen (GIF) debajo del texto
            AsyncImage(
                model = imageRes,                  // Puede ser un recurso o una URL
                contentDescription = "Imagen gif",
                modifier = Modifier.size(80.dp)     // Ajusta el tamaño según lo necesites
            )
        }
    }
}