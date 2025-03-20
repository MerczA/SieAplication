package com.example.sieaplication.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import com.example.sieaplication.R

@Preview(showBackground = true)
@Composable
fun PasswordVerificationScreen() {
    var showDialog by remember { mutableStateOf(false) } //varible que muestra el AlertDialog
    var verificationCode by remember { mutableStateOf(List(6) { "" }) } //variable que almacena la lista del codigo de verififcacion
    val focusRequesters = List(6) { FocusRequester() }//mueve el foco al siguiente campo

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = {
                Text(
                    text = "Recuperación de la Contraseña",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            },
            text = {
                Text(
                    text = "La clave será enviada al correo que tienes registrado.",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            },
            confirmButton = {
                Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                    Button(onClick = { showDialog = false }) {
                        Text("OK")
                    }
                }
            }
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.logotec),
            contentDescription = "Logo ITA",
            modifier = Modifier.size(200.dp)
        )

        Text(
            text = "Restablecimiento de Contraseña",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF303F9F),
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 12.dp)
        )

        Button(
            onClick = { showDialog = true },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1B5E20)),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.fillMaxWidth(0.7f)
        ) {
            Text(text = "ENVIAR CÓDIGO", color = Color.White)
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Código:",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF303F9F),
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            verificationCode.forEachIndexed { index, value ->
                OutlinedTextField(
                    value = value,
                    onValueChange = {
                        if (it.length <= 1) {
                            val newCode = verificationCode.toMutableList()
                            newCode[index] = it
                            verificationCode = newCode
                            if (it.isNotEmpty() && index < 5) {
                                focusRequesters[index + 1].requestFocus()
                            }
                        }
                    },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number,
                        imeAction = if (index == 5) ImeAction.Done else ImeAction.Next
                    ),
                    modifier = Modifier
                        .size(50.dp)
                        .padding(4.dp)
                        .focusRequester(focusRequesters[index])
                        .onFocusChanged {
                            if (it.isFocused && verificationCode[index].isNotEmpty()) {
                                focusRequesters.getOrNull(index + 1)?.requestFocus()
                            }
                        }
                )
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = {  },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1B5E20)),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.fillMaxWidth(0.7f)
        ) {
            Text(text = "ENVIAR", color = Color.White)
        }
    }
}