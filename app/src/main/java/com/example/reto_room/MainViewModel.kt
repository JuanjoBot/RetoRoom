package com.example.reto_room

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.reto_room.database.DatabaseManager
import com.example.reto_room.database.MyCoroutines
import com.example.reto_room.database.User
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
    fun guardarUsuarios(user: User){
        viewModelScope.launch{
            val userDao = DatabaseManager.instance.database.userDao()
            MyCoroutines(userDao).save(user)
        }
    }
    val usuariosGuardados = MutableLiveData<List<User>>()
    fun verUsuarios(){
        viewModelScope.launch{
            val userDao = DatabaseManager.instance.database.userDao()
            usuariosGuardados.value = MyCoroutines(userDao).getUsers().value
        }
    }
}