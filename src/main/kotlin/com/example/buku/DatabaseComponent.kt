package com.example.buku

import com.mongodb.client.MongoClient
import org.litote.kmongo.KMongo
import org.springframework.stereotype.Component

@Component
class DatabaseComponent {
    companion object {
        private const val DB_URL = "mongodb+srv://anditest:12345@cluster0.palkc.mongodb.net/?retryWrites=true&w=majority"
    }
    val database : MongoClient = KMongo.createClient(DB_URL)
}