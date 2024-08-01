package org.lotka.xenonx.domain.usecase

import org.lotka.xenonx.domain.model.Note
import org.lotka.xenonx.domain.repository.NoteRepository

class DeleteNoteUseCase (
    private val repository: NoteRepository

){
    suspend operator fun invoke(note: Note) {
        repository.deleteNote(note)
    }



}