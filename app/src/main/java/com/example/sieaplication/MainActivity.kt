package com.example.sieaplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sieaplication.ui.screens.AvisosCarreraScreenPreview
import com.example.sieaplication.ui.screens.AvisosSelectorScreenPreview
import com.example.sieaplication.ui.screens.AvisosTecnmScreenPreview
import com.example.sieaplication.ui.screens.Main_Menu
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
fun ComposeMultiScreenApp() { //La navegacion entre pantallas
    val navController = rememberNavController()
    SetupNavGraph(navController = navController)
}

@Composable
fun SetupNavGraph(navController: NavHostController) { //Es el que nos va mandar a la pantalla del menu que vamos a querer por medio de una ruta
    NavHost(navController = navController, startDestination = "OpcionAvisos") {
        composable("main_menu") { Main_Menu(navController) }
        composable("AvisosTECNM") { AvisosTecnmScreenPreview(navController) }
        composable("AvisosCarrera") { AvisosCarreraScreenPreview(navController) }
        composable("OpcionAvisos") { AvisosSelectorScreenPreview(navController) }

    }
}






