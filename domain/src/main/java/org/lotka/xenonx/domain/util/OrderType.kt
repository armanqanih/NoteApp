package org.lotka.xenonx.domain.util

sealed class OrderType {
    object Ascending: OrderType()
    object Descending: OrderType()
}