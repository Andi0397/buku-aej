package com.example.buku

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BukuApplication

fun main(args: Array<String>) {
	runApplication<BukuApplication>(*args)
}
