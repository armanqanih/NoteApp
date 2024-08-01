package org.lotka.xenonx.presentation.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import org.lotka.xenonx.domain.model.Note
import org.lotka.xenonx.domain.usecase.AllNotesUseCases
import org.lotka.xenonx.domain.util.NoteOrder
import org.lotka.xenonx.domain.util.OrderType
import javax.inject.Inject


@HiltViewModel
class NoteViewModel @Inject constructor(
    private val useCases: AllNotesUseCases
):ViewModel() {


    private val _state = MutableStateFlow(NoteState())
    val state = _state.asStateFlow()
    private var getNoteJob: Job? = null

    private var recentlyDeleterNote : Note? = null

    init {
        viewModelScope.launch {
        getNotes(noteOrder = NoteOrder.Date(OrderType.Descending))
        }
    }


    fun onEvent(event: NoteEvent){
        when(event){
            is NoteEvent.Order -> {
                if (event.noteOrder::class == _state.value.noteOrder::class &&
                    event.noteOrder.orderType == _state.value.noteOrder.orderType
                ) {
                    return
                }

            }
            NoteEvent.ToggleOrderSection -> {
                _state.value = _state.value.copy(
                    isOrderSectionVisible = !_state.value.isOrderSectionVisible
                )
            }
            is NoteEvent.DeleteNote ->{
                viewModelScope.launch {
                    useCases.deleteNote(event.note)
                    recentlyDeleterNote = event.note
                }
            }
            NoteEvent.CancelDeleter -> {
                viewModelScope.launch {
                    useCases.addNote(recentlyDeleterNote ?: return@launch)
                    recentlyDeleterNote = null
                }

            }
        }
    }


    suspend fun getNotes(noteOrder: NoteOrder){
             getNoteJob?.cancel()
             getNoteJob = useCases.getNotes(noteOrder).onEach { notes ->
                _state.value = _state.value.copy(
                    notes = notes,
                    noteOrder = noteOrder
                )


        }.launchIn(viewModelScope)
    }


}