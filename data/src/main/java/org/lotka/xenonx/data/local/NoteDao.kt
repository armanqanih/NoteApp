package org.lotka.xenonx.data.local

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import org.lotka.xenonx.data.local.entity.NoteEntity

interface NoteDao {

    @Query("SELECT * FROM noteentity")
    suspend fun getNotes(): List<NoteEntity>

    @Query("SELECT * FROM noteentity WHERE id = :id")
    suspend fun getNoteById(id: Int): NoteEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: NoteEntity)

    @Delete
    suspend fun deleteNote(note: NoteEntity)
}