package com.malinskiy.statz.log

class SystemOutLogger : Logger {
    override fun d(v: String) {
        System.out.println("D: $v")
    }
}