package com.example.sieaplication.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.sieaplication.R

//pantalla de login
@Composable
fun LoginScreen(navController: NavController){
    var controlNumber by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column (
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ){

        Image(
            painter = painterResource(id =R.drawable.logotec),
            contentDescription = "Logo ITA",
            modifier = Modifier
            .size(350.dp)
        )

        Text(
            text = "Sistema de Integración Escolar",
            fontSize=20.sp,
            fontWeight = FontWeight.Bold,
            color = Color (0xFF303F9F),
            modifier = Modifier
                .padding(top=16.dp)
        )
        Spacer (
            modifier = Modifier
                .height(20.dp)
        )
        OutlinedTextField(
            value = controlNumber,
            onValueChange = {controlNumber = it},
            label = {Text("Número de Control")},
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth(0.8f)
        )
        Spacer (
            modifier = Modifier
                .height(12.dp)
        )
        OutlinedTextField(
            value = password,
            onValueChange = {password = it},
            label = {Text("Clave de Acceso")},
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth(0.8f)
        )
        Spacer (
            modifier = Modifier
                .height(20.dp)
        )
        Button(
            onClick = {navController.navigate("main_menu") },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1A237E)),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth(0.6f)
        ) {
            Text("Iniciar Sesión", color = Color.White)
        }
        Spacer (
            modifier = Modifier
                .height(10.dp)
        )
        TextButton(onClick = { /*recuperar contraseña*/ }) {
            Text("Recuperar Clave de Acceso", color = Color(0xFF3D5AFE))
        }
    }
}