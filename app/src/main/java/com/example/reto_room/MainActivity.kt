package com.example.reto_room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.reto_room.database.DatabaseManager.Companion.instance
import com.example.reto_room.database.User
import com.example.reto_room.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val mainViewModel : MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.BtnGuardar.setOnClickListener {

            mainViewModel.guardarUsuarios(User(
                0,
                binding.User.text.toString()
            ))
            actUsuarios()
        }

    }
    fun actUsuarios(){
        mainViewModel.verUsuarios()
        mainViewModel.usuariosGuardados.observe(this){usersList ->
            if(!usersList.isNullOrEmpty()){
                for(user in usersList){
                    Log.d("Usuarios", user.user_name)

                    binding.rvUsers.adapter = MainAdapter(usersList)
                }


            }else {
                Log.d("Usuarios", "Vacío")
            }
        }
    }
}