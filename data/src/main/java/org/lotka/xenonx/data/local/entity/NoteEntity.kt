package org.lotka.xenonx.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.lotka.xenonx.domain.model.Note

@Entity(tableName = "noteentity")
data class NoteEntity(
    val title: String,
    val content: String,
    val timestamp: Long,
    val color: Int,
    @PrimaryKey val id: Int? = null
)


fun NoteEntity.toNote() = Note(
    title = title,
    content = content,
    timestamp = timestamp,
    color = color,
    id = id
)

fun Note.toNoteEntity() = NoteEntity(
    title = title,
    content = content,
    timestamp = timestamp,
    color = color,
    id = id
)

