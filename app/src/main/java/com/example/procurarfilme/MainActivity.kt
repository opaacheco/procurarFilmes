package com.example.procurarfilme

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.procurarfilme.apiConsumer.AcharFilme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val api = AcharFilme()
        api.garcom()
        listarFilmes()
    }
    fun listarFilmes(){
        val llContainer = findViewById<LinearLayout>(R.id.listagem)
        for(i in 6 downTo 0 step 1){
            val newTextView = LayoutInflater.from(this).inflate(R.layout.filme, null, false)
            llContainer.addView(newTextView)
        }
    }
}