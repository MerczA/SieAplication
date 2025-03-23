package com.example.sieaplication.data.model

data class Materia(
    val nombre: String,
    val calificaciones: List<Double>
) {
    fun obtenerPromedio(): Double {
        return calificaciones.average()
    }
}

