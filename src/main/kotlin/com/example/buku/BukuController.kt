package com.example.buku

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/buku")
class BukuController {
    @Autowired
    private lateinit var bukuService: BukuService

    @GetMapping("/ping_buku")
    fun ping(): BaseResponse<String>{
        return BaseResponse(
            status = true,
            message = "Ping Buku Berhasil",
            data = "Ini versi buku"
        )
    }

    @GetMapping
    fun getBuku(): BaseResponse<List<Buku>>{
        return BaseResponse(
            status = true,
            message = "Sukses",
            data = bukuService.getBuku()
        )
    }

    @PostMapping
    fun addBuku(
        //yg dimasukkan langsung dataBuku karena datanya banyak yang disimpan
        @RequestBody dataBuku: Buku): BaseResponse<List<Buku>>{
//        listBuku.add(dataBuku)
        return BaseResponse(
            status = true,
            message = "Sukses",
            data = bukuService.addBuku(dataBuku)
        )
    }

    @GetMapping("/{namaBuku}")
    fun getBukuByNama(
        @PathVariable(value = "namaBuku") namabuku: String
    ): BaseResponse<Buku> {
//        val cariBuku = listBuku.find { it.namaBuku == namabuku }
        return BaseResponse(
            status = true,
            message = "Sukses",
            data = bukuService.getBukuByNama(namabuku)
        )
    }

    @DeleteMapping("/{namaBuku}")
    fun getDeleteBukuByNama(
        @PathVariable(value = "namaBuku") namabuku: String
    ): BaseResponse<String> {
//        val cariBuku = listBuku.removeAll { it.namaBuku == namabuku }
        bukuService.getDeleteBukuByNama(namabuku)
        return BaseResponse(
            status = true,
            message = "Sukses",
            data = "Hapus buku berhasil"
        )
    }

    @PostMapping("/Update_{namaBuku}")
    fun getUpdateBukuByNama(
        @PathVariable(value = "namaBuku") namabuku: String,
        @RequestBody dataBuku: Buku
    ): BaseResponse<String> {
        //versi baru
//        var dataLama = listBuku.find{
//            it.namaBuku == namabuku
//        }
//        dataLama?.namaBuku = dataBuku.namaBuku
//        dataLama?.pengarangBuku = dataBuku.pengarangBuku
//        dataLama?.penerbitBuku = dataBuku.penerbitBuku
        //versi lama
//        val cariBuku = listBuku.find {
//            it.namaBuku == namabuku
//        }.run {
//            val index = listBuku.indexOf(this)
//            listBuku[index] = dataBuku
//            Result.success(listBuku)
//        }
        bukuService.getUpdateBukuByNama(namabuku, dataBuku)
        return BaseResponse(
            status = true,
            message = "Sukses",
            data = "Update Buku Berhasil"
        )
    }
}