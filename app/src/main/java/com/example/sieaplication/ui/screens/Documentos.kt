package com.example.sieaplication.ui.screens

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.sieaplication.R
import com.example.sieaplication.ui.components.BarsScreens
import androidx.core.content.FileProvider
import java.io.File
import java.io.FileOutputStream

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Documentos(navController: NavHostController) {
    val context = LocalContext.current
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(id = R.drawable.logotec),
                            contentDescription = "Logo",
                            modifier = Modifier
                                .size(48.dp)
                                .padding(end = 8.dp)
                        )
                        Text("Sie")
                    }
                },
                actions = {
                    var menuExpanded by remember { mutableStateOf(false) }
                    Box {
                        IconButton(onClick = { menuExpanded = !menuExpanded }) {
                            Icon(
                                imageVector = Icons.Default.AccountCircle,
                                contentDescription = "Abrir menú",
                                tint = Color.White
                            )
                        }
                        DropdownMenu(
                            expanded = menuExpanded,
                            onDismissRequest = { menuExpanded = false }
                        ) {
                            DropdownMenuItem(
                                text = { Text("Información General") },
                                onClick = {
                                    menuExpanded = false
                                    navController.navigate("general_info")
                                }
                            )
                            DropdownMenuItem(
                                text = { Text("Cambiar datos") },
                                onClick = {
                                    menuExpanded = false
                                    navController.navigate("edit_personal_info")
                                }
                            )
                            DropdownMenuItem(
                                text = { Text("Cambiar contraseña") },
                                onClick = {
                                    menuExpanded = false
                                    navController.navigate("new_password")
                                }
                            )
                            DropdownMenuItem(
                                text = { Text("Cerrar sesión") },
                                onClick = { menuExpanded = false }
                            )
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF2196F3),
                    titleContentColor = Color.White
                )
            )
        },
        containerColor = Color(0xFFEAEAEA)
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 10.dp, bottom = 80.dp)
                    .padding(horizontal = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Atrás")
                    }
                    Text(
                        text = "Documentos",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.weight(1f)
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                DocumentButtonRow (
                    leftButtonText = "Ficha de pago",
                    leftButtonIcon = R.drawable.inscripsion_icon,
                    onLeftClick = { navController.navigate("screen_Ficha") },
                    rightButtonText = "Reglamento Estudiantil",
                    rightButtonIcon = R.drawable.inscripsion_icon,
                    onRightClick = {
                        abrirPdfDesdeAssets(context, "Reglamento_de_Estudiantes_del_TecNM.pdf")
                    }
                )

                Spacer(modifier = Modifier.height(16.dp))

                DocumentButtonRow (
                    leftButtonText = "Lineamientos de Residencias",
                    leftButtonIcon = R.drawable.inscripsion_icon,
                    onLeftClick = { abrirPdfDesdeAssets(context, "Residencias.pdf") },
                    rightButtonText = "Lineamientos de Servicio Social",
                    rightButtonIcon = R.drawable.inscripsion_icon,
                    onRightClick = {
                        abrirPdfDesdeAssets(context, "Servicio_Social.pdf")
                    }
                )

            }
        }
    }
}

@Composable
fun DocumentButtonRow(
    leftButtonText: String,
    leftButtonIcon: Int,
    onLeftClick: () -> Unit,
    rightButtonText: String,
    rightButtonIcon: Int,
    onRightClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        DocumentButton(
            text = leftButtonText,
            icon = leftButtonIcon,
            onClick = onLeftClick,
            modifier = Modifier.weight(1f)
        )
        DocumentButton(
            text = rightButtonText,
            icon = rightButtonIcon,
            onClick = onRightClick,
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
fun DocumentButton(
    text: String,
    icon: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .height(130.dp),
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2196F3)),
        elevation = ButtonDefaults.elevatedButtonElevation()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = icon),
                contentDescription = text,
                modifier = Modifier.size(48.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = text,
                fontSize = 14.sp,
                color = Color.White,
                textAlign = TextAlign.Center
            )
        }
    }

}
fun abrirPdfDesdeAssets(context: Context, assetFileName: String) {
    val file = File(context.cacheDir, assetFileName)
    if (!file.exists()) {
        context.assets.open(assetFileName).use { inputStream ->
            FileOutputStream(file).use { outputStream ->
                inputStream.copyTo(outputStream)
            }
        }
    }
    val uri: Uri = FileProvider.getUriForFile(
        context,
        context.packageName + ".fileprovider",
        file
    )
    val intent = Intent(Intent.ACTION_VIEW).apply {
        setDataAndType(uri, "application/pdf")
        flags = Intent.FLAG_GRANT_READ_URI_PERMISSION or Intent.FLAG_ACTIVITY_NO_HISTORY
    }
    context.startActivity(intent)
}

@Composable
fun MiPantalla() {
    val context = LocalContext.current

    Button(onClick = {
        abrirPdfDesdeAssets(context, "mi_archivo.pdf")
    }) {
        Text("Abrir PDF")
    }
}
