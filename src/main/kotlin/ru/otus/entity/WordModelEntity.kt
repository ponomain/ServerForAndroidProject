package ru.otus.entity

import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.hibernate.Hibernate
import ru.otus.dto.WordModel
import ru.otus.enumeration.WordType

@Entity
data class WordModelEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long,
    val title: String,
    val wordDescription: String,
    var likedByMe: Boolean = false,
    val image: String,
    @Enumerated(EnumType.STRING)
    val wordType: WordType = WordType.NONE
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as WordModelEntity

        return id != null && id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id )"
    }

    fun toDto() = WordModel(
        id,
        title,
        wordDescription,
        likedByMe,
        image
    )

    companion object {
        fun fromDto(dto: WordModel) = WordModelEntity(
            dto.id,
            dto.title,
            dto.wordDescription,
            dto.likedByMe,
            dto.image
        )
    }
}