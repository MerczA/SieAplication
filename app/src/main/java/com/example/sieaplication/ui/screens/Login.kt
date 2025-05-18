package com.example.sieaplication.ui.screens

import android.content.Context
import android.util.Log
import android.widget.Toast
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
import androidx.compose.material3.AlertDialog
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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.sieaplication.R

import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.VisualTransformation
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.sieaplication.data.model.UserModel
import com.example.sieaplication.data.viewmodel.UserViewModel

@Composable
fun LoginScreen(navController: NavController) {

   LoginForm(navController)
}

@Composable
fun LoginForm(
    navController: NavController,
    viewModel: UserViewModel = viewModel()) {
    var user by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var showDialog by remember { mutableStateOf(false) }
    val scrollState = rememberScrollState() // Estado del scroll
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState), // Habilita el scroll vertical
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.logotec),
            contentDescription = "Logo ITA",
            modifier = Modifier.size(350.dp)
        )

        Text(
            text = "Sistema de Integración Escolar",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF303F9F),
            modifier = Modifier.padding(top = 16.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = user,
            onValueChange = { user = it },
            label = { Text("Número de Control") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(0.8f)
        )

        Spacer(modifier = Modifier.height(12.dp))

        var password by remember { mutableStateOf("") }
        var passwordVisible by remember { mutableStateOf(false) }

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Contraseña") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(0.8f),
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                val image = if (passwordVisible)
                    Icons.Filled.Visibility
                else
                    Icons.Filled.VisibilityOff

                // Icon button para alternar visibilidad
                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(imageVector = image, contentDescription = if (passwordVisible) "Ocultar contraseña" else "Mostrar contraseña")
                }
            }
        )


        Spacer(modifier = Modifier.height(20.dp))

        Button(

            onClick = { TryLogin(user,password, context, viewModel, navController) },


            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1A237E)),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.fillMaxWidth(0.6f)
        ) {
            Text("Iniciar Sesión", color = Color.White)
        }


        Spacer(
            modifier = Modifier
                .height(10.dp)
        )
        TextButton(onClick = { navController.navigate("recoveryPassword") }) {

            Spacer(modifier = Modifier.height(10.dp))

            TextButton(onClick = { navController.navigate("recoveryPassword") }) {

                Text("Recuperar Contraseña", color = Color(0xFF3D5AFE))
            }

            if (showDialog) {
                AlertDialog(
                    onDismissRequest = { showDialog = false },
                    containerColor = Color(0xFFE8EAF6),
                    titleContentColor = Color(0xFF303F9F),
                    textContentColor = Color(0xFF3F51B5),
                    confirmButton = {
                        Button(
                            onClick = { showDialog = false },
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3D5AFE))
                        ) {
                            Text("OK", color = Color.White)
                        }
                    },
                    title = { Text("Recuperación de la Contraseña") },
                    text = { Text("La contraseña será enviada al correo que tienes registrado.") }
                )
            }
        }
    }
}


fun TryLogin(user: String, password: String, context: Context, viewModel: UserViewModel, navController: NavController){
    if(user == "" || password == ""){
        Toast.makeText(
            context,
            "User or Password cannot be empty",
            Toast.LENGTH_SHORT
        ).show()
    } else {
        val user_Model = UserModel(0,"", user, password)
        viewModel.loginApi(user_Model){ jsonResponse ->
            val loginStatus = jsonResponse?.get("login")?.asString
            Log.d("debug", "LOGIN STATUS: $loginStatus")
            if(loginStatus == "success"){
                navController.navigate("main_menu")
            }else {
                Toast.makeText(
                    context,
                    "Credenciales Incorrectas, Vuelve a intentarlo",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}


