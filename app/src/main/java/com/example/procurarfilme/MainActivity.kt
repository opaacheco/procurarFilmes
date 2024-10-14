package com.example.procurarfilme

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.example.procurarfilme.apiConsumer.AcharFilme
import com.example.procurarfilme.classes.Filme

class MainActivity : AppCompatActivity(), ApiCallback {
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

    override fun onSuccess(filmes: List<Filme>) {
        val llListagem = findViewById<LinearLayout>(R.id.listagem)
        llListagem.removeAllViews()
        for (filme in filmes) {
            Log.d("MainActivity", "Título do Filme: ${filme.original_title}")
            val newTextView =LayoutInflater.from(this).inflate(R.layout.filme, null, false)
            newTextView.findViewById<TextView>(R.id.filmText).text = "Título original : "+filme.original_title
            newTextView.findViewById<TextView>(R.id.dateText).text = "Data de lançamento : "+filme.release_date
            //newTextView.findViewById<TextView>(R.id.diretorText).text = filme.
            val imgRender = newTextView.findViewById<ImageView>(R.id.imageView)
            if (filme.poster_path.isNullOrEmpty()){
                val caminhoSuplente = "/res/drawable/empty.jpg"
                Glide.with(this).load(caminhoSuplente).into(imgRender)
            }else{
                Log.v("poster", filme.poster_path)
                Glide.with(this).load("https://image.tmdb.org/t/p/w600_and_h900_bestv2" + filme.poster_path).into(imgRender)
            }
            llListagem.addView(newTextView)

        }
    }

    override fun onFailure(error: String) {
        TODO("Not yet implemented")
    }

    fun pesquisarFilme(v: View)
    {
        val api = AcharFilme()
        val nomeFilmePesquisar = findViewById<EditText>(R.id.nomeDoFilme)
        val filme = nomeFilmePesquisar.text.toString()
        api.garcom(filme, this)
    }
}

