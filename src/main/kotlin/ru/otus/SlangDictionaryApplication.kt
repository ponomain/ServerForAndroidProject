package ru.otus

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SlangDictionaryApplication

fun main(args: Array<String>) {
    runApplication<SlangDictionaryApplication>(*args)
}
