package com.example.sieaplication.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.sieaplication.R
import com.example.sieaplication.data.model.MateriaKardex
import com.example.sieaplication.ui.components.Bars

@Composable
fun HorarioPorSemestreScreen(navController: NavController) {
    Bars(navController)
    val semestres = listOf(
        "I" to listOf(
            MateriaKardex("ACF0901", "CALC DIF", "5", "98", "Repetición"),
            MateriaKardex("AEF1032", "FUND DE PROGR", "5", "91", "Cursada"),
            MateriaKardex("TIF1019", "MATEM DIS I", "5", "76", "Cursada"),
            MateriaKardex("TIF1017", "INTRODUCCION A LAS TICS", "5", "97", "Cursada"),
            MateriaKardex("ACF0907", "TALLER DE ETICA", "4", "88", "Cursada"),
            MateriaKardex("ACC0906", "FUNDAMENTOS INVESTIG", "4", "76", "Cursada")
        ),
        "II" to listOf(
            MateriaKardex("ACF0902", "CALCULO INTEGRAL", "5", "80", "Cursada"),
            MateriaKardex("AEB1054", "PROG ORIEN A OBJ", "5", "75", "Cursada"),
            MateriaKardex("TIF1020", "MATEMATICAS DIS II", "5", "68", "Repetición"),
            MateriaKardex("AEF1052", "PROB Y ESTAD", "5", "72", "Cursada"),
            MateriaKardex("TIF1009", "CONTAB Y COSTOS", "5", "89", "Cursada"),
            MateriaKardex("ACF0903", "ALGEBRA LINEAL", "5", "91", "Cursada")
        ),
        "III" to listOf(
            MateriaKardex("TIF1021", "MATE TOMA DE DEC", "5", "74", "Cursada"),
            MateriaKardex("TIC1012", "ESTR Y ORG DE DATOS", "5", "88", "Cursada"),
            MateriaKardex("TIC1002", "ADMIN GERENCIAL", "5", "79", "Especial"),
            MateriaKardex("AEF1031", "FUND DE B.D.", "5", "83", "Cursada"),
            MateriaKardex("TIC1011", "ELECT Y MAGNE", "5", "69", "Cursada")
        ),
        "IV" to listOf(
            MateriaKardex("TIF1018", "MATE APL A COMUN", "4", "86", "Cursada"),
            MateriaKardex("TIB1024", "PROGRAMACION II", "5", "92", "Cursada"),
            MateriaKardex("TIF1001", "FUND DE REDES", "5", "89", "Cursada"),
            MateriaKardex("AE1063", "TALLER B.D.", "4", "84", "Cursada"),
            MateriaKardex("TIC1014", "ING SOFTWARE", "4", "71", "Cursada")
        ),
        "V" to listOf(
            MateriaKardex("TID1004", "ANÁLIS DE SEÑALES", "5", "70", "No tomada"),
            MateriaKardex("TIF1025", "REDES DE COMP.", "5", "87", "Cursada"),
            MateriaKardex("TIC1010", "ADMIN DE PROY", "5", "91", "Cursada"),
            MateriaKardex("TIC1007", "B.D. DISTRIB", "5", "82", "Especial"),
            MateriaKardex("TIC1005", "ARQ DE COMP.", "5", "89", "Repetición"),
            MateriaKardex("TIC1027", "TALLER DE ING. SW", "4", "85", "Cursada")
        ),
        "VI" to listOf(
            MateriaKardex("TIF1029", "TELECOM", "5", "69", "No tomada"),
            MateriaKardex("AEB1055", "PROGRA WEB", "5", "90", "Cursada"),
            MateriaKardex("TID1010", "DESARR. DE EMPREND.", "5", "82", "Especial"),
            MateriaKardex("ACD1008", "DESR SUST", "5", "88", "Cursada"),
            MateriaKardex("TIC1061", "SIS OPE I", "5", "","No tomada")
        ),
        "VII" to listOf(
            MateriaKardex("TIF1026", "REDES EMERGENTES", "5", "92", "Cursada"),
            MateriaKardex("AEB1011", "Des. APL / DISP. MOV", "5", "87", "Cursada"),
            MateriaKardex("ACA0909", "TALLER INVESTIG. I", "5", "76", "No tomada"),
            MateriaKardex("TIF1016", "INTERA HUM COM", "5", "89", "Cursada"),
            MateriaKardex("TIC1022", "NEGOCIOS ELEC I", "5", "83", "Especial")
        ),
        "VIII" to listOf(
            MateriaKardex("TIB1003", "ADMON Y SEG. DE RED", "5", "", "No tomada"),
            MateriaKardex("TIC1006", "AUDITORIA TEC. INF", "5", "", "No tomada"),
            MateriaKardex("TIC1015", "ING CONOCIMIENTO", "5", "", "No tomada"),
            MateriaKardex("TIC1023", "NEGOCIOS ELEC II", "5", "", "No tomada"),
            MateriaKardex("TDB2401", "COMPUTO EN LA NUBE", "5", "","No tomada"),
            MateriaKardex("TDB2402", "BIG DATA ANALYTICS", "5","" ,"No tomada")
        ),
        "IX" to listOf(
            MateriaKardex("TDB2403", "SEG TEC INFORM", "5", "","No tomada"),
            MateriaKardex("TDB2404", "APPS MOVILES MULTIPLA", "5","", "No tomada"),
            MateriaKardex("TDB2405", "TOP AVANZ DES WEB", "5", "","No tomada"),
            MateriaKardex("TDB2406", "SIST EMBEBIDOS EMERG", "5", "","No tomada"),
            MateriaKardex("TDB2407", "SIST GEN RECOL DATOS", "5", "","No tomada")
        )
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 90.dp) // Ajuste para la TopBar
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = { navController.navigate("screen_kardex") }, // Regresa a la pantalla anterior
                modifier = Modifier.size(24.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Atrás"
                )
            }

            Spacer(modifier = Modifier.weight(1f)) // Empuja el texto hacia el centro

            Text(
                text = "Kardex",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(2f) // Le da más peso al texto para centrarlo bien
            )

            Spacer(modifier = Modifier.weight(1f)) // Equilibra el espacio a la derecha
        }

        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            item {
                LazyRow(
                    modifier = Modifier.padding(8.dp)
                ) {
                    items(semestres) { (semestre, materias) ->
                        Column(
                            modifier = Modifier.padding(end = 5.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = semestre,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(8.dp),
                                textAlign = TextAlign.Center
                            )
                            materias.forEach { materia ->
                                MateriaBox(materia)
                            }
                        }
                    }
                }
            }
        }
    }


}

@Composable
fun MateriaBox(materia: MateriaKardex) {
    val color = when (materia.estado) {
        "Cursada" -> Color.Green
        "Repetición" -> Color.Cyan
        "Especial" -> Color.Yellow
        else -> Color.Gray
    }

    Box(
        modifier = Modifier
            .width(200.dp)
            .height(100.dp)
            .padding(4.dp)
            .border(2.dp, Color.Black, RoundedCornerShape(8.dp))
            .background(color, RoundedCornerShape(8.dp))
            .padding(8.dp)
    ) {
        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
            Text(text = materia.codigo, fontWeight = FontWeight.Bold, color = Color.Black)
            Text(text = materia.nombre, color = Color.Black)
            Text(text = "Créditos: ${materia.creditos}", color = Color.Black)
            Text(text = materia.calificacion, color = Color.Black)
        }
    }
}