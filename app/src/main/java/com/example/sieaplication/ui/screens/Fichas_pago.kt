package com.example.sieaplication.ui.screens

import android.content.Context
import android.graphics.Color
import android.graphics.Paint
import android.graphics.pdf.PdfDocument
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import android.content.Intent
import android.graphics.Canvas
import android.os.Environment
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import android.graphics.Typeface
import android.net.Uri
import androidx.compose.ui.graphics.Color as ComposeColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.foundation.text.ClickableText

// CLASE DE DATOS
data class Servicio(val nombre: String, val costo: Double)

// PANTALLA PRINCIPAL
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Fichas_pago(navController: NavHostController) {
    val context = LocalContext.current
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Ficha de pago") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Atrás")
                    }
                }
            )
        },
        bottomBar = {
            // Aquí puedes agregar tu BottomBar si es necesario
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Mostrar la información del alumno
            val nombreAlumno = "Humberto Martin de la Torre"
            val carrera = "Ing. en Sistemas Computacionales"
            val numeroControl = "C17150832"

            StudentInfoCard(
                modifier = Modifier.fillMaxWidth(),
                name = nombreAlumno,
                career = carrera,
                semester = "8",
                controlNumber = numeroControl,
                adress = "Dirección de ejemplo"
            )

            // Espaciado
            Spacer(modifier = Modifier.height(24.dp))


            // Botón para generar la ficha de pago
            Button(
                onClick = {
                    generarFichaPagoPDF(context, nombreAlumno, carrera, numeroControl)
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Generar Ficha de Pago")
            }

            // Espaciado
            Spacer(modifier = Modifier.height(16.dp))

            // Texto debajo del botón
            Text(
                text = "Si quieres pagar más servicios visita:",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.fillMaxWidth(),
                color = ComposeColor.Black
            )


            // Hipervínculo
            val annotatedString = buildAnnotatedString {
                append("https://ciapagos.aguascalientes.tecnm.mx/")
                addStyle(
                    style = SpanStyle(color = ComposeColor.Blue),
                    start = 0,
                    end = this.length // Cambié `annotatedString.length` por `this.length`
                )
                addStringAnnotation(
                    tag = "URL",
                    annotation = "https://ciapagos.aguascalientes.tecnm.mx/",
                    start = 0,
                    end = this.length // Cambié `annotatedString.length` por `this.length`
                )
            }

            ClickableText(
                text = annotatedString,
                onClick = { offset ->
                    annotatedString.getStringAnnotations(offset, offset)
                        .firstOrNull()?.let { stringAnnotation ->
                            val url = stringAnnotation.item
                            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                            context.startActivity(intent)  // Esto abrirá el navegador con la URL
                        }
                },
                style = MaterialTheme.typography.bodyMedium.copy(color = ComposeColor.Blue)
            )


        }

    }
}

fun generarFichaPagoPDF(context: Context, nombreAlumno: String, carrera: String, numeroControl: String) {
    val pdfDocument = PdfDocument()
    val pageInfo = PdfDocument.PageInfo.Builder(595, 842, 1).create() // Tamaño A4
    val page = pdfDocument.startPage(pageInfo)

    val canvas: Canvas = page.canvas
    val paint = Paint().apply {
        color = Color.BLACK
        textSize = 14f
    }

    val titlePaint = Paint().apply {
        color = Color.BLACK
        typeface = Typeface.create(Typeface.DEFAULT, Typeface.BOLD)
        textSize = 20f
    }

    // Encabezado
    canvas.drawText("INSTITUTO TECNOLÓGICO DE AGUASCALIENTES", 70f, 50f, titlePaint)
    canvas.drawText("FICHA DE PAGO DE INSCRIPCIÓN", 140f, 80f, titlePaint)

    paint.textSize = 14f
    canvas.drawLine(50f, 100f, 545f, 100f, paint)

    // Información del alumno
    var y = 130f
    canvas.drawText("Nombre del Alumno:", 50f, y, paint)
    canvas.drawText(nombreAlumno, 200f, y, paint)
    y += 25f
    canvas.drawText("Carrera:", 50f, y, paint)
    canvas.drawText(carrera, 200f, y, paint)
    y += 25f
    canvas.drawText("Número de Control:", 50f, y, paint)
    canvas.drawText(numeroControl, 200f, y, paint)
    y += 40f

    canvas.drawLine(50f, y, 545f, y, paint)
    y += 30f


    // Detalles del pago
    canvas.drawText("Concepto:", 50f, y, paint)
    canvas.drawText("Inscripción semestre ago-dic 2025", 200f, y, paint)
    y += 25f
    canvas.drawText("Monto a pagar:", 50f, y, paint)
    canvas.drawText("$2,500 MXN", 200f, y, paint)
    y += 25f
    canvas.drawText("Referencia:", 50f, y, paint)
    canvas.drawText("ATM2025123456", 200f, y, paint)
    y += 25f
    canvas.drawText("Fecha límite de pago:", 50f, y, paint)
    canvas.drawText("10/06/2025", 200f, y, paint)

    y += 40f
    canvas.drawLine(50f, y, 545f, y, paint)
    y += 40f

    // Pie de página
    paint.textSize = 12f
    paint.color = Color.DKGRAY
    canvas.drawText("Favor de presentar esta ficha en ventanilla al realizar el pago.", 50f, y, paint)
    canvas.drawText("Este documento es generado automáticamente y no requiere firma o sello.", 50f, y + 20f, paint)

    pdfDocument.finishPage(page)

    val file = File(context.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS), "ficha_pago.pdf")

    try {
        pdfDocument.writeTo(FileOutputStream(file))

        val pdfUri: Uri = FileProvider.getUriForFile(
            context,
            "${context.packageName}.fileprovider",
            file
        )

        val intent = Intent(Intent.ACTION_VIEW).apply {
            setDataAndType(pdfUri, "application/pdf")
            addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        }

        val chooser = Intent.createChooser(intent, "Abrir ficha de pago")
        ContextCompat.startActivity(context, chooser, null)

    } catch (e: IOException) {
        e.printStackTrace()
        Toast.makeText(context, "Error al generar el PDF", Toast.LENGTH_SHORT).show()
    } finally {
        pdfDocument.close()
    }
}












