package org.lotka.xenonx.domain.usecase

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.lotka.xenonx.domain.model.Note
import org.lotka.xenonx.domain.repository.NoteRepository
import org.lotka.xenonx.domain.util.SortType

class GetNotesSortType(
    private val repository: NoteRepository
) {
    operator fun invoke(
       sortType : SortType = SortType.SORTBYDATE
    ): Flow<List<Note>> {
        return repository.getNotes().map { notes ->
          when(sortType) {
              SortType.SORTBYTITLE -> notes.sortedBy { it.title }
              SortType.SORTBYDATE -> notes.sortedBy { it.timestamp }
              SortType.SORTBYCOLOR -> notes.sortedBy { it.color }
          }


        }

    }
}