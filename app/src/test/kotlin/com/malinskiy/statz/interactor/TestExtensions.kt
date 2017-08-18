package com.malinskiy.statz.interactor

import org.jetbrains.spek.api.dsl.TestBody
import java.io.File

fun TestBody.loadTestFile(path: String): File {
    val classLoader = javaClass.classLoader
    return File(classLoader.getResource(path)!!.file)
}