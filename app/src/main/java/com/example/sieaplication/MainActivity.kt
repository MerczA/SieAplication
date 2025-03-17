package com.example.sieaplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sieaplication.ui.screens.CalificacionesTable
import com.example.sieaplication.ui.screens.Main_Menu
import com.example.sieaplication.ui.screens.PreviewHorarioScreen
import com.example.sieaplication.ui.screens.TablaCalificaciones
import com.example.sieaplication.ui.theme.SieAplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SieAplicationTheme {
                ComposeMultiScreenApp()
            }
        }
    }
}

@Composable
fun ComposeMultiScreenApp() {
    val navController = rememberNavController()
    SetupNavGraph(navController = navController)
}

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "main_menu") {
        composable("main_menu") { Main_Menu(navController) }
        composable("calif_screen") { CalificacionesTable(navController) }
        composable("screen_horario") {PreviewHorarioScreen(navController) }

    }
}



