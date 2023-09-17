package ru.otus.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.hibernate.Hibernate
import ru.otus.dto.WordModel

@Entity
data class WordModelEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long,
    @Column(columnDefinition = "TEXT")
    val title: String,
    val likedByMe: Boolean = false
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
        likedByMe
    )

    companion object {
        fun fromDto(dto: WordModel) = WordModelEntity(
            dto.id,
            dto.title,
            dto.likedByMe
        )
    }
}