package ru.otus.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.otus.dto.Word
import ru.otus.entity.WordEntity
import ru.otus.exception.NotFoundException
import ru.otus.repository.WordEntityRepository

@Service
@Transactional
class WordService(
    private val wordEntityRepository: WordEntityRepository
) {
    fun getAll(): List<Word> {
        return wordEntityRepository.findAll().map { it.toDto() }
    }

    fun getById(id: Long): Word {
        return wordEntityRepository.findById(id).orElseThrow(::NotFoundException).toDto()
    }

    fun save(dto: Word): Word {
        return wordEntityRepository.save(WordEntity.fromDto(dto)).toDto()
    }

    fun removeById(id: Long) {
        wordEntityRepository.findById(id).ifPresent { wordEntityRepository.delete(it) }
    }
}