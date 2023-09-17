package ru.otus.repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.otus.entity.WordEntity

interface WordEntityRepository: JpaRepository<WordEntity, Long> {
}