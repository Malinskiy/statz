package com.malinskiy.statz.mapper

interface Mapper<in I : Any, out O : Any> {

    fun map(input: I): O

}