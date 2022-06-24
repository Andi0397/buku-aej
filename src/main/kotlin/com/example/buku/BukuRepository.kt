package com.example.buku

interface BukuRepository {
    fun getBuku(): List<Buku>
    fun addBuku(buku: Buku): List<Buku>
    fun getBukuByNama(name: String): Buku?
    fun getDeleteBukuByNama(name: String): String
    fun getUpdateBukuByNama(name: String, buku: Buku): String
}