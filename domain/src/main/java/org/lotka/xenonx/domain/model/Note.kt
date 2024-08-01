package org.lotka.xenonx.domain.model

import org.lotka.xenonx.presentation.theme.BabyBlue
import org.lotka.xenonx.presentation.theme.LightGreen
import org.lotka.xenonx.presentation.theme.RedOrange
import org.lotka.xenonx.presentation.theme.RedPink
import org.lotka.xenonx.presentation.theme.Violet


data class Note(
    val title: String,
    val content: String,
    val timestamp: Long,
    val color: Int,
    val id: Int? = null
) {
    companion object {
        val noteColors = listOf(RedOrange, LightGreen, Violet, BabyBlue, RedPink)
    }
}

class InvalidNoteException(message: String): Exception(message)