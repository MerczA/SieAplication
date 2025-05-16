package com.example.sieaplication.ui.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.sieaplication.R
import com.example.sieaplication.ui.components.BarsScreens


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Documentos(navController: NavHostController) {
    Scaffold(
        topBar = { BarsScreens("Documentos" , navController) },
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
                    .padding(top = 10.dp, bottom = 80.dp) // Espacio para la TopBar y BottomBar
                    .padding(horizontal = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(16.dp))

                ButtonRow(
                    leftButtonText = "Ficha de pago",
                    leftButtonIcon = R.drawable.inscripsion_icon,
                    onLeftClick = { navController.navigate("screen_Ficha") },
                    rightButtonText = "Reglamento",
                    rightButtonIcon = R.drawable.docuemntos_icon,
                    onRightClick = { navController.navigate("screen_Reglamento") }
                )

                Spacer(modifier = Modifier.height(16.dp))

            }
        }
    }
}