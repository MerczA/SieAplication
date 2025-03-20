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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.sieaplication.R

@Composable
fun NewPasswordScreen(navController: NavController){
    var newPassword by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    Column(
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
            text = "Recuperación de Contraseña",
            fontSize= 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color (0xFF303F9F),
            modifier = Modifier
                .padding(bottom = 20.dp)

        )
        OutlinedTextField(
            value = newPassword,
            onValueChange = {newPassword=it},
            label = {Text("Nueva Contraseña")},
            visualTransformation = PasswordVisualTransformation(),
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth(0.9f)
        )
        Spacer (
            modifier = Modifier
                .height(12.dp)
        )
        OutlinedTextField(
            value = confirmPassword,
            onValueChange = {confirmPassword=it},
            label = {Text("Verificar Contraseña")},
            visualTransformation = PasswordVisualTransformation(),
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth(0.9f)
        )
        Spacer (
            modifier = Modifier
                .height(20.dp)
        )
        Button(
            onClick = {navController.navigate("login")},
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1B5E20)),
            shape= RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth(0.7f)
        ) {
            Text (text= "Enviar", color = Color.White)
        }
    }
}
