package ru.otus.controller

import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.otus.dto.Word
import ru.otus.service.WordService

@RestController
@RequestMapping("/api/word")
class WordController(private val wordService: WordService) {

    @GetMapping
    fun getAll() = wordService.getAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long) = wordService.getById(id)

    @PostMapping
    fun save(@RequestBody dto: Word) = wordService.save(dto)

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: Long) = wordService.removeById(id)
}