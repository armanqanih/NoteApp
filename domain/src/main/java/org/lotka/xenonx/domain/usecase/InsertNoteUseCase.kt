package org.lotka.xenonx.domain.usecase

import org.lotka.xenonx.domain.model.Note
import org.lotka.xenonx.domain.repository.NoteRepository
import org.lotka.xenonx.domain.usecase.validation.InvalidateNoteException

class InsertNoteUseCase(
    private val repository: NoteRepository,

    ) {
    @Throws(InvalidateNoteException::class)
    suspend operator fun invoke(note: Note) {
        if (note.title.isBlank()) {
            throw InvalidateNoteException("Title cannot be empty")
        }
        if (note.content.isBlank()) {
            throw InvalidateNoteException("Content cannot be empty")
        }
        repository.insertNote(note)
    }


}