package com.example.sieaplication.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import com.example.sieaplication.R


@Composable
fun PasswordRecoveryScreen(navController: NavController){
    var controlNumber by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }


    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Image(
            painter= painterResource(id= R.drawable.logotec),
            contentDescription = "Logo del ITA",
            modifier = Modifier
                .size(320.dp)
        )
        Text(
            text="Ingrese Datos de Recuperacion",
            fontSize= 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF303F9F),
            modifier = Modifier
                .padding(top=16.dp)
        )
        Spacer (
            modifier = Modifier
                .height(20.dp)
        )
        OutlinedTextField(
            value= controlNumber,
            onValueChange = {controlNumber = it},
            label = {Text("Número de Control")},
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
        )
        Spacer (
            modifier = Modifier
                .height(12.dp)
        )
        OutlinedTextField(
            value= email,
            onValueChange = {email = it},
            label = {Text("Correo Electrónico")},
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
        )
        Spacer (
            modifier = Modifier
                .height(12.dp)
        )
        Button(
            onClick = { //navega a la pantalla de confirmacion de recuperacion
            },
            colors= ButtonDefaults.buttonColors(containerColor = Color(0xFF303F9F)),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(text = "Recuperar", color = Color.White)
        }

    }
}
