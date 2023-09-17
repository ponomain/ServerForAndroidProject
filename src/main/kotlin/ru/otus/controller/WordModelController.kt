package ru.otus.controller

import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.otus.dto.WordModel
import ru.otus.service.WordModelService

@RestController
@RequestMapping("/api/word-model")
class WordModelController(private val wordModelService: WordModelService) {

    @GetMapping
    fun getAll() = wordModelService.getAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long) = wordModelService.getById(id)

    @PostMapping
    fun save(@RequestBody dto: WordModel) = wordModelService.save(dto)

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: Long) = wordModelService.removeById(id)
}