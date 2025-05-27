package com.example.sieaplication.data.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sieaplication.data.model.GrupoModel
import com.example.sieaplication.data.network.RetrofitClient
import com.example.sieaplication.data.model.UserModel
import com.google.gson.JsonObject
import kotlinx.coroutines.launch
import retrofit2.Response


class UserViewModel : ViewModel() {
    val api = RetrofitClient.api

    fun loginApi(user_model: UserModel, onResult: (JsonObject?) -> Unit){
        viewModelScope.launch {
            try {
                val response = api.login(user_model)
                if(response.isSuccessful){
                    val jsonResponse = response.body()
                    Log.d("debug", "${response.body()}")
                    onResult(jsonResponse)
                } else {
                    Log.d("debug", "Error: ${response.body()}")
                    onResult(null)
                }
            } catch (exception: Exception){
                Log.d("debug", "API CALL FAILED: $exception")
                onResult(null)
            }
        }
    }

    fun getGrupos(onResult: (Response<List<GrupoModel>>) -> Unit) {
        viewModelScope.launch {
            try {
                val response = api.getGrupos()
                Log.d("debug-grupo", response.toString())
                onResult(response)
            } catch (e: Exception) {
                Log.d("debug-grupo", "API ERROR: $e")
                onResult(Response.success(emptyList()))
            }
        }
    }
}