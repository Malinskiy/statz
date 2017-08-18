package com.malinskiy.statz.extensions

import org.parse4j.ParseObject
import kotlin.properties.Delegates
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

fun <T : Any?> Delegates.parse(): ReadWriteProperty<ParseObject?, T> = ParseVar()

private class ParseVar<T : Any?> : ReadWriteProperty<ParseObject?, T> {
    override fun setValue(thisRef: ParseObject?, property: KProperty<*>, value: T) {
        thisRef?.put(property.name, value)
    }

    override fun getValue(thisRef: ParseObject?, property: KProperty<*>): T {
        return thisRef?.get(property.name) as T
    }
}

