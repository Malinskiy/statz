package com.malinskiy.statz.entity

import com.malinskiy.statz.entity.base.CommitMetric
import com.malinskiy.statz.extensions.parse
import kotlin.properties.Delegates

class TestSuiteMetric : CommitMetric(TestSuiteMetric::class.simpleName) {
    var suiteName: String by Delegates.parse()
    var success: Boolean by Delegates.parse()
    var coverage: Double by Delegates.parse()
    var time: Double by Delegates.parse()
    var cases: MutableList<TestFileMetric> by Delegates.parse()
}