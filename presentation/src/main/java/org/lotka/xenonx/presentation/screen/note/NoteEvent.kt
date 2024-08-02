package org.lotka.xenonx.presentation.screen.note

import org.lotka.xenonx.domain.model.Note
import org.lotka.xenonx.domain.util.NoteOrder

sealed class NoteEvent {
    data class Order(val noteOrder: NoteOrder): NoteEvent()
    data class DeleteNote(val note: Note): NoteEvent()
    object ToggleOrderSection : NoteEvent()
    object CancelDeleter : NoteEvent()

}