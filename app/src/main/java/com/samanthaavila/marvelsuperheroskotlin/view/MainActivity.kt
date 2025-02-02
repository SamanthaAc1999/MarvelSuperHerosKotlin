package com.samanthaavila.marvelsuperheroskotlin.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.samanthaavila.marvelsuperheroskotlin.R
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
    }

    private fun getData() {
        val service = RetrofitService.RetrofitServiceFactory.makeRetrofitService() //Va construir mi llamado
        // lifycicle permite mandarlo en hilo secundario, no afecta al principal
        lifecycleScope.launch {
            val MarvelsResponse = service.getMarvels("c51ad311d4800ee7e959e4cb34f929b8")
            MarvelsResponse.data.results.forEach { character ->
                println(character.name)
            }
        }
    }

}