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
import com.example.sieaplication.ui.screens.AvisosOpcion
import com.example.sieaplication.ui.screens.Documentos
import com.example.sieaplication.ui.screens.CalificacionesScreen
import com.example.sieaplication.ui.screens.GeneralInfoScreen
import com.example.sieaplication.ui.screens.HorarioPorSemestreScreen
import com.example.sieaplication.ui.screens.KardexInfo
import com.example.sieaplication.ui.screens.LoadingScreen
import com.example.sieaplication.ui.screens.LoginScreen
import com.example.sieaplication.ui.screens.Main_Menu
import com.example.sieaplication.ui.screens.NewPasswordScreen
import com.example.sieaplication.ui.screens.Fichas_pago
import com.example.sieaplication.ui.screens.PasswordVerificationScreen
import com.example.sieaplication.ui.screens.PersonalInfoEditScreen
import com.example.sieaplication.ui.screens.PreviewHorarioScreen
import com.example.sieaplication.ui.screens.Reglamento
import com.example.sieaplication.ui.screens.T_Digital
import com.example.sieaplication.ui.theme.SieAplicationTheme
import androidx.room.Room
import com.example.sieaplication.data.model.AppDataBase
import com.example.sieaplication.data.viewmodel.RecordatorioViewModel
import androidx.compose.runtime.remember
import com.example.sieaplication.ui.screens.AgregarRecordatorioScreen
import com.example.sieaplication.ui.screens.ListaRecordatoriosScreen



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

    //  Instanciar base de datos
    val context = androidx.compose.ui.platform.LocalContext.current
     val db = Room.databaseBuilder(
        context,
        AppDataBase::class.java,
        "recordatorios_db"
    ).build()

    //  Instanciar ViewModel
    val recordatorioViewModel = remember {
        RecordatorioViewModel(db.recordatorioDao())
    }
    //  Pasar el ViewModel como argumento
    SetupNavGraph(navController = navController, recordatorioViewModel = recordatorioViewModel)
}


@Composable
fun SetupNavGraph(
    navController: NavHostController,
    recordatorioViewModel: RecordatorioViewModel
) {
    NavHost(navController = navController, startDestination = "login") {
        composable("login") { LoginScreen(navController) }
        composable("loading") { LoadingScreen(navController) }
        composable("main_menu") { Main_Menu(navController) }
        composable("calif_screen") { CalificacionesScreen(navController) }
        composable("screen_horario") {PreviewHorarioScreen(navController) }
        composable("screen_kardex") { KardexInfo(navController) }
        composable("screen_avisos") {AvisosOpcion(navController) }
        composable("T_Digital") { T_Digital(navController) }
        composable("screen_Documentos") { Documentos(navController) }
        composable("screen_Ficha") { Fichas_pago(navController) }
        composable("screen_Reglamento") { Reglamento(navController) }
        composable("screen_kardex_full") {HorarioPorSemestreScreen(navController) }
        composable("recoveryPassword") {PasswordVerificationScreen(navController) }
        composable("new_password") {NewPasswordScreen(navController) }
        composable("edit_personal_info") { PersonalInfoEditScreen(navController) }
        composable("general_info") {GeneralInfoScreen(navController) }
        composable("agregar_recordatorio") { AgregarRecordatorioScreen(viewModel = recordatorioViewModel) }
        composable("ver_recordatorios") { ListaRecordatoriosScreen(viewModel = recordatorioViewModel) }
    }
}


