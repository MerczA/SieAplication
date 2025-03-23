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
import com.example.sieaplication.data.model.Kardex
import com.example.sieaplication.ui.screens.AvisosCarreraScreenPreview
import com.example.sieaplication.ui.screens.AvisosOpcion
import com.example.sieaplication.ui.screens.AvisosTecnmScreenPreview
import com.example.sieaplication.ui.screens.CalificacionesTable
import com.example.sieaplication.ui.screens.Documentos
import com.example.sieaplication.ui.screens.KardexInfo
import com.example.sieaplication.ui.screens.LoginScreen
import com.example.sieaplication.ui.screens.Main_Menu
import com.example.sieaplication.ui.screens.PreviewHorarioScreen
import com.example.sieaplication.ui.screens.T_Digital
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
    NavHost(navController = navController, startDestination = "login") {
        composable("login") { LoginScreen(navController) }
        composable("main_menu") { Main_Menu(navController) }
        composable("calif_screen") { CalificacionesTable(navController) }
        composable("screen_horario") {PreviewHorarioScreen(navController) }
        composable("screen_kardex") { KardexInfo(navController) }
        composable("screen_avisos") {AvisosOpcion(navController) }
        composable("screen_avisos_tecnm") {AvisosTecnmScreenPreview(navController) }
        composable("screen_avisos_carrera") {AvisosCarreraScreenPreview(navController) }
        composable("T_Digital") { T_Digital(navController) }
        composable("screen_Documentos") { Documentos(navController) }





    }
}

