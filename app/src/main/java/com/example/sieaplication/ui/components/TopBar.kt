package com.example.sieaplication.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.sieaplication.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Bars() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {


        // TopAppBar en la parte superior
        TopAppBar(
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = colorResource(id = R.color.teal_200),
                titleContentColor = Color.White
            ),


            title = {
                Image(
                    painter = painterResource(id = R.drawable.logotec), // Reemplaza con tu logo
                    contentDescription = "Logo",
                    modifier = Modifier.size(80.dp)  // Ajusta según tu preferencia
                )
                Column(modifier = Modifier
                    .padding(80.dp,10.dp,0.dp,0.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text("Sie") }
                    },

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