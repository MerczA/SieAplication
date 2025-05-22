package com.example.sieaplication.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.AlertDialogDefaults.containerColor
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.room.Room
import com.example.sieaplication.R
import com.example.sieaplication.data.model.AppDataBase
import com.example.sieaplication.data.viewmodel.RecordatorioViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BarsScreens(title: String, navController: NavController) {
    val context = LocalContext.current
    val db = Room.databaseBuilder(
        context,
        AppDataBase::class.java,
        "recordatorios_db"
    ).build()

    val viewModel = remember {
        RecordatorioViewModel(db.recordatorioDao())
    }

    val recordatorios by viewModel.recordatorios.collectAsState()

    var menuExpanded by remember { mutableStateOf(false) }

    TopAppBar(
        title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Atrás", tint = Color.White)
                }
                Spacer(modifier = Modifier.width(4.dp))
                Image(
                    painter = painterResource(id = R.drawable.logotec),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .size(48.dp)
                        .padding(end = 8.dp)
                )
                Text(text = title, color = Color.White, fontSize = 20.sp)
            }
        },
        actions = {
            // Notificación
            Box {
                IconButton(onClick = { navController.navigate("ver_recordatorios") }) {
                    Icon(Icons.Default.Notifications, contentDescription = "Notificaciones", tint = Color.White)
                }

                if (recordatorios.isNotEmpty()) {
                    Box(
                        modifier = Modifier
                            .offset(x = 12.dp, y = 4.dp)
                            .size(16.dp)
                            .clip(CircleShape)
                            .background(Color.Red),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = recordatorios.size.toString(),
                            color = Color.White,
                            fontSize = 10.sp
                        )
                    }
                }
            }

            // Menú
            Box {
                IconButton(onClick = { menuExpanded = !menuExpanded }) {
                    Icon(Icons.Default.AccountCircle, contentDescription = "Menú", tint = Color.White)
                }

                DropdownMenu(
                    expanded = menuExpanded,
                    onDismissRequest = { menuExpanded = false }
                ) {
                    DropdownMenuItem({ Text("Información General") }, { navController.navigate("general_info"); menuExpanded = false })
                    DropdownMenuItem({ Text("Cambiar datos") }, { navController.navigate("edit_personal_info"); menuExpanded = false })
                    DropdownMenuItem({ Text("Cambiar contraseña") }, { navController.navigate("new_password"); menuExpanded = false })
                    DropdownMenuItem({ Text("Recordatorios") }, { navController.navigate("agregar_recordatorio"); menuExpanded = false })
                    DropdownMenuItem({ Text("Ver recordatorios") }, { navController.navigate("ver_recordatorios"); menuExpanded = false })
                    DropdownMenuItem({ Text("Cerrar sesión") }, { navController.navigate("login"); menuExpanded = false })
                }
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF2196F3))
    )

    // Cargar recordatorios solo una vez
    LaunchedEffect(Unit) {
        viewModel.cargarRecordatorios()
    }
}
