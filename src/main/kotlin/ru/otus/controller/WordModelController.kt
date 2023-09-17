package ru.otus.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import ru.otus.enumeration.WordType
import ru.otus.service.WordModelService

@RestController
@RequestMapping("/api/word-model")
class WordModelController(private val wordModelService: WordModelService) {

    @GetMapping()
    fun getAll() = wordModelService.getAll()

    @GetMapping("/type/{type}")
    fun getAllByType(@PathVariable type: String) = wordModelService.getAllByType(type)

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long) = wordModelService.getById(id)

    @GetMapping("/favorites")
    fun getAllFavorites() = wordModelService.getByFavorites()

    @PutMapping("/{id}/true")
    fun markWordAsFavorite(@PathVariable id: Long) = wordModelService.markWordAsFavorite(id)

    @PutMapping("/{id}/false")
    fun unmarkWordAsFavorite(@PathVariable id: Long) = wordModelService.unmarkWordAsFavorite(id)

}