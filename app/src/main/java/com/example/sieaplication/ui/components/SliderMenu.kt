package com.example.sieaplication.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import com.example.sieaplication.data.model.MenuModel
import com.example.sieaplication.ui.screens.TablaCalificaciones
import kotlinx.coroutines.launch
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.DrawerValue
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.sieaplication.ui.screens.CalificacionesTable


@Composable
fun SliderMenu(navController: NavController) { // 🔹 Recibe el NavController
    val menuOptions = arrayOf(
        MenuModel(1, "Calificaciones", "calif_screen", Icons.Filled.AccountBox),
        MenuModel(1, "Horario", "screen_horario", Icons.Filled.AccountBox),
        MenuModel(1, "Kardex", "screen_kardex", Icons.Filled.AccountBox),
        MenuModel(1, "Calificaciones", "calif_screen", Icons.Filled.AccountBox),
        MenuModel(1, "Calificaciones", "calif_screen", Icons.Filled.AccountBox),
        MenuModel(1, "Calificaciones", "calif_screen", Icons.Filled.AccountBox),
        MenuModel(1, "Calificaciones", "calif_screen", Icons.Filled.AccountBox),
        MenuModel(1, "Calificaciones", "calif_screen", Icons.Filled.AccountBox)

    )

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Text("Menú", modifier = Modifier.padding(16.dp))
                HorizontalDivider()
                LazyColumn {
                    items(menuOptions) { item ->
                        NavigationDrawerItem(
                            icon = { Icon(item.icon, contentDescription = null) },
                            label = { Text(item.title) },
                            selected = false,
                            onClick = {
                                scope.launch { drawerState.close() } // Cierra el menú
                                navController.navigate(item.option) // 🔹 Navega a la pantalla
                            }
                        )
                    }
                }
            }
        }
    ) {}
}
