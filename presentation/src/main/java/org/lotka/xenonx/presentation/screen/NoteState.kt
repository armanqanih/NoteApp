package org.lotka.xenonx.presentation.screen

import org.lotka.xenonx.domain.model.Note
import org.lotka.xenonx.domain.util.NoteOrder
import org.lotka.xenonx.domain.util.OrderType

data class NoteState(
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false

)
