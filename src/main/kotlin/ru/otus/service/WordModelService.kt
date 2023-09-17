package ru.otus.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.otus.dto.WordModel
import ru.otus.entity.WordModelEntity
import ru.otus.exception.NotFoundException
import ru.otus.repository.WordModelEntityRepository

@Service
@Transactional
class WordModelService(
    private val wordModelEntityRepository: WordModelEntityRepository
) {

    fun getAll(): List<WordModel> {
        return wordModelEntityRepository.findAll().map { it.toDto() }
    }

    fun getById(id: Long): WordModel {
        return wordModelEntityRepository.findById(id).orElseThrow(::NotFoundException).toDto()
    }

    fun save(dto: WordModel): WordModel {
        return wordModelEntityRepository.save(WordModelEntity.fromDto(dto)).toDto()
    }

    fun removeById(id: Long) {
        wordModelEntityRepository.findById(id).ifPresent { wordModelEntityRepository.delete(it) }
    }
}