package org.lotka.xenonx.domain.usecase

import org.lotka.xenonx.domain.model.Note
import org.lotka.xenonx.domain.repository.NoteRepository

class GetNoteByIdUseCase (
    private val repository: NoteRepository
){
    suspend operator fun invoke(id: Int): Note?{
        return repository.getNoteById(id)
    }
}