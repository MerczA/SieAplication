package com.example.sieaplication.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.sieaplication.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Bars(navController: NavController) {
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
                            navController.navigate("general_info")}
                    )
                    DropdownMenuItem(
                        text = { Text("Cambiar datos") },
                        onClick = {
                            menuExpanded = false
                            navController.navigate("edit_personal_info")}
                    )
                    DropdownMenuItem(
                        text = { Text("Cambiar contraseña") },
                        onClick = {
                            menuExpanded = false
                            navController.navigate("new_password")}
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
    }

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BarsScreens(navController: NavController) {
    TopAppBar(
        title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = { navController.navigate("main_menu") }) {
                    Icon(imageVector = Icons.Default.Menu, contentDescription = "Atrás")
                }
                Spacer(modifier = Modifier.width(4.dp))
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
                            navController.navigate("general_info")}
                    )
                    DropdownMenuItem(
                        text = { Text("Cambiar datos") },
                        onClick = {
                            menuExpanded = false
                            navController.navigate("edit_personal_info")}
                    )
                    DropdownMenuItem(
                        text = { Text("Cambiar contraseña") },
                        onClick = {
                            menuExpanded = false
                            navController.navigate("new_password")}
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
}


