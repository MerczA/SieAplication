package com.example.sieaplication.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import kotlinx.coroutines.delay

@Composable
fun LoadingScreen(navController: NavController) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
    LaunchedEffect(Unit) {
        // Espera 2 segundos (ajusta el tiempo según tus necesidades)
        delay(1000L)
        // Navega a la pantalla principal
        navController.navigate("main_menu") {
            // Opcional: evita volver a la pantalla de login
            popUpTo("login") { inclusive = true }
        }
    }
}
