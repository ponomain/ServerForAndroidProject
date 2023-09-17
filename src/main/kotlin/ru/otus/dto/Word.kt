package ru.otus.dto

data class Word(
    val id: Long,
    val content: String,
    val likedByMe: Boolean = false
)