package ru.otus.dto

data class WordModel(
    val id: Long,
    val title: String,
    val likedByMe: Boolean = false
)