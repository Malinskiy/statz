package com.malinskiy.statz.interactor

import com.natpryce.hamkrest.assertion.assert
import com.natpryce.hamkrest.equalTo
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

class ParseJUnitXMLInteractorTest : Spek({
    describe("Interactor") {
        it("should properly parse junit output sample 1") {


            ParseJUnitXMLInteractor("1", "0abcdef", loadTestFile("junit/sample_1")).execute()
        }

        it("should properly parse junit output sample 2") {
            ParseJUnitXMLInteractor("1", "0abcdef", loadTestFile("junit/sample_2")).execute()
        }

        it("should properly parse junit output sample 3") {
            val suite = ParseJUnitXMLInteractor("1", "0abcdef", loadTestFile("junit/sample_3")).execute()

            assert.that(suite.success, equalTo(false))
        }
    }
})