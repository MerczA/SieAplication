package com.example.sieaplication.ui.screens


import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController

@Composable
fun TestScreen(navController: NavController) {
  TextComposable()
}

@Preview(showBackground = true)
@Composable
fun TextComposable() {
    Text("Welcome", modifier = Modifier)
}