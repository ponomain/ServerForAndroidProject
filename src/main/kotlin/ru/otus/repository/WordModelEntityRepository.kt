package ru.otus.repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.otus.entity.WordModelEntity

interface WordModelEntityRepository: JpaRepository<WordModelEntity, Long> {
}