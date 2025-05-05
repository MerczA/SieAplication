package com.example.sieaplication.data.model
//archivo para definir la estructura de los datos que se van a guardar
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recordatorios")
data class RecordatorioEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val texto: String
)
