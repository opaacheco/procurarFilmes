package com.example.procurarfilme

import com.example.procurarfilme.classes.Filme

interface ApiCallback {
        fun onSuccess(filmes: List<Filme>)
        fun onFailure(error: String)
}
