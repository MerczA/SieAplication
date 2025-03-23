package com.example.sieaplication.data.model

data class Kardex(
    val controlNumber: String,
    val name: String,
    val curp: String,
    val period: String,
    val selectedStudy: String,
    val plan: String,
    val specialty: String,
    val status: String,
    val admission: String,
    val validatedSemesters: Int,
    val totalCredits: Int,
    val approvedCredits: Int,
    val progressPercentage: Int,
    val totalSubjects: Int,
    val takenSubjects: Int,
    val approvedSubjects: Int,
    val gpaWithFails: Double,
    val gpaWithoutFails: Double,
    val semester: Int,
    val currentSubjects: Int,
    val currentCredits: Int
)
