package com.example.buku

import com.mongodb.client.MongoCollection
import org.litote.kmongo.eq
import org.litote.kmongo.findOne
import org.litote.kmongo.getCollection
import org.litote.kmongo.updateOne
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import java.lang.IllegalStateException

@Repository
class BukuRepositoryImpl: BukuRepository {
    @Autowired
    private lateinit var databaseComponent: DatabaseComponent

//    private val listBuku : MutableList<Buku> = mutableListOf()
//
//    init {
//        listBuku.addAll(
//            listOf(
//                Buku(
//                    namaBuku = "Sepatu",
//                    pengarangBuku = "Andi",
//                    penerbitBuku = "Ganu"
//                ),
//                Buku(
//                    namaBuku = "Gunung",
//                    pengarangBuku = "Budi",
//                    penerbitBuku = "Luluh"
//                )
//            )
//        )
//    }

    private fun bukuCollection() : MongoCollection<Buku> =
        databaseComponent.database.getDatabase("buku").getCollection()


    override fun getBuku(): List<Buku> {
        return bukuCollection().find().toList()
    }

    override fun addBuku(buku: Buku): List<Buku> {
//        listBuku.add(
//            Buku(
//                namaBuku = buku.namaBuku,
//                penerbitBuku = buku.penerbitBuku,
//                pengarangBuku = buku.pengarangBuku
//            )
//        )
        val bukuBaru = Buku(
            namaBuku = buku.namaBuku,
            penerbitBuku = buku.penerbitBuku,
            pengarangBuku = buku.pengarangBuku
        )
        val insertBuku = bukuCollection().insertOne(bukuBaru)
        return if (insertBuku.wasAcknowledged()) {
            getBuku()
        } else {
            throw IllegalStateException("Insert buku gagal")
        }
    }

    override fun getBukuByNama(name: String): Buku? {
//        return listBuku.find { it.namaBuku == name }
        return bukuCollection().findOne{ Buku::namaBuku eq name}
    }

    override fun getDeleteBukuByNama(name: String): String {
//        val cariBuku = listBuku.removeAll { it.namaBuku == name }
        val hapusBuku = bukuCollection().deleteOne(Buku::namaBuku eq name)
        return "Hapus buku berhasil"
    }

    override fun getUpdateBukuByNama(name: String, buku: Buku): String {
//        var dataLama = listBuku.find{
//            it.namaBuku == name
//        }
//        dataLama?.namaBuku = buku.namaBuku
//        dataLama?.pengarangBuku = buku.pengarangBuku
//        dataLama?.penerbitBuku = buku.penerbitBuku
//        return buku
        val updateBuku = bukuCollection().updateOne(Buku::namaBuku eq name, buku)
        return "Update Buku Berhasil"
    }
}