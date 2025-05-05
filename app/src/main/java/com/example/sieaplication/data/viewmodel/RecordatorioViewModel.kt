package com.example.sieaplication.data.viewmodel
//archivo que se conecta con el Dao,y lanza las corrutinas

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sieaplication.data.model.RecordatorioDao
import com.example.sieaplication.data.model.RecordatorioEntity
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow //mantiene los datos actualizados en pantalla
import kotlinx.coroutines.launch

class RecordatorioViewModel(
    private val dao: RecordatorioDao
) : ViewModel() {

    private val _recordatorios = MutableStateFlow<List<RecordatorioEntity>>(emptyList())
    val recordatorios: StateFlow<List<RecordatorioEntity>> = _recordatorios

    fun agregarRecordatorio(texto: String) {
        viewModelScope.launch {
            val nuevo = RecordatorioEntity(texto = texto)
            dao.insertar(nuevo)

            val lista = dao.obtenerTodos()
            _recordatorios.value = lista

            //  Esto imprimirá en Logcat
            println("Recordatorio agregado: $texto")
            println("Lista actual de recordatorios:")
            lista.forEach {
                println(" ${it.id}: ${it.texto}")
            }
        }
    }

    fun cargarRecordatorios() {
        viewModelScope.launch {
            _recordatorios.value = dao.obtenerTodos()
        }
    }

    fun eliminarRecordatorio(id: Int) {
        viewModelScope.launch {
            dao.eliminarPorId(id)
            _recordatorios.value = dao.obtenerTodos()
        }
    }
}
