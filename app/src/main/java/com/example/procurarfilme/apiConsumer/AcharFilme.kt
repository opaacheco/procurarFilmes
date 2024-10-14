package com.example.procurarfilme.apiConsumer

import android.os.Handler
import android.os.Looper
import android.util.Log
import com.example.procurarfilme.ApiCallback
import com.example.procurarfilme.classes.Filme
import com.example.procurarfilme.classes.MovieResponse
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request
import java.util.concurrent.Executors

class AcharFilme {

    val gson = Gson()

    fun garcom(nomeFilme:String, callback: ApiCallback) {
        val client = OkHttpClient()
        // Construção da requisição
        val request = Request.Builder()
            .url("https://api.themoviedb.org/3/search/movie?query=$nomeFilme&api_key=API_KEY")
            .get()
            .addHeader("accept", "application/json")
            .addHeader(
                "Authorization",
                "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI5M2ZhZTMyNjEzYjJmNDE1NGJjNDY4Y2QxMmM1Zjk4MSIsIm5iZiI6MTcyNzcxMjE3NS4yOTU2NjYsInN1YiI6IjY2ZmFiZTg3ODA3Y2Q1MWMxN2YxOTQ2MSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.XK4kaiZxMZ9xKrtQF5YSh5HwzuruRmHs75_1kGPBcEw"
            )
            .build()
        val execut = Executors.newSingleThreadExecutor()
        val handler = Handler(Looper.getMainLooper())
        execut.execute {
            val response = client.newCall(request).execute()
            handler.post {
                val dataTratado = response.body?.string()
                Log.v("MainActivity", dataTratado.toString())
                val movieResponse = gson.fromJson(dataTratado, MovieResponse::class.java)
                val filmes = movieResponse.results
                callback.onSuccess(filmes)
                //val response = movieResponse.results.toString()
                Log.v("MainActivity", movieResponse.results.toString())
            }
        }
    }
}