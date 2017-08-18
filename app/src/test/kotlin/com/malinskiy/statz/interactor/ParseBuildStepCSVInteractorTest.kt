package com.malinskiy.statz.interactor

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

class ParseBuildStepCSVInteractorTest : Spek({
    describe("interactor") {
        it("should properly parse sample 1") {
            val buildSteps = ParseBuildStepCSVInteractor().execute("1", "0abcdef", loadTestFile("buildtimetracker/sample1.csv"))
        }
    }
})