package com.example.procurarfilme.apiConsumer


import com.example.procurarfilme.classes.Filme


interface APiCallback {
    fun onSuccess(filme: List<Filme>)
    fun onFailure(filme: List<Filme>)
}
