package com.samanthaavila.marvelsuperheroskotlin.main.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.samanthaavila.marvelsuperheroskotlin.databinding.ActivityMainBinding
import com.samanthaavila.marvelsuperheroskotlin.networkmanager.RetrofitServiceFactory
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getData()
    }

    private fun getData() {
        val service = RetrofitServiceFactory.makeRetrofitService() //Va construir mi llamado
        // lifycicle permite mandarlo en hilo secundario, no afecta al principal
        lifecycleScope.launch {
            val MarvelsResponse = service.getMarvels(
                "1",
                "c51ad311d4800ee7e959e4cb34f929b8",
                "0a96e3bd6d9eb58e31998051c1c686ca")
            val characters = MarvelsResponse.data.results
            print(characters)
            MarvelsResponse.data.results.forEach { character ->
                println(character.name)
            }
        }
    }

    //ts=1&apikey=c51ad311d4800ee7e959e4cb34f929b8&hash=0a96e3bd6d9eb58e31998051c1c686ca

}