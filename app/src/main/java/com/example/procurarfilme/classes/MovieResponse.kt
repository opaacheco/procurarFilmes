package com.example.procurarfilme.classes

class MovieResponse(val page: Int, val results: List<Filme>, val total_pages: Int, val total_results: Int) {
}