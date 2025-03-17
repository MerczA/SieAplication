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
fun ComposeMultiScreenApp() {
    val navController = rememberNavController()
    SetupNavGraph(navController = navController)
}

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "main_menu") {
        composable("main_menu") {
            Main_Menu(
                onDatosGeneralesClick = { navController.navigate("datos_generales") },
                onCalificacionesClick = { navController.navigate("calificaciones") },
                onHorarioClick = { navController.navigate("horario") },
                onKardexClick = { navController.navigate("kardex") },
                onGruposPreparacionClick = { navController.navigate("grupos_preparacion") },
                onReinscripcionClick = { navController.navigate("reinscripcion") },
                onDocumentosClick = { navController.navigate("documentos") },
                onAjustesClick = { navController.navigate("ajustes") }
            )
        }


    }
}
