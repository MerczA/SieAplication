package com.example.sieaplication.ui.screens


import android.content.ActivityNotFoundException
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import android.content.Context
import android.content.Intent
import android.os.Environment
import android.widget.Toast
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.FileProvider
import androidx.navigation.NavHostController
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Reglamento(navController: NavHostController) {
    val context = LocalContext.current
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Reglamento Escolar") },
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
            // Espaciado
            Spacer(modifier = Modifier.height(24.dp))
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Reglamento Escolar",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = {
            // Copiar el archivo desde assets a almacenamiento externo
            val fileName = "Reglamento_de_Estudiantes_del_TecNM.pdf"
            copiarPDFDesdeAssets(context, fileName)
        }) {
            Text("Ver Reglamento")
        }
    }
}

fun copiarPDFDesdeAssets(context: Context, fileName: String) {

    // Definir la ubicación de destino
    val outFile = File(context.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS), fileName)

    // Si el archivo no existe, lo copiamos desde assets
    if (!outFile.exists()) {
        try {
            context.assets.open(fileName).use { inputStream ->
                FileOutputStream(outFile).use { outputStream ->
                    inputStream.copyTo(outputStream)
                }
            }
        } catch (e: IOException) {
            e.printStackTrace()
            Toast.makeText(context, "Error al copiar el PDF desde assets", Toast.LENGTH_SHORT).show()
            return
        }
    }

    // Una vez copiado el archivo, lo abrimos
    abrirReglamentoPDF(context, outFile)
}

fun abrirReglamentoPDF(context: Context, file: File) {
    val pdfUri = FileProvider.getUriForFile(
        context,
        "${context.packageName}.fileprovider",
        file
    )

    val intent = Intent(Intent.ACTION_VIEW).apply {
        setDataAndType(pdfUri, "application/pdf")
        addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
    }

    try {
        context.startActivity(intent)
    } catch (e: ActivityNotFoundException) {
        Toast.makeText(context, "No hay una app para abrir archivos PDF", Toast.LENGTH_SHORT).show()
    }
}

