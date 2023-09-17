package ru.otus.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.otus.dto.WordModel
import ru.otus.enumeration.WordType
import ru.otus.exception.NotFoundException
import ru.otus.repository.WordModelEntityRepository

@Service
@Transactional
class WordModelService(
    private val wordModelEntityRepository: WordModelEntityRepository
) {

    fun getAllByType(wordType: String): Map<Long, String> {
        val words = wordModelEntityRepository.findAll().filter { it.wordType == WordType.valueOf(wordType) }
        val idsToTitles = mutableMapOf<Long, String>()
        words.forEach {
            idsToTitles.put(it.id, it.title)
        }
        return idsToTitles
    }

    fun getAll(): List<WordModel> {
        return wordModelEntityRepository.findAll().map { it.toDto() }
    }

    fun getById(id: Long): WordModel {
        return wordModelEntityRepository.findById(id).orElseThrow(::NotFoundException).toDto()
    }

    fun getByFavorites(): List<WordModel> {
        return wordModelEntityRepository.findAll().filter { it.likedByMe }.map { it.toDto() }
    }

    fun markWordAsFavorite(id: Long) {
        wordModelEntityRepository.findById(id).ifPresent {
            it.likedByMe = true
            wordModelEntityRepository.save(it)
        }
    }

    fun unmarkWordAsFavorite(id: Long) {
        wordModelEntityRepository.findById(id).ifPresent {
            it.likedByMe = false
            wordModelEntityRepository.save(it)
        }
    }
}