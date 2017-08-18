package com.malinskiy.statz.module

import org.parse4j.Parse

class ParseModule {
    init {
        Parse.initialize("id", "key")
    }
}