package com.example.sieaplication.data.model
//archivo de room, define que entidades usa la base de datos y como obtiene el DAO

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [RecordatorioEntity::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun recordatorioDao(): RecordatorioDao
}
