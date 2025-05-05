package com.example.sieaplication.data.model
//archivo para insertar, leer y eliminar recordatorios desde la base de datos
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface RecordatorioDao {

    @Insert
    suspend fun insertar(recordatorio: RecordatorioEntity)

    @Query("SELECT * FROM recordatorios")
    suspend fun obtenerTodos(): List<RecordatorioEntity>

    @Query("DELETE FROM recordatorios WHERE id = :id")
    suspend fun eliminarPorId(id: Int)
}
