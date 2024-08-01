package org.lotka.xenonx.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.lotka.xenonx.data.local.NoteDao
import org.lotka.xenonx.data.local.entity.toNote
import org.lotka.xenonx.data.local.entity.toNoteEntity
import org.lotka.xenonx.domain.model.Note
import org.lotka.xenonx.domain.repository.NoteRepository
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(
  private val noteDao: NoteDao
) : NoteRepository {
    override fun getNotes(): Flow<List<Note>> {
        return flow {
            try {
                val notes = noteDao.getNotes().map { it.toNote() }
            emit(notes)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    override suspend fun getNoteById(id: Int): Note? {
       return noteDao.getNoteById(id)?.toNote()
    }

    override suspend fun insertNote(note: Note) {
        noteDao.insertNote(note.toNoteEntity())
    }

    override suspend fun deleteNote(note: Note) {
        noteDao.deleteNote(note.toNoteEntity())
    }


}