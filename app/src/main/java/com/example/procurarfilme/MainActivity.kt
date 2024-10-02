package com.example.procurarfilme

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.procurarfilme.apiConsumer.APiCallback
import com.example.procurarfilme.apiConsumer.AcharFilme
import com.example.procurarfilme.classes.Filme


class MainActivity : AppCompatActivity(), APiCallback {
    lateinit var listFilmes:MutableList<Filme>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //listarFilmes()
        listFilmes = ArrayList()
    }

    override fun onSuccess(filme: List<Filme>)
    {
        // Aqui você pode tratar a resposta como quiser
        // Atualizar a UI com as informações do filme, etc.
    }

    override fun onFailure(filme: List<Filme>)
    {
        // Aqui você pode tratar a resposta como quiser
        // Atualizar a UI com as informações do filme, etc.
    }

    fun pesquisarFilme(v: View)
    {
        val api = AcharFilme()
        val nomeFilmePesquisar = findViewById<EditText>(R.id.nomeDoFilme)
        val filme = nomeFilmePesquisar.text.toString()
        Log.v("MainActivity",filme)
        api.garcom(filme, this)
    }

//    fun listarFilmes(){
//        val llContainer = findViewById<LinearLayout>(R.id.listagem)
//        for(i in 6 downTo 0 step 1){
//            val newTextView = LayoutInflater.from(this).inflate(R.layout.filme, null, false)
//            llContainer.addView(newTextView)
//        }
//    }
}

