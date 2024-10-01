package com.example.procurarfilme.apiConsumer

import android.os.Handler
import android.os.Looper
import android.util.Log
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request
import java.util.concurrent.Executors

class AcharFilme {

    val gson = Gson()

    fun garcom() {
        // Criação do cliente HTTP
        val client = OkHttpClient()

        // Construção da requisição
        val request = Request.Builder()
            .url("https://api.themoviedb.org/3/search/movie?query=alien&api_key=API_KEY")
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
                //val movieResponse = gson.fromJson(dataTratado, filme::class.java)
                Log.v("MainActivity", "pedroca = $dataTratado")

            }

        }

    }
}