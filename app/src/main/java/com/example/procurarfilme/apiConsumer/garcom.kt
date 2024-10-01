package com.example.procurarfilme.apiConsumer

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response

fun acharFilme() {

    // Criação do cliente HTTP
    val client = OkHttpClient()

    // Construção da requisição
    val request = Request.Builder()
        .url("https://api.themoviedb.org/3/alien/movie_id?language=en-US")
        .get()
        .addHeader("accept", "application/json")
        .addHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI5M2ZhZTMyNjEzYjJmNDE1NGJjNDY4Y2QxMmM1Zjk4MSIsIm5iZiI6MTcyNzcxMjE3NS4yOTU2NjYsInN1YiI6IjY2ZmFiZTg3ODA3Y2Q1MWMxN2YxOTQ2MSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.XK4kaiZxMZ9xKrtQF5YSh5HwzuruRmHs75_1kGPBcEw")
        .build()

    // Execução da requisição
    val bolota = client.newCall(request).execute()


}