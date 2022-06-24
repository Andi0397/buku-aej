package com.example.buku

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class BukuServiceImpl: BukuService {
    @Autowired
    private lateinit var bukuRepository: BukuRepository

    override fun getBuku(): List<Buku> {
        return bukuRepository.getBuku()
    }

    override fun addBuku(buku: Buku): List<Buku> {
        return bukuRepository.addBuku(buku)
    }

    override fun getBukuByNama(name: String): Buku? {
        return bukuRepository.getBukuByNama(name)
    }

    override fun getDeleteBukuByNama(name: String): String {
        return bukuRepository.getDeleteBukuByNama(name)
    }

    override fun getUpdateBukuByNama(name: String, buku: Buku): String {
        return bukuRepository.getUpdateBukuByNama(name, buku)
    }
}