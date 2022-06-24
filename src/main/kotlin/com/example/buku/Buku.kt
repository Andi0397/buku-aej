package com.example.buku

import java.util.*

data class Buku (
    var id : String = UUID.randomUUID().toString(),
    var namaBuku: String = "",
    var pengarangBuku: String = "",
    var penerbitBuku: String = ""
)