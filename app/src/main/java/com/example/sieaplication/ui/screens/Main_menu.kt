package com.example.sieaplication.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.sieaplication.R

@Composable
fun Main_Menu(navController: NavController) {
    Bars()
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Bars() {


    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        // TopAppBar en la parte superior
        TopAppBar(
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = colorResource(id = R.color.blueColorMain),
                titleContentColor = Color.White
            ),

            title = { Text("Sie") },
            actions = {

                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Filled.Settings,
                        contentDescription = "Settings button"
                    )
                }
            }
        )

    }

}

@Composable
fun Options(){

}