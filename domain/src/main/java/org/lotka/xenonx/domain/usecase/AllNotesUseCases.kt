package org.lotka.xenonx.domain.usecase

data class AllNotesUseCases(
    val getNotes: GetNotesUseCase,
    val deleteNote: DeleteNoteUseCase,
    val addNote: InsertNoteUseCase,
    val getNoteById: GetNoteByIdUseCase
)
