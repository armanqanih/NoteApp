package org.lotka.xenonx.di

import dagger.Binds
import dagger.Provides
import org.lotka.xenonx.data.repository.NoteRepositoryImpl
import org.lotka.xenonx.domain.repository.NoteRepository

abstract class RepositoryModule {

    @Binds
    @Provides
    abstract fun bindNoteRepository(noteRepositoryImpl: NoteRepositoryImpl): NoteRepository


}